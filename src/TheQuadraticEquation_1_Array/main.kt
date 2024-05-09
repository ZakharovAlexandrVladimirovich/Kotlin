package TheQuadraticEquation_1_Array

import kotlin.math.sqrt
import kotlin.system.exitProcess

var number = DoubleArray(3)
var a = 0.0
var b = 0.0
var c = 0.0
var del = 0.0
var sqrtD = 0.0
var j = false
var char = 'a'
const val redColor = "\u001B[31m"
const val greenColor = "\u001B[32m"
const val noColor = "\u001B[0m"

//var a b c, del, sqrtD;
fun calculatingTheRoots(b: Double, sqrtD: Double, del: Double): Pair<Double, Double> {
    if (b == 0.0 && c == 0.0) {
        println("Если 'b=c=0', то$greenColor X=0$noColor при любых значениях 'a':")
        exitProcess(0)
    }
    return Pair((-b + sqrtD) / del, (-b - sqrtD) / del)
}

fun main() {
    enterTheNumber()
    val (x1, x2) = calculatingTheRoots(b, sqrtD, del)

    println("$a x² + $b x + $c")
    println("${greenColor}x1 = $x1")
    println("X2 = $x2$noColor")
}

private fun enterTheNumber() {
    number.forEachIndexed { index, i ->
        println("Введите число ${char++}:")
        do {
            var j: Boolean
            try {
                number[index] = readln().toDouble()
                j = false
                if (number[0] == 0.0) {
                    println("${redColor}При a=0, Уравнение становится линейным\nРЕШЕНИЙ НЕТ!!!$noColor")
                    exitProcess(0)
                }
            } catch (e: NumberFormatException) {
                println("Введите число")
                j = true
            }
        } while (j)
    }
    a = number[0]
    b = number[1]
    c = number[2]
    del = 2 * a
    sqrtD = sqrt(b * b - 4 * a * c)
}

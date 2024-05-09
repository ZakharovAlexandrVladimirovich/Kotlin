package TheQuadraticEquation_2_Map

import kotlin.math.sqrt
import kotlin.system.exitProcess

var numberMap = mutableMapOf<Char, Double>()
var del = 0.0
var sqrtD = 0.0
const val redColor = "\u001B[31m"
const val greenColor = "\u001B[32m"
const val noColor = "\u001B[0m"
fun calculatingTheRoots(b: Double, sqrtD: Double, del: Double): Pair<Double, Double> {
    if (b == 0.0 && sqrtD == 0.0) {
        println("Если 'b = c = 0', то$greenColor X = 0$noColor при любых значениях 'a':")
        exitProcess(0)
    }
    return Pair((-b + sqrtD) / del, (-b - sqrtD) / del)

}

fun main() {
    enterTheNumber()
    val (x1, x2) = calculatingTheRoots(numberMap['b']!!,sqrtD, del)
    println("${numberMap['a']!!} x² + ${numberMap['b']!!} x +${numberMap['c']!!} = 0")
    println("${greenColor}x1 = $x1")
    println("X2 = $x2$noColor")

}

private fun enterTheNumber() {
    var char = 'a'
    do {
        println("Введите число ${char}:")
        try {
            numberMap[char++] = readln().toDouble()
            if (numberMap['a'] == 0.0) {
                println("${redColor}При a=0, Уравнение становится линейным\nРЕШЕНИЙ НЕТ!!!$noColor")
                exitProcess(0)

            }
        } catch (e: NumberFormatException) {
            println("Можно вводить только числа:")
            char--
        }
    } while (char != 'd')
    del = 2 * numberMap['a']!!
    sqrtD = sqrt(numberMap['b']!! * numberMap['b']!! - 4 * numberMap['a']!! * numberMap['c']!!)
}

import java.math.BigInteger
import kotlin.system.measureTimeMillis

// ProjectEuler
// Created: 6/26/20 12:34 AM

fun main() {
    val t = measureTimeMillis {
        println(powerDigitSum(3) == 8)
        println(powerDigitSum(4) == 7)
        println(powerDigitSum(7) == 11)
//        println(powerDigitSum(15) == 26)
//        println(powerDigitSum(128) == 166)
//        println(powerDigitSum(1000) == 1366)
    }
    println("Time: $t")
}

fun powerDigitSum(i: Int): Int {
    var x = BigInteger.valueOf(2L).pow(i)
//    println(x)
    var sum = BigInteger.ZERO
    while (x > BigInteger.ZERO) {
        sum += x % BigInteger.TEN
        x /= BigInteger.TEN
    }
    return sum.toInt()
}
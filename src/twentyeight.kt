import java.math.BigInteger
import kotlin.system.measureTimeMillis

// ProjectEuler
// Created: 7/14/20 11:43 PM

fun main() {
    val t = measureTimeMillis {
//        (1..2).forEach {
        println(spiralDiagonal(BigInteger.valueOf(3)) == 25)
        println(spiralDiagonal(BigInteger.valueOf(5)) == 101)
        println(spiralDiagonal(BigInteger.valueOf(5555555555555)) == 101)
//        }
    }
    println("Time: $t")
}

fun spiralDiagonal(i: BigInteger): Int {
    if (i == BigInteger.ONE) return 1
    var x = i * i
    var diff = i - BigInteger.ONE
    var sum = BigInteger.ONE // Start with 1 for the center square
    while (x > BigInteger.ONE) {
        (1..4).forEach {
            sum += x
            x -= diff
        }
        diff -= BigInteger.valueOf(2L)
    }
    val value = (sum % BigInteger.valueOf(1000000007)).toInt()
    println("Returning $value")
    return value
}
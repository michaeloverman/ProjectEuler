import java.math.BigInteger
import kotlin.system.measureTimeMillis

// ProjectEuler
// Created: 7/6/20 8:06 PM

fun main() {
    val t = measureTimeMillis {
        println(factSum(100) == 18)
        println(factSum(3) == 6)
        println(factSum(6) == 9)
    }
    println("Time: $t")
}

fun factSum(x: Int): Int {
    var s = fact(x.toLong())
    var sum = 0
    while (s > BigInteger.ZERO) {
        sum += (s % BigInteger.valueOf(10L)).toInt()
        s /= BigInteger.valueOf(10L)
    }
    return sum
}
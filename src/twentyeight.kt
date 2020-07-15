import java.math.BigInteger
import kotlin.system.measureTimeMillis

// ProjectEuler
// Created: 7/14/20 11:43 PM

fun main() {
    val t = measureTimeMillis {
//        (1..2).forEach {
        println(spiralDiagonal(BigInteger.valueOf(3)) == BigInteger.valueOf(25))
        println(spiralDiagonal(BigInteger.valueOf(5)) == BigInteger.valueOf(101))
        println(spiralDiagonal(BigInteger.valueOf(7)) == BigInteger.valueOf(261))
        println(spiralDiagonal(BigInteger.valueOf(5555555555555)) == BigInteger.valueOf(101))
//        }
    }
    println("Time: $t")
}

fun spiralDiagonal(n: BigInteger): BigInteger {
//    if (n == BigInteger.ONE) return BigInteger.ONE
    val i = (n - BigInteger.ONE) / BigInteger.valueOf(2L)
    // First attempt: my approach, brute force
//    var x = i * i
//    var diff = i - BigInteger.ONE
//    var sum = BigInteger.ONE // Start with 1 for the center square
//    while (x > BigInteger.ONE) {
//        (1..4).forEach {
//            sum += x
//            x -= diff
//        }
//        diff -= BigInteger.valueOf(2L)
//    }
//    val value = (sum % BigInteger.valueOf(1000000007)).toInt()

    // Second attempt after reducing above to fomula. Recursive call causes stack overflow...
//    var value = (BigInteger.valueOf(4) * i * i) - (BigInteger.valueOf(6) * (i - BigInteger.ONE)) + spiralDiagonal(i - BigInteger.valueOf(2))

    // With help from: https://www.mathblog.dk/project-euler-28-sum-diagonals-spiral/ for the formula, adjusted for integer arithmetic
    // f(n) = 16/3x3 + 10x2 + 26/3x + 1
    var value = (((BigInteger.valueOf(16) * i * i * i ) + (BigInteger.valueOf(30) * i * i) + (BigInteger.valueOf(26) * i) + BigInteger.valueOf(3L)) / BigInteger.valueOf(3L)) % BigInteger.valueOf(1000000007)

    println("Returning $value")
    return value
}
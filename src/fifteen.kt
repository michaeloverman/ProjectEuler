import java.math.BigInteger
import kotlin.system.measureTimeMillis

// ProjectEuler
// Created: 6/23/20 11:58 PM

fun main() {
    val t = measureTimeMillis {
        println(factorialApproach(2, 2) == 6)
        println(factorialApproach(3, 2) == 10)
//        println(latticePaths(9) == 48620L)
//        println(latticePaths(20) == 137846528820L)
    }
    println("Time: $t")
}

fun latticePaths(s: Int): Long {
    var loc = Pair(0, 0)
//    return countPaths(loc, s) // this took 36 minutes
    return efficient(s) // this took 2 milliseconds. hooray maths!
}
fun factorialApproach(n: Int, m: Int): Int {
    var i: Int
    var j: Int
    if (n < m) { i = m; j = n } else { i = n; j = m }
    var a = fact((i+j).toLong())
    var b = fact(i.toLong())
    var c = fact(j.toLong())
    var z = ((a / (b * c)).mod(BigInteger.valueOf(1000000007L))).toInt()
    println("$n, $m: $z")
    return z
}

fun fact(i: Long): BigInteger {
    if (i == 0L) return BigInteger.ONE
    var prod = BigInteger.valueOf(i)
    for (x in i-1 downTo 2) prod *= BigInteger.valueOf(x)
//    println("$i! = $prod")
    return prod
}

private fun efficient(n: Int): Long {
    var i = 1
    var c = 1L
    while (i <= n) {
        c = c * (n + i) / i
        i++
    }
    return c
}

private fun countPaths(p: Pair<Int, Int>, s: Int): Long {
    if (p.first == s && p.second == s - 1) return 1L
    if (p.first == s - 1 && p.second == s) return 1L
    var n = 0L
    if (p.first + 1 <= s) n += countPaths(Pair(p.first + 1, p.second), s)
    if (p.second + 1 <= s) n += countPaths(Pair(p.first, p.second + 1), s)
    return n
}
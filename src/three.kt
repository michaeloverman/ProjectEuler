import kotlin.math.log2
import kotlin.math.sqrt

fun main(args: Array<String>) {
    println(largestPrimeFactor(2) == 2L)
    println(largestPrimeFactor(3) == 3L)
    println(largestPrimeFactor(5) == 5L)
    println(largestPrimeFactor(7) == 7L)
    println(largestPrimeFactor(8) == 2L)
    println(largestPrimeFactor(13195) == 29L)
    println(largestPrimeFactor(600851475143) == 6857L)
    println(largestPrimeFactor(1000000000000) == 5L)
}

fun largestPrimeFactor(n: Long): Long {
    var x = n shr log2((n and -n).toDouble()).toInt()
    if (x == 1L) return 2
    var i = 3L
    var sq = sqrt(x.toDouble())
    while (i <= sq) {
        if (x % i == 0L) {
//            println("dividing $x by $i")
            x /= i
            sq = sqrt(x.toDouble())
            i = 3L
        } else {
            i += 2
        }
    }
//    println ("X: $x, I: $i")
    if (x > 2) return x else return i
}

fun DRAFTlargestPrimeFactor(n: Long): Long {
    if (isPrime(n)) return n
    (sqrt(n.toDouble()).toLong() downTo 2).forEach {
        if (n % it == 0L && isPrime(it)) return it
    }
    return 1
}

fun isPrime(n: Long): Boolean {
    (2..n/2).forEach {
        if (n % it == 0L) return false
    }
    return true
}
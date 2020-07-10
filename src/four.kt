import java.time.Instant.now
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val start = measureTimeMillis {
//        println(largestPalindromeProduct(2) == 9009)
//        println(largestPalindromeProduct(3) == 906609)
        println(HRlpp(101110) == 101101)
        println(HRlpp(800000) == 793397)
//        println("54345: ${isPalindrome(54345.toString())}")
    }
    println("Time: $start")
}

fun HRlpp(n: Int): Int {
    (n-1 downTo 101100).forEach { i ->
        if (isPalindrome(i.toString())) {
            println("checking: $i")
            if (findFactors(i)) return i
        }
    }
    return 101101
}

fun largestPalindromeProduct(n: Int): Int {
    var max = "9".repeat(n).toInt()
    var min = "1${"0".repeat(n-1)}".toInt()
    var arr = mutableSetOf<Int>()

    (min..max).forEach { x ->
        (x..max).forEach { y ->
            arr.add(x * y)
        }
    }
    arr = arr.filter { isPalindrome(it.toString()) }.sorted().toMutableSet()
    return arr.last()
}

fun isPalindrome(s: String) =
    s.substring(0, s.length/2) == s.substring(s.length/2 + s.length % 2).reversed()

fun findFactors(n: Int): Boolean {
    (100..999).forEach { i ->
        if (n % i == 0 && n / i < 1000) {
            println("$n / $i == ${n/i}")
            return true
        }
    }
    return false
}
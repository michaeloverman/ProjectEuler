import kotlin.math.sqrt
import kotlin.system.measureTimeMillis

// ProjectEuler
// Created: 6/13/20 5:42 PM

fun main() {
    val t = measureTimeMillis {
        println(divisibleTriangleNumber(5) == 28)
        println(divisibleTriangleNumber(23) == 630)
        println(divisibleTriangleNumber(167) == 1385280)
        println(divisibleTriangleNumber(374) == 17907120)
        println(divisibleTriangleNumber(500) == 76576500)
        println(divisibleTriangleNumber(1000) == 842161320)
    }
    println("Time: $t")
}

fun divisibleTriangleNumber(n: Int): Int {
    var tri = 0
    var count = 0
    while (count < Int.MAX_VALUE) {
        count++
        tri += count
        var num = numDivisors(tri)
        if (num > n) return tri
    }
    return 0
}

var divCache = mutableMapOf<Int, Int>()
fun numDivisors(x: Int): Int {
    if (divCache.contains(x)) return divCache.get(x)!!
    var set = mutableSetOf<Int>()
    (1..sqrt(x.toDouble()).toInt()).forEach {
        if (x % it == 0) {
            set.add(it)
            set.add(x / it)
        }
    }
    divCache.put(x, set.size)
    return set.size
}

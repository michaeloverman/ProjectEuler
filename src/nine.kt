import kotlin.system.measureTimeMillis

// ProjectEuler
// Created: 6/13/20 12:25 AM

fun main() {
    val t = measureTimeMillis {
        println(specialPythagoreanTriplet(24) == 480L)
        println(specialPythagoreanTriplet(12) == 60L)
        println(specialPythagoreanTriplet(4) == -1L)
        println(specialPythagoreanTriplet(120) == 60000L)
        println(specialPythagoreanTriplet(1000) == 31875000L)
    }
    println("Time: $t")
}

fun specialPythagoreanTriplet(n: Int): Long {
    var x = n / 3 - 1
    (x downTo 1).forEach { a ->
        for(b in a + 1..n) {
            val c = n - a - b
            if (c <= b) break
//            println("checking: $a + $b + $c")
            if (isTriple(a, b, c)) return a * b * c.toLong()
        }
    }
    return -1L
}

fun isTriple(a: Int, b: Int, c: Int): Boolean =
        (a * a) + (b * b) == (c * c)

import kotlin.system.measureTimeMillis

// ProjectEuler
// Created: 7/7/20 7:55 PM

fun main() {
    val t = measureTimeMillis {
        println(sumAPairs(300) == 504)
    }
    println("Time: $t")
}

val amps = listOf(220, 284, 1184, 1210, 2620, 2924, 5020, 5564, 6232, 6368, 10744, 10856, 12285, 14595, 17296, 18416, 63020, 76084, 66928, 66992, 67095, 71145, 69615, 87633, 79750, 88730)
fun sumAPairs(n: Int): Int {
    return amps.filter { it < n }.sum()
}
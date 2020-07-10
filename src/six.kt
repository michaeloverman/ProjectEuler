import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val t = measureTimeMillis {
        println(sumSquareDifference(10) == 2640)
        println(sumSquareDifference(20) == 41230)
        println(sumSquareDifference(100) == 25164150)
    }
    println("Time: $t")
}

fun sumSquareDifference(n: Int): Int {
    var x = 0
    var y = 0
    (1..n).forEach {
        x += it * it
        y += it
    }
    return (y * y) - x
}
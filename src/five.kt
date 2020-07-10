import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val t = measureTimeMillis {
        println(smallestMult(5) == 60)
        println(smallestMult(7) == 420)
        println(smallestMult(10) == 2520)
        println(smallestMult(13) == 360360)
        println(smallestMult(20) == 232792560)
    }
    println("Time: $t")
}

fun smallestMult(n: Int): Int {
    var x = n
    while (!isFactor(x, n)) x += n
    return x
}
 fun isFactor(x: Int, n: Int): Boolean {
     (2..n).forEach {
         if (x % it != 0) return false
     }
     return true
 }
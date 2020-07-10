import kotlin.system.measureTimeMillis

// ProjectEuler
// Created: 6/13/20 4:33 PM

/******************************
 * TAKES 6.5 MINUTES !!!!!!!
 ******************************/

fun main() {
    val t = measureTimeMillis {
        cache.add(0, 0)
        cache.add(1, 2)
        println(primeSummation(5) == 10L)
        println(primeSummation(10) == 17L)
        println(primeSummation(18) == 41L)
//        println(primeSummation(24) == 277050L)
        println(primeSummation(2000) == 277050L)
        println(primeSummation(140758) == 873608362L)
//        println(primeSummation(2000000) == 142913828922L)
    }
    println("Time: $t")
}

private var cache = mutableListOf<Long>()
fun primeSummation(n: Int): Long {
    if (cache.getOrNull(n-1) != null) {
        return cache.get(n-1)
    }
    var i = cache.lastIndex
    var sum = cache.getOrElse(i) { 0L }
    i++
//    println("START: i=$i sum=$sum")
    while (i <= n){
        i++
        if (isPrime(i.toLong())) {
            sum += i
        }
        cache.add(i-1, sum)
    }
//    println(cache)
    return cache.get(n-1)
}
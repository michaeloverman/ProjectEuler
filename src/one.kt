import sun.rmi.runtime.Log
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
//    if (cache.isNotEmpty()) cache = sortedMapOf<Int, Int>()
    val t = measureTimeMillis {
        println("543: ${multiplesOf3and5(49)}")
        println("233168: ${multiplesOf3and5(1000)}")
        println("16687353: ${multiplesOf3and5(8456)}")
        println("89301183: ${multiplesOf3and5(19564)}")
    }
    println("Time: $t")
//    println(cache)
}

fun multiplesOf3and5(n: Int): Int {
    // sum 3
    val x = n - 1
    var n = x / 3
    var a = 3
    var sum = (((2 * a) + ((n - 1) * a)) * n) shr 1

    // sum 5
    n = x / 5
    a = 5
    sum += (((2 * a) + ((n - 1) * a)) * n) shr 1

    // sum 15
    n = x / 15
    a = 15
    sum -= (((2 * a) + ((n - 1) * a)) * n) shr 1

    return sum
}

private var cache = sortedMapOf<Int, Int>()
fun CACHEmultiplesOf3and5(n: Int): Int {
    if (cache.containsKey(n)) return cache.get(n)!!
    var i = 2
    var sum = 0
    if (!cache.isEmpty()) {
        i = cache.lastKey()
        sum = cache.get(i)!!
        println("Staring with $i :: $sum")
    }
    i++
    while (i < n) {
        if (i % 3 == 0 || i % 5 == 0) sum += i
        cache.put(i, sum)
        i++
    }
    return sum
}

fun DRAFTmultiplesOf3and5(n: Int): Int {
    var sum = 0
    (1 until n).forEach { i ->
        if (i % 3 == 0 || i % 5 == 0) sum += i
    }
    return sum
}

fun CCmultiplesOf3and5(number: Int): Int {
//    Log.d(number)
    return (1 until number).filter {
        it % 3 == 0 || it % 5 == 0
    }.sum()
}

/*
3 5 6 9 10 12 15 18 20 21 24 25 27 30 33 35 36 39 40
 2 1 3 1  2  3  3  2  1  3  1  2  3  3  2  1  3  1
                  |
 */
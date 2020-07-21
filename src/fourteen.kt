import kotlin.system.measureTimeMillis

// ProjectEuler
// Created: 6/21/20 7:48 PM

fun main() {
    val t = measureTimeMillis {
//        createSequence(500001)
//        println("1000000: ${longestCollatzSequence(1000000) == 837799}")
        results.add(0, 1)
        (1..5000000).forEach {
            results.add(it, 0)
        }
//        longestCollatzSequence(5000000)
        println("14: ${longestCollatzSequence(10) == 9} ${longestCollatzSequence(10)}")
        println("14: ${longestCollatzSequence(15) == 9} ${longestCollatzSequence(15)}")
        println("20: ${longestCollatzSequence(20) == 19} ${longestCollatzSequence(20)}")
        println("54: ${longestCollatzSequence(54) == 54} ${longestCollatzSequence(54)}")
//        println("5847: ${longestCollatzSequence(5847) == 3711} ${longestCollatzSequence(5847)}")
//        println("46500: ${longestCollatzSequence(46500) == 35655} ${longestCollatzSequence(46500)}")
//        println("54512: ${longestCollatzSequence(54512) == 52527} ${longestCollatzSequence(54512)}")
//        println("100000: ${longestCollatzSequence(100000) == 77031} ${longestCollatzSequence(100000)}")
//        println("50000: ${longestCollatzSequence(50000) == 35655} ${longestCollatzSequence(50000)}")
//        println("500000: ${longestCollatzSequence(5000000)}")
    }
    println("Time: $t")
}

private var results = mutableListOf<Int>()
private var maxFound = 1
fun longestCollatzSequence(n: Int): Int {
    if (n > maxFound) {
        (maxFound + 1..n).forEach {
            createSequence(it)
        }
        maxFound = n
    }
    var result = 0
    var max = 0
    for (i in 0..n-1) {
        if (results[i] >= max) {
            max = results[i]
            result = i + 1
        }
    }
//    println(results.filterIndexed { idx, _ -> idx < n })
//    println("$result: $max")
    return result
}

fun createSequence(n: Int): Int {
//    print("$n -> ")
    return if (results.getOrNull(n- 1) != null && results.get(n- 1) != 0) {
//        println("   returning ${results.get((n-1).toInt())} for $n")
//        println()
        results.get(n- 1)
    } else {
//        println("   Solving for $n")
        var result = 0
        result = if (n % 2 == 0) 1 + createSequence(n shr 1)
        else 1 + createSequence(3 * n + 1)
        if (n < 5000001) {
//            println("  adding $n == $result")
            results[n-1] = result
//            println(results.filterIndexed { i, _ -> i < 20})
        }

        result
    }
}

private var cache = mutableMapOf<Long, Int>()
fun FIRSTlongestCollatzSequence(n: Int): Int {
    if (cache.containsKey(n.toLong())) {
        var c = cache.filterKeys { it <= n }.toList().sortedBy { it.second }
//        println(c)
        return c.last().first.toInt()
    }
    var c = cache.maxBy { it.value }
    var maxcount = if (c != null) c.value else 0
    var maxvalue = if (c != null) c.key else 0
    val start = if (!cache.isEmpty()) cache.maxBy { it.key }!!.key + 1 else 0
    println("counting from $start to $n")
    (start..n).forEach {
        var x = it.toLong()
        var count = 1
        while (x > 1) {
            if (cache.containsKey(x)) {
                count += cache.get(x)!!
                x = 1L
            } else {
                if (x % 2 == 0L) x /= 2 else x = (3 * x) + 1
                count++
            }
        }
        cache.put(it, count)
//        println("$it: $cache")
        if (count >= maxcount) {
            maxcount = count
            maxvalue = it
        }
    }
    return maxvalue.toInt()
}
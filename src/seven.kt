import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val t = measureTimeMillis {
        println(nthPrime(6) == 13)
        println(nthPrime(10) == 29)
        println(nthPrime(100) == 541)
        println(nthPrime(1000) == 7919)
        println(nthPrime(10001) == 104743)
    }
    println("Time: $t")
}

var primes = mutableListOf<Int>(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199)
fun nthPrime(n: Int): Int {
    if (n < primes.size) return primes[n - 1]
    var p = primes[primes.size - 1]
    var nth = primes.size
    while (nth < n) {
        p += 2
        if (isPrime(p.toLong())) {
            nth++
            primes.add(p)
        }
    }
    return p
}
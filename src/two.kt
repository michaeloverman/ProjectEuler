fun main(args: Array<String>) {
    println(fiboEvenSum(10) == 10)
    println(fiboEvenSum(60) == 44)
    println(fiboEvenSum(1000) == 798)
    println(fiboEvenSum(100000) == 60696)
    println(fiboEvenSum(4000000) == 4613732)
}

// Switched to Long for Hackerrank
fun fiboEvenSum(num: Int): Int {
    var a = 1
    var b = 2
    var sum = 0
    while (b < num) {
        if (b % 2 == 0) sum += b
        val t = b
        b += a
        a = t
    }
    return sum
}
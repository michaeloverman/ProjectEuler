import kotlin.math.pow
import kotlin.system.measureNanoTime

//val arr = listOf(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), listOf(1, 1, 1, 1, 1), listOf(1, 2, 1, 2, 1, 2, 1, 2), listOf(1, 2, 1, 2, 1, 2, 1, 2), listOf(2, 4, 6, 8, 10))
//val ks = listOf(2, 1, 3, 2, 4)
val arr = listOf(1543, 2, 4542, 544, 16, 5557, 5438, 5438, 67779)
fun main(args: Array<String>) {
    var one = 0L
    var two = 0L
    (1..1000).forEach {
        one += measureNanoTime {
            arr.forEachIndexed { i, v ->
                one(v)
            }
        }
        two += measureNanoTime {
            arr.forEachIndexed { i, v ->
                two(v)
            }
        }
    }
    
    val t = one / 1000
    val u = two / 1000
    val comp: Double
    if (t < u) comp = u.toDouble() / t
    else comp = t.toDouble() / u

    println("${if (t < u) "One" else "Two"} is ${"%.2f".format(comp)} times faster")
}

//private var cache = sortedMapOf<Int, Int>()
fun one(n: Int): Int {
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

fun two(n: Int): Int {
    // sum 3
    val x = n - 1
    var n = x / 3
    var a = 3
    var d = 3
    var sum = (((2 * a) + ((n - 1) * d)) * n) shr 1

    // sum 5
    n = x / 5
    a = 5
    d = 5
    sum += (((2 * a) + ((n - 1) * d)) * n) shr 1

    // sum 15
    n = x / 15
    a = 15
    d = 15
    sum -= (((2 * a) + ((n - 1) * d)) * n) shr 1

    return sum
}

fun toStringAndBack(n: Int, acc: Int = 0): Int = if (n.toString().length <= 1) acc else toStringAndBack(n.toString().sumBy { it - '0' }, acc + 1)

fun stayDigits(n: Int): Int {
    var c = 0
    var x = n
    while (x > 9) {
        c++
        var sum = 0
        while (x > 0) {
            sum += x % 10
            x /= 10
        }
        x = sum
    }
    return c
}

fun highestNdigit1(n: Int) = "9".repeat(n).toInt()
fun highestNdigit2(n: Int) = (10.0.pow(n.toDouble()) - 1).toInt()


fun mapVfilter1(inputArray: List<Int>, k: Int) = inputArray.mapIndexed { i, v -> if ((i + 1) % k != 0) v else null }
fun mapVfilter2(inputArray: List<Int>, k: Int) = inputArray.filterIndexed { i, _ -> (i + 1) % k != 0 }


fun allowedFunctionName1(name: String): Boolean = name.matches(Regex("[a-zA-Z_][a-zA-Z_0-9]*"))

val allowed = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_"
fun allowedFunctionName2(name: String) =
        name.all { it in allowed } && !(name[0] in "0123456789")



//fun one(n: Int): Boolean {
//    n.toString().forEach {
//        if (it.toInt() % 2 != 0) return false
//    }
//    return true
//}
fun second(n: Int) = n.toString().matches("[0|2|4|6|8]*".toRegex())

fun first(n: Int): Boolean =
        n.toString().all { it.toInt() % 2 == 0 }

fun old(n: Int): Boolean {
    var n = n
    while (n > 0) {
        if (n % 2 != 0) return false
        n /= 10
    }
    return true
}

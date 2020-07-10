import kotlin.system.measureTimeMillis

// ProjectEuler
// Created: 7/4/20 10:44 AM

fun main() {
    val t = measureTimeMillis {
        println(numberWords(17L) == "Seventeen")
        println(numberWords(10L) == "Ten")
        println(numberWords(104382426112) == "One Hundred Four Billion Three Hundred Eighty Two Million Four Hundred Twenty Six Thousand One Hundred Twelve")
        println(numberWords(100000000112) == "One Hundred Billion One Hundred Twelve")
    }
    println("Time: $t")
}

val groups = listOf("Billion", "Million", "Thousand", "")
val ones = listOf("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
val tens = listOf("Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
fun numberWords(i: Long): String {
    var x = i
    if (x == 0L) return "Zero"
    var s = ""
    var group = 1000000000
    var grpidx = 0
    while (group > 0) {
        if (x / group > 0) s += "${getHundreds((x / group).toInt())}${groups[grpidx]} "
        x %= group
        group /= 1000
        grpidx++
    }
    println("$s...")
    return s.trim()
}

fun getHundreds(i: Int): String {
    if (i == 0) return ""
    var s = ""
    var x = i
    if (x > 99) {
        s += "${ones[(x / 100) - 1]} Hundred "
        x %= 100
    }
    if (x > 19) {
        s += "${tens[(x / 10) - 2]} "
        x %= 10
    }
    if (x > 0) {
        s += "${ones[x - 1]} "
    }
    return s
}
import java.time.DayOfWeek
import java.time.LocalDate
import java.util.*
import kotlin.system.measureTimeMillis

// ProjectEuler
// Created: 7/4/20 6:41 PM

fun main() {
    val t = measureTimeMillis {
        println(numSun(4699, 12, 12, 4710, 1, 1) == 18)
//        println(numSun(2000, 1, 1, 2020, 1, 1) == 35)
    }
    println("Time: $t")
}

fun numSun(y1: Long, m1: Int, d1: Int, y2: Long, m2: Int, d2: Int): Int {
    var year1 = (((y1 - 1900) % 2800) + 1900).toInt()
    var year2 = (year1 + (y2 - y1)).toInt()
    var beg = LocalDate.of(year1, m1, d1)
    var end = LocalDate.of(year2, m2, d2)
    var pt = if(d1 == 1) beg else LocalDate.of(year1, m1, 1).plusMonths(1L)
    var count = 0
    while (pt <= end) {
        println("Checking: $pt")
        if (pt.dayOfWeek == DayOfWeek.SUNDAY) count++
        pt = pt.plusMonths(1L)
    }
    return count
}
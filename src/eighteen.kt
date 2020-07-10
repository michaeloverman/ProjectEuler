import kotlin.system.measureTimeMillis

// ProjectEuler
// Created: 7/4/20 3:19 PM

import java.io.*
import java.util.*

/**
 * Not sure how to make this work with Scanner input. This is what I wrote directly in HackerRank
 */
fun main(args: Array<String>) {
    val x = Scanner(System.`in`)
    val tests = x.nextInt()
    (0 until tests).forEach {
        val lines = x.nextInt()
        var arr = mutableListOf<MutableList<Int>>()
        (0 until lines).forEach { i ->
            arr.add(i, mutableListOf<Int>())
            (0..i).forEach {
                arr[i].add(x.nextInt())
            }
            (i+1 until lines).forEach {
                arr[i].add(0)
            }
        }
        println(maxPath(arr, 0, 0))
    }
}

fun maxPath(a: MutableList<MutableList<Int>>, row: Int, col: Int): Int {
    if (row == a.size - 1) return a[row][col]
    else return Integer.max(a[row][col] + maxPath(a, row+1, col), a[row][col] + maxPath(a, row+1, col+1))
}

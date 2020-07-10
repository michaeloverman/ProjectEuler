import kotlin.system.measureTimeMillis

// ProjectEuler
// Created: 7/7/20 7:52 PM

// Written in Hackerrank - won't work here...

import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val x = Scanner(System.`in`)
    var names = mutableListOf<String>()
    val N = x.nextInt()
    var toll = x.nextLine()
    (1..N).forEach{
        names.add(x.nextLine().trim().toUpperCase())
    }
    val list = names.sorted()
    val S = x.nextInt()
    val toss = x.nextLine()
    (1..S).forEach {
        val name = x.nextLine()
        var score = 0
        name.forEach {
            score += it - 'A' + 1
        }
        println(score * (list.indexOf(name) + 1))
    }
}
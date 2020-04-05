package arrays

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the minimumBribes function below.
fun minimumBribes(q: Array<Int>): Unit {
//    val visited = BooleanArray(0) { false }
    var totalBribes = 0L
    for ((index, value) in q.withIndex()) {
        val original = value - 1
        if (original - index > 2) {
            println("Too chaotic")
            return
        }
        if (original - index > 0) {
            continue
        }
        for (i in max(original - 1,0) until index) {
            if (q[i] > value) {
                totalBribes++
            }
        }
    }
    println(totalBribes)
}

fun main(args: Array<String>) {
//    val scan = Scanner(System.`in`)
//
//    val t = scan.nextLine().trim().toInt()
//
//    for (tItr in 1..t) {
//        val n = scan.nextLine().trim().toInt()
//
//        val q = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    minimumBribes(arrayOf(2, 1, 5, 3, 4))
    minimumBribes(arrayOf(2, 5, 1, 3, 4))
    minimumBribes(arrayOf(1, 2, 5, 3, 4, 7, 8, 6))
    minimumBribes(arrayOf(5, 1, 2, 3, 7, 8, 6, 4))
    minimumBribes(arrayOf(1, 2, 5, 3, 7, 8, 6, 4))
//    }
}

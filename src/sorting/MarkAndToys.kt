package sorting

import java.io.*
import java.lang.RuntimeException
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
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the maximumToys function below.
fun maximumToys(prices: Array<Int>, k: Int): Int {
    val sorted = prices.sortedArray()
    var items = 0
    var total = 0
    for (i in sorted.indices) {
        total += sorted[i]
        if (total > k) {
            break
        }
        items++
    }
    return items
}

fun main(args: Array<String>) {
//    val scan = Scanner(System.`in`)
//
//    val nk = scan.nextLine().split(" ")
//
//    val n = nk[0].trim().toInt()
//
//    val k = nk[1].trim().toInt()
//
//    val prices = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = maximumToys(arrayOf(1, 12, 5, 111, 200, 1000, 10), 50)
    if (result != 4) {
        throw RuntimeException("Wrong answer")
    }

//    println(result)
}

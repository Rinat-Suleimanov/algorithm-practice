package sorting

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
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the countSwaps function below.
fun countSwaps(a: Array<Int>): Unit {
    var swaps = 0
    var newSwaps = 0
    do {
        newSwaps = 0
        for (i in a.indices) {
            if (i == a.lastIndex) {
                continue
            }
            if (a[i] > a[i + 1]) {
                val tmp = a[i]
                a[i] = a[i + 1]
                a[i + 1] = tmp
                newSwaps++
            }
        }
        swaps += newSwaps
    } while (newSwaps != 0)
    println("Array is sorted in $swaps swaps.")
    println("First Element: ${a.first()}")
    println("Last Element: ${a.last()}")
}

fun main(args: Array<String>) {
//    val scan = Scanner(System.`in`)
//
//    val n = scan.nextLine().trim().toInt()
//
//    val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    countSwaps(arrayOf(1, 2, 3))
}

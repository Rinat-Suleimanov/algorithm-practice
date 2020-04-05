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

// Complete the minimumSwaps function below.
fun minimumSwaps(arr: Array<Int>): Int {
    val visited = Array(arr.size) { false }
    var swaps = 0
    for ((index, value) in arr.withIndex()) {
        if (visited[index]) {
            continue
        }
        visited[index] = true
        if (value - 1 == index) {
            continue
        }

        var checkIndex = value - 1
        while (true) {
            visited[checkIndex] = true
            swaps++
            val checkValue = arr[checkIndex]
            if (arr[checkValue - 1] == value) {
                break
            }
            checkIndex = checkValue - 1
        }
    }
    return swaps
}

fun main(args: Array<String>) {
//    val scan = Scanner(System.`in`)
//
//    val n = scan.nextLine().trim().toInt()
//
//    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val res = minimumSwaps(arrayOf(2, 3, 4, 1, 5))

    println(res)
}

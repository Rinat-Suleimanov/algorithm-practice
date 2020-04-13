package dictionaries

import kotlin.collections.*

// Complete the countTriplets function below.
fun countTriplets(arr: Array<Long>, r: Long): Long {
    var triplets = 0L
    val rightMap = arr.groupBy { it }.mapValues { it.value.size }.toMutableMap()
    val leftMap = HashMap<Long, Long>()
    for (num in arr) {
        val rightCounter = rightMap[num]!!
        rightMap[num] = rightCounter - 1
        if (num % r == 0L) {
            val left = leftMap[num / r] ?: 0
            val right = rightMap[num * r] ?: 0
            triplets += left * right
        }
        val leftCounter = leftMap[num]
        if (leftCounter == null) {
            leftMap[num] = 1
        } else {
            leftMap[num] = leftCounter + 1
        }
    }
    return triplets
}

fun main(args: Array<String>) {
//    val nr = readLine()!!.trimEnd().split(" ")
//
//    val n = nr[0].toInt()
//
//    val r = nr[1].toLong()
//
//    val arr = readLine()!!.trimEnd().split(" ").map { it.toLong() }.toTypedArray()

    val ans = countTriplets(arrayOf(1, 5, 5, 25, 125), 5)

    println(ans)
}

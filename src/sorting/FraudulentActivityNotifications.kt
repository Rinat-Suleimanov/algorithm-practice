package sorting

import java.util.*

// Complete the activityNotifications function below.
fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    if (expenditure.size < d + 1) return 0
    var notifications = 0

    val lower = PriorityQueue<Int> { itn1, int2 -> (-1) * itn1.compareTo(int2) }
    val higher = PriorityQueue<Int>()

    for (i in 0 until expenditure.size - 1) {
        addElement(expenditure[i], lower, higher)
        reBalance(lower, higher)
        //wait for filling enough history
        if (i < d - 1) {
            continue
        }
        if (i > d - 1) {
            removeElement(expenditure[i - d], lower, higher)
            reBalance(lower, higher)
        }
        val median = currentMedian(lower, higher)
        if (expenditure[i + 1] >= median * 2) {
            notifications++
        }
    }
    return notifications
}

fun currentMedian(lower: PriorityQueue<Int>, higher: PriorityQueue<Int>): Double {
    val smallerHeap = if (lower.size > higher.size) higher else lower
    val biggerHeap = if (lower.size > higher.size) lower else higher

    return if (smallerHeap.size == biggerHeap.size) {
        (smallerHeap.peek() + biggerHeap.peek()).toDouble() / 2
    } else {
        biggerHeap.peek().toDouble()
    }
}

fun removeElement(element: Int, lower: PriorityQueue<Int>, higher: PriorityQueue<Int>) {
    if (lower.remove(element)) return
    higher.remove(element)
}

fun reBalance(lower: PriorityQueue<Int>, higher: PriorityQueue<Int>) {
    val smallerHeap = if (lower.size > higher.size) higher else lower
    val biggerHeap = if (lower.size > higher.size) lower else higher

    if (biggerHeap.size - smallerHeap.size > 1) {
        smallerHeap.add(biggerHeap.poll())
    }
}

fun addElement(element: Int, lower: PriorityQueue<Int>, higher: PriorityQueue<Int>) {
    if (lower.size == 0 || lower.peek() > element) {
        lower.add(element)
    } else {
        higher.add(element)
    }
}

fun main(args: Array<String>) {
//    val scan = Scanner(System.`in`)
//
//    val nd = scan.nextLine().split(" ")
//
//    val n = nd[0].trim().toInt()
//
//    val d = nd[1].trim().toInt()
//
//    val expenditure = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = activityNotifications(arrayOf(10, 20, 30, 40, 50), 3)

    println(result)
}

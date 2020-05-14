package amazon

import java.lang.RuntimeException
import java.util.*

fun main() {
    if (!kLargest(arrayOf(1, 23, 12, 9, 30, 2, 50), 3).contentDeepEquals(arrayOf(50, 30, 23))) {
        throw RuntimeException("Wrong answer #1")
    }
    if (!kLargest(arrayOf(1, 23, 12, 9, 30, 2, 50), 3).contentDeepEquals(arrayOf(50, 30, 23))) {
        throw RuntimeException("Wrong answer #1")
    }
}

fun kLargest(input: Array<Int>, k: Int): Array<Int> {
    val minHeap = PriorityQueue<Int> { v1, v2 -> (-1) * v1.compareTo(v2)}
    for (elem in input) {
        minHeap.add(elem)
    }
    val result = Array(k) { 0 }
    for (i in 0 until k) {
        result[i] = minHeap.poll()
    }
    return result
}

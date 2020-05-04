package dailyinterviewpro

import java.lang.RuntimeException
import java.util.*

fun main() {
    if (sumLinkedLists(LinkedList(listOf(2, 4, 3)), LinkedList(listOf(5, 6, 4))) != LinkedList(listOf(7, 0, 8))) {
        throw RuntimeException("Wrong answer #1")
    }
    if (sumLinkedLists(LinkedList(listOf(0)), LinkedList(listOf(5, 6, 4))) != LinkedList(listOf(5, 6, 4))) {
        throw RuntimeException("Wrong answer #2")
    }
    if (sumLinkedLists(LinkedList(listOf(9, 9)), LinkedList(listOf(5, 6, 4))) != LinkedList(listOf(4, 6, 5))) {
        throw RuntimeException("Wrong answer #3")
    }
}

fun sumLinkedLists(first: LinkedList<Int>, second: LinkedList<Int>): LinkedList<Int> {
    val result = LinkedList<Int>()
    var toNextRegister = 0
    while (first.isNotEmpty() || second.isNotEmpty()) {
        val num1 = if (first.isNotEmpty()) first.pop() else 0
        val num2 = if (second.isNotEmpty()) second.pop() else 0

        val sum = num1 + num2 + toNextRegister

        val writeToResult = if (sum > 9) {
            toNextRegister = 1
            sum % 10
        } else {
            toNextRegister = 0
            sum
        }
        result.addLast(writeToResult)
    }
    return result
}

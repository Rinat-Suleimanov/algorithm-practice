package dailyinterviewpro

/**
 * You are given a list of numbers, and a target number k.
 * Return whether or not there are two numbers in the list that add up to k.
 * Example:
 * Given [4, 7, 1 , -3, 2] and k = 5,
 * return true since 4 + 1 = 5.
 */
fun main() {
    if (!twoSum(arrayOf(4, 7, 1, -3, 2), 5)) {
        throw RuntimeException("Wrong answer #1")
    }
    if (!twoSum(arrayOf(4, 7, 3, -3, 2), 5)) {
        throw RuntimeException("Wrong answer #2")
    }
    if (!twoSum(arrayOf(8, 7, 1, -3, 2), 5)) {
        throw RuntimeException("Wrong answer #3")
    }
    if (twoSum(arrayOf(10, 7, 1, -3, 2), 5)) {
        throw RuntimeException("Wrong answer #4")
    }
}

fun twoSum(input: Array<Int>, target: Int): Boolean {
    val diffSet = HashSet<Int>()
    for (elem in input) {
        if (diffSet.contains(elem)) {
            return true
        }
        diffSet.add(target - elem)
    }
    return false
}

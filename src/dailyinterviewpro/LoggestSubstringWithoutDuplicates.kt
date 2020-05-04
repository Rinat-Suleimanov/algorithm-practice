package dailyinterviewpro

import java.lang.RuntimeException
import kotlin.math.max

fun main() {
    if (longestSub("abrkaabcdefghijjxxx") != 10) {
        throw RuntimeException("Wrong answer #1")
    }
    if (longestSub("aaaaaaaaaaaaaaa") != 1) {
        throw RuntimeException("Wrong answer #2")
    }
    if (longestSub("") != 0) {
        throw RuntimeException("Wrong answer #3")
    }
    if (longestSub("absdfknrgbtakedfadjnfbdhbvfvpwokenjnvutvitvotvtmovmt") != 10) {
        throw RuntimeException("Wrong answer #4")
    }
}

fun longestSub(input: String): Int {

    var longest = 0 // 4
    var currentLength = 0 // 4
    var lastDuplicateIndex = -1 // 0

    val visited = Array(256) { -1 }
    for (i in input.indices) {
        val currentChar = input[i]
        val intRepresentation = currentChar.toInt()
        if (visited[intRepresentation] == -1 || visited[intRepresentation] < lastDuplicateIndex) {
            visited[intRepresentation] = i
            currentLength++
        } else {
            longest = max(longest, currentLength)
            lastDuplicateIndex = visited[intRepresentation]
            currentLength = i - lastDuplicateIndex
            visited[intRepresentation] = i
        }
    }
    longest = max(longest, currentLength)
    return longest
}

package dictionaries

import kotlin.collections.*

// Complete the freqQuery function below.
fun freqQuery(queries: Array<Array<Int>>): Array<Int> {
    val finalArray = ArrayList<Int>()
    val structure = HashMap<Int, Int>()
    val frequencyMap = HashMap<Int, Int>()
    for (query in queries) {
        val operation = query[0]
        val value = query[1]
        when (operation) {
            1 -> {
                val currentFrequency = structure[value] ?: 0
                val newFrequency = currentFrequency + 1
                structure[value] = newFrequency

                val currentNumsC = frequencyMap[currentFrequency] ?: 0
                if (currentNumsC > 0) {
                    val newNumsC = currentNumsC - 1
                    frequencyMap[currentFrequency] = newNumsC
                }
                val currentNumsN = frequencyMap[newFrequency] ?: 0
                val newNumsN = currentNumsN + 1
                frequencyMap[newFrequency] = newNumsN
            }
            2 -> {
                val currentFrequency = structure[value] ?: 0
                if (currentFrequency > 0) {
                    val newFrequency = currentFrequency - 1
                    structure[value] = newFrequency

                    val currentNumsN = frequencyMap[newFrequency] ?: 0
                    val newNumsN = currentNumsN + 1
                    frequencyMap[newFrequency] = newNumsN
                }

                val currentNumsC = frequencyMap[currentFrequency] ?: 0
                if (currentNumsC > 0) {
                    val newNumsC = currentNumsC - 1
                    frequencyMap[currentFrequency] = newNumsC
                }


            }
            3 -> {
                val firstOrNull = frequencyMap[value] ?: 0
                if (firstOrNull == 0) {
                    finalArray.add(0)
                } else {
                    finalArray.add(1)
                }
            }
        }

    }

    return finalArray.toArray(Array(finalArray.size) { 0 })
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    val queries = Array<Array<Int>>(q, { Array<Int>(2, { 0 }) })

    for (i in 0 until q) {
        queries[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val ans = freqQuery(queries)

    println(ans.joinToString("\n"))
}

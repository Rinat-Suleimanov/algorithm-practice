package dictionaries

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

// Complete the sherlockAndAnagrams function below.
fun sherlockAndAnagrams(s: String): Int {
    var anagrams = 0
    val length = s.length
    var wordLength = length - 1
    while (wordLength > 0) {
        val anagramsMap = HashMap<HashMap<Char, Int>, Int>()
        for (i in 0..length - wordLength) {
            val substring = s.substring(i until i + wordLength).toMap()
            anagramsMap[substring]?.let { anagrams += it }
            anagramsMap.add(substring)
        }
        wordLength--
    }
    return anagrams
}

fun String.toMap(): HashMap<Char, Int> {
    val hashMap = HashMap<Char, Int>()
    for (c in this) {
        hashMap.add(c)
    }
    return hashMap
}

fun <K> HashMap<K, Int>.add(key: K) {
    if (this[key] == null) {
        this[key] = 1
    } else {
        this[key] = this[key]!! + 1
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = sherlockAndAnagrams(s)

        println(result)
    }
}

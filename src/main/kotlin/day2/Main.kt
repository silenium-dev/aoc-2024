package day2

import util.Resources

fun isSafe(a: List<Int>): Boolean {
    val desc = a[0] > a[1]
    val maxSafeDistance = 3
    for (i in 1..<a.size) {
        val dist = a[i - 1] - a[i]
        val safe = when {
            desc -> dist in 1..maxSafeDistance
            else -> dist in -maxSafeDistance..-1
        }
        if (!safe) return false
    }
    return true
}

fun isSafeDampened(a: List<Int>): Boolean {
    if (isSafe(a)) return true
    for (i in a.indices) {
        val b = a.take(i) + a.takeLast(a.size - i - 1)
        if (isSafe(b)) return true
    }
    return false
}

fun main() {
    val list = Resources.load("inputs/day2.txt")
        .lines()
        .filter { it.isNotBlank() }
        .map { it.split(" ") }
        .map { it.map(String::toInt) }
    list
        .map { report ->
            println(report)
            val safe = isSafe(report)
            println("  Is safe: $safe")
            val safeDampened = isSafeDampened(report)
            println("  Is safe (part 2): $safeDampened")
            println()
            safe to safeDampened
        }
        .let { i ->
            println("Part 1: ${i.count { it.first }} safe reports")
            println("Part 2: ${i.count { it.second }} safe reports")
        }
}

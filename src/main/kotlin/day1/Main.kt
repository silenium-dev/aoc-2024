package day1

import util.Resources
import kotlin.math.abs

fun subtractionDistance(a: Collection<Int>, b: Collection<Int>): Int {
    return a.zip(b).fold(0) { acc, pair ->
        acc + abs(pair.first - pair.second)
    }
}

fun Collection<Int>.count(n: Int) = count { i -> i == n }

fun multiplicationDistance(a: Collection<Int>, b: Collection<Int>): Int {
    return a.zip(b).fold(0) { acc, pair ->
        acc + (pair.first * b.count(pair.first))
    }
}

fun main() {
    val (list1, list2) = Resources.load("inputs/day1.txt")
        .lines()
        .filter { it.isNotBlank() }
        .map {
            val split = it.split("   ")
            split[0].toInt() to split[1].toInt()
        }
        .unzip().let { pair ->
            pair.first.sorted() to pair.second.sorted()
        }
    println("Part 1: " + subtractionDistance(list1, list2))
    println("Part 2: " + multiplicationDistance(list1, list2))
}

import java.util.LinkedHashSet

fun main() {
    System.`in`.bufferedReader().use {
        val n = it.readLine().toInt()
        val scores = it.readLine().split(" ").map { it.toInt() }
        val sum = it.readLine().toInt()
        val map = LinkedHashSet<Int>(n)
        var result = 0

        scores.forEach { map.add(it) }

        scores.forEach {
            val currentNumber = it
            val findNumber = sum - currentNumber

            if (findNumber in map) result++
        }

        println(result / 2)
    }
}
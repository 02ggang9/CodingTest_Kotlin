import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val resultBuilder = StringBuilder()
    val map = TreeMap<Int, String>()

    repeat(n) {
        val (name, score) = readln().split(" ")
        map.putIfAbsent(score.toInt(), name)
    }

    repeat(m) {
        val score = readln().toInt()
        resultBuilder.append(map.ceilingEntry(score).value).append("\n")
    }

    println(resultBuilder.toString())
}
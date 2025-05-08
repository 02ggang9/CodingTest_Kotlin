import java.util.*

fun main() {
    val n = readln().toInt()
    val pQueue: Queue<Long> = PriorityQueue(compareByDescending { it })

    repeat(n) {
        val numbers = readln().split(" ").map { it.toLong() }
        numbers.forEach { pQueue.add(it) }
    }

    repeat(n - 1) {
        pQueue.poll()
    }

    println(pQueue.poll())
}

import java.util.*

fun main() {
    val n = readln().toInt()
    val pQueue: Queue<Int> = PriorityQueue(compareBy { it })
    repeat(n) {
        val value = readln().toInt()
        if (value == 0) {
            if (pQueue.isEmpty()) {
                println(0)
            } else {
                println(pQueue.poll())
            }
        } else {
            pQueue.add(value)
        }
    }
}

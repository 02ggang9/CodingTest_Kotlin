import java.util.*

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val position = IntArray(100_001) { -1 }
    val queue: Queue<Int> = ArrayDeque()

    queue.add(n)
    position[n] = 0

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (current == k) {
            println(position[current])
            break
        }

        for (next in arrayOf(current + 1, current -1, current * 2)) {
            if (next in 0 until 100_001 && position[next] == -1) {
                position[next] = position[current] + 1
                queue.add(next)
            }
        }
    }
}
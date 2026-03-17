import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val matrix = Array(n + 1) { mutableListOf<Int>() }
    val isVisited = BooleanArray(n + 1) { false }

    repeat(n - 1) {
        val (first, second) = br.readLine().split(" ").map(String::toInt)
        matrix[first].add(second)
        matrix[second].add(first)
    }

    val result = IntArray(n + 1) { 0 }
    val queue: Queue<Int> = LinkedList()
    queue.add(1)
    isVisited[1] = true
    result[1] = 1

    while (queue.isNotEmpty()) {
        val current = queue.poll()

        for (next in matrix[current]) {
            if (isVisited[next]) continue

            queue.add(next)
            isVisited[next] = true
            result[next] = current
        }
    }

    val resultBuilder = StringBuilder()
    for (i in 2..n) {
        resultBuilder.append(result[i]).append("\n")
    }

    println(resultBuilder.toString())
}

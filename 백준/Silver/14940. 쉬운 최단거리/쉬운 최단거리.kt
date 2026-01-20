import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().trim().split(" ").map(String::toInt)
    val matrix = Array(n) { IntArray(m) { 0 } }
    val result = Array(n) { IntArray(m) { -1 } }
    val visited = Array(n) { BooleanArray(m) { false } }
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    var startX = 0
    var startY = 0

    for (y in 0 until n) {
        val line = br.readLine().trim().split(" ").map(String::toInt)
        for (x in 0 until m) {
            val number = line[x]
            matrix[y][x] = number
            when (number) {
                0 -> result[y][x] = 0
                2 -> {
                    startX = x
                    startY = y
                }
            }
        }
    }

    val queue: Queue<IntArray> = LinkedList()
    result[startY][startX] = 0
    queue.add(intArrayOf(startX, startY))
    visited[startY][startX] = true

    while (queue.isNotEmpty()) {
        val (currentX, currentY) = queue.poll()

        repeat(4) {
            val nx = currentX + dx[it]
            val ny = currentY + dy[it]

            if (nx !in 0 until m || ny !in 0 until n) return@repeat
            if (!visited[ny][nx] && matrix[ny][nx] != 0) {
                result[ny][nx] = result[currentY][currentX] + 1
                queue.add(intArrayOf(nx, ny))
                visited[ny][nx] = true
            }
        }
    }

    for (i in 0 until n) {
        println(result[i].joinToString(" "))
    }
}

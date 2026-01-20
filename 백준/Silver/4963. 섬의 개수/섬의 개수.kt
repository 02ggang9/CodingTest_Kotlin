import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val dx = intArrayOf(1, 1, 0, -1, -1, -1, 0, 1)
    val dy = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)

    while (true) {
        val (w, h) = br.readLine().trim().split(" ").map(String::toInt)
        var result = 0
        if (w == 0 && h == 0) break

        val matrix = Array(h) { IntArray(w) { 0 } }
        val visited = Array(h) { BooleanArray(w) { false } }
        val queue: Queue<IntArray> = LinkedList()

        repeat(h) {
            val line = br.readLine().trim().split(" ").map(String::toInt).toIntArray()
            matrix[it] = line
        }

        for (y in 0 until h) {
            for (x in 0 until w) {
                if (matrix[y][x] == 1 && !visited[y][x]) {
                    queue.add(intArrayOf(x, y))
                    visited[y][x] = true

                    while (queue.isNotEmpty()) {
                        val (currentX, currentY) = queue.poll()

                        repeat(8) {
                            val nx = currentX + dx[it]
                            val ny = currentY + dy[it]

                            if (nx !in 0 until w || ny !in 0 until h) return@repeat
                            if (!visited[ny][nx] && matrix[ny][nx] == 1) {
                                queue.add(intArrayOf(nx, ny))
                                visited[ny][nx] = true
                            }
                        }
                    }

                    result++
                }
            }
        }

        println(result)
    }
}

import java.util.*

fun main() {
    val t = readln().toInt()

    repeat(t) {
        val (m, n, k) = readln().split(" ").map { it.toInt() }
        val matrix = Array(m) { IntArray(n) { 0 } }
        val visited = Array(m) { BooleanArray(n) { false } }

        repeat(k) {
            val (x, y) = readln().split(" ").map { it.toInt() }
            matrix[x][y] = 1
        }

        val dx = arrayOf(0, 1, 0, -1)
        val dy = arrayOf(-1, 0, 1, 0)
        var result = 0
        val queue: Queue<IntArray> = ArrayDeque()

        for (x in 0 until m) {
            for (y in 0 until n) {
                if (matrix[x][y] != 1 || visited[x][y]) continue

                visited[x][y] = true
                queue.add(intArrayOf(x, y))

                while (queue.isNotEmpty()) {
                    val (currentX, currentY) = queue.poll()

                    repeat(4) {
                        val nx = dx[it] + currentX
                        val ny = dy[it] + currentY

                        if (nx !in 0 until m || ny !in 0 until n) return@repeat
                        if (matrix[nx][ny] == 0 || visited[nx][ny]) return@repeat

                        visited[nx][ny] = true
                        queue.add(intArrayOf(nx, ny))
                    }
                }
                result++
            }
        }

        println(result)
    }
}
import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().trim().split(" ").map(String::toInt)
    val matrix2D = Array(m) { CharArray(n) { 'W' } }
    val visited = Array(m) { BooleanArray(n) { false } }
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    var wResult = 0
    var bResult = 0

    for (i in 0 until m) {
        val line = br.readLine()
        for (j in 0 until n) {
            matrix2D[i][j] = line[j]
        }
    }

    for (y in 0 until m) {
        for (x in 0 until n) {
            val char = matrix2D[y][x]
            var bCount = 0
            var wCount = 0

            if (!visited[y][x]) {
                val q: Queue<IntArray> = LinkedList()
                q.add(intArrayOf(x, y))
                visited[y][x] = true
                if (char == 'W') wCount++ else bCount++
                while (q.isNotEmpty()) {
                    val (currentX, currentY) = q.poll()

                    repeat(4) {
                        val nx = currentX + dx[it]
                        val ny = currentY + dy[it]

                        if (ny !in 0 until m || nx !in 0 until n) return@repeat
                        if (!visited[ny][nx] && matrix2D[ny][nx] == char) {
                            q.add(intArrayOf(nx, ny))
                            visited[ny][nx] = true
                            if (char == 'W') wCount++ else bCount++
                        }
                    }

                }
            }

            wResult += wCount * wCount
            bResult += bCount * bCount
        }
    }
    println("$wResult $bResult")

}

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (m, n) = br.readLine().trim().split(" ").map(String::toInt)
    val matrix = Array(n) { IntArray(m) }
    val visited = Array(n) { BooleanArray(m) { false } }
    val distance = Array(n) { IntArray(m) { 0 } }
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    for (i in 0 until n) {
        val line = br.readLine().split("").drop(1).dropLast(1).map(String::toInt).toIntArray()
        matrix[i] = line
    }

    // X, Y, Distance(0, 1)
    val pQueue = PriorityQueue<IntArray>(compareBy({ it[2] }))
    pQueue.add(intArrayOf(0, 0, 0))
    visited[0][0] = true

    while (pQueue.isNotEmpty()) {
        val (currentX, currentY, currentWeight) = pQueue.poll()

        if (currentX == n - 1 && currentY == m - 1) {
            println(currentWeight)
            return
        }

        repeat(4) {
            val nx = currentX + dx[it]
            val ny = currentY + dy[it]

            if (nx !in 0 until n || ny !in 0 until m) return@repeat
            if (visited[nx][ny]) return@repeat

            distance[nx][ny] = matrix[nx][ny] + currentWeight
            visited[nx][ny] = true
            pQueue.add(intArrayOf(nx, ny, distance[nx][ny]))
        }
    }

    println(distance[n-1][m-1])
}

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (m, n, h) = br.readLine().trim().split(" ").map(String::toInt)
    val matrix3D = Array(h) { Array(n) { IntArray(m) { 0 } } }
    val dx = intArrayOf(1, 0, -1, 0, 0, 0)
    val dy = intArrayOf(0, 1, 0, -1, 0, 0)
    val dz = intArrayOf(0, 0, 0, 0, 1, -1)
    val q: Queue<IntArray> = LinkedList()
    var flag = true
    var result = Int.MIN_VALUE

    for (z in 0 until h) {
        for (y in 0 until n) {
            val line = br.readLine().trim().split(" ").map(String::toInt).toIntArray()
            for (x in 0 until m) {
                matrix3D[z][y][x] = line[x]
                if (line[x] == 0) flag = false else if (line[x] == 1) q.add(intArrayOf(x, y, z))
            }
        }
    }

    if (flag) {
        println(0)
        return
    }

    while (q.isNotEmpty()) {
        val (x, y, z) = q.poll()

        repeat(6) {
            val nx = x + dx[it]
            val ny = y + dy[it]
            val nz = z + dz[it]

            if (nx !in 0 until m || ny !in 0 until n || nz !in 0 until h) return@repeat
            if (matrix3D[nz][ny][nx] == 0) {
                q.add(intArrayOf(nx, ny, nz))
                matrix3D[nz][ny][nx] = matrix3D[z][y][x] + 1
            }
        }
    }

    for (z in 0 until h) {
        for (y in 0 until n) {
            for (x in 0 until m) {
                if (matrix3D[z][y][x] == 0) {
                    println(-1)
                    return
                }
                result = maxOf(result, matrix3D[z][y][x])
            }
        }
    }

    println(result - 1)
}

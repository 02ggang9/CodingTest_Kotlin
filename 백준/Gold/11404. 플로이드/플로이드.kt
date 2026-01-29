fun main() {
    val INF = 0x3f3f3f3f
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val distance = Array(n + 1) { IntArray(n + 1) { INF } }

    repeat(m) {
        val (start, end, weight) = br.readLine().split(" ").map(String::toInt).toIntArray()
        distance[start][end] = minOf(distance[start][end], weight)
    }

    repeat(n) {
        distance[it + 1][it + 1] = 0
    }

    for (k in 1 until n + 1) {
        for (i in 1 until n + 1) {
            for (j in 1 until n + 1) {
                if (distance[i][j] > distance[i][k] + distance[k][j]) distance[i][j] = minOf(distance[i][j], distance[i][k] + distance[k][j])
            }
        }
    }

    val result = StringBuilder()

    for (i in 1 until n + 1) {
        for (j in 1 until n + 1) {
            if (distance[i][j] == INF) result.append("0 ") else result.append("${distance[i][j]} ")
        }
        if (i != n) result.append("\n")
    }

    println(result.toString())
}

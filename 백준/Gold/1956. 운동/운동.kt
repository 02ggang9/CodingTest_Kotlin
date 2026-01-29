fun main() {
    val INF = 0x3f3f3f3f
    val br = System.`in`.bufferedReader()
    val (v, e) = br.readLine().split(" ").map(String::toInt)
    val distance = Array(v + 1) { IntArray(v + 1) { INF } }

    repeat(e) {
        val (start, end, weight) = br.readLine().split(" ").map(String::toInt)
        distance[start][end] = minOf(distance[start][end], weight)
    }

    for (k in 1 until v + 1) {
        for (i in 1 until v + 1) {
            for (j in 1 until v + 1) {
                if (distance[i][j] > distance[i][k] + distance[k][j]) distance[i][j] = minOf(distance[i][j], distance[i][k] + distance[k][j])
            }
        }
    }

    var result = Int.MAX_VALUE
    for (i in 1 until v + 1) {
        result = minOf(result, distance[i][i])
    }

    if (result == INF) println(-1) else println(result)
}

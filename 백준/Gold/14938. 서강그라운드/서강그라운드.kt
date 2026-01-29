fun main() {
    val INF = 0x3f3f3f3f
    val br = System.`in`.bufferedReader()
    val (n, m, r) = br.readLine().split(" ").map(String::toInt)
    val itemCounts = IntArray(n + 1) { 0 }
    val counts = br.readLine().split(" ").map(String::toInt)
    val distance = Array(n + 1) { IntArray(n + 1) { INF } }

    for (i in 0 until n) itemCounts[i + 1] = counts[i]

    repeat(r) {
        val (start, end, weight) = br.readLine().split(" ").map(String::toInt)
        distance[start][end] = minOf(distance[start][end], weight)
        distance[end][start] = minOf(distance[end][start], weight)
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

    var result = 0

    for (i in 1 until n + 1) {
        var temp = 0
        for (j in 1 until n + 1) {
            if (distance[i][j] != INF && distance[i][j] <= m) temp += itemCounts[j]
        }
        result = maxOf(result, temp)
    }

    println(result)
}

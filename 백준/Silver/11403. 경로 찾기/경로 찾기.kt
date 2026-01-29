fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val INF = 0x3f3f3f3f
    val distance = Array(n + 1) { IntArray(n + 1) { INF } }

    for (i in 0 until n) {
        val line = br.readLine().split(" ").map(String::toInt).toIntArray()
        for (j in 0 until n) {
            if (line[j] == 0) continue
            distance[i + 1][j + 1] = line[j]
        }
    }

    for (k in 1 until n + 1) {
        for (i in 1 until n + 1) {
            for (j in 1 until n + 1) {
                if (distance[i][j] > distance[i][k] + distance[k][j]) distance[i][j] = minOf(distance[i][j], distance[i][k] + distance[i][k])
            }
        }
    }

    val resultBuilder = StringBuilder()

    for (i in 1 until n + 1) {
        for (j in 1 until n + 1) {
            if (distance[i][j] != INF) resultBuilder.append("1 ") else resultBuilder.append("0 ")
        }

        if (i != n) resultBuilder.append("\n")
    }

    println(resultBuilder.toString())
}
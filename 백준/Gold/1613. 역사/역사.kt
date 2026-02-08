fun main() {
    val INF = 0x3f3f3f3f
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().trim().split(" ").map(String::toInt)
    val matrix = Array(n + 1) { IntArray(n + 1) { INF } }

    repeat(k) {
        val (first, second) = br.readLine().trim().split(" ").map(String::toInt)
        matrix[first][second] = 1
    }

    repeat(n) {
        matrix[it + 1][it + 1] = 0
    }

    for (k in 1 until n + 1) {
        for (i in 1 until n + 1) {
            for (j in 1 until n + 1) {
                if (matrix[i][j] > matrix[i][k] + matrix[k][j]) matrix[i][j] = matrix[i][k] + matrix[k][j]
            }
        }
    }

    val s = br.readLine().toInt()
    val resultBuilder = StringBuilder()

    repeat(s) {
        val (first, second) = br.readLine().trim().split(" ").map(String::toInt)
        val way = matrix[first][second]
        val otherWay = matrix[second][first]

        if (way == INF && otherWay == INF) {
            resultBuilder.append(0).append("\n")
        } else if (way != INF && otherWay == INF) {
            resultBuilder.append(-1).append("\n")
        } else if (way == INF && otherWay != INF) {
            resultBuilder.append(1).append("\n")
        }
    }

    println(resultBuilder.toString())
}

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val matrix = Array(n) { IntArray(n + 1) { 0 } }
    val dp = Array(n) { IntArray(n + 1) { 0 } }

    repeat(n) {
        val line = br.readLine().split(" ").map(String::toInt)
        for (i in 0 until line.size) matrix[it][i] = line[i]
    }

    dp[0][0] = matrix[0][0]

    for (i in 0 until n - 1) {
        for (j in 0 until i + 1) {
            dp[i + 1][j] = maxOf(dp[i + 1][j], dp[i][j] + matrix[i + 1][j])
            dp[i + 1][j + 1] = maxOf(dp[i + 1][j + 1], dp[i][j] + matrix[i + 1][j + 1])
        }
    }

    println(dp[n - 1].max())
}

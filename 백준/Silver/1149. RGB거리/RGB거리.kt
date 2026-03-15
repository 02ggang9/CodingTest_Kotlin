fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val (r, g, b) = br.readLine().split(" ").map(String::toInt).toIntArray()
    val dp = Array(n) { IntArray(3) { 0 } }

    dp[0][0] = r
    dp[0][1] = g
    dp[0][2] = b

    for (i in 1 until n) {
        val (r, g, b) = br.readLine().split(" ").map(String::toInt).toIntArray()
        dp[i][0] = minOf(dp[i - 1][1], dp[i - 1][2]) + r
        dp[i][1] = minOf(dp[i - 1][0], dp[i - 1][2]) + g
        dp[i][2] = minOf(dp[i - 1][0], dp[i - 1][1]) + b
    }

    println(dp[n - 1].min())
}

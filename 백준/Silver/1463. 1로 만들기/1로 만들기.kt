fun main() {
    val INF = 0x3f3f3f3f
    val br = System.`in`.bufferedReader()
    var n = br.readLine().toInt()
    val dp = IntArray(n + 1) { INF }
    dp[1] = 0

    for (i in 2 until n + 1) {
        dp[i] = minOf(dp[i], dp[i - 1]) + 1
        if (i % 2 == 0) {
            dp[i] = minOf(dp[i], dp[i / 2] + 1)
        }

        if (i % 3 == 0) {
            dp[i] = minOf(dp[i], dp[i / 3] + 1)
        }
    }

    println(dp[n])
}

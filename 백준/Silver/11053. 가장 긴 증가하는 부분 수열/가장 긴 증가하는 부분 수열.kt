fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val array = br.readLine().split(" ").map(String::toInt).toIntArray()
    val dp = IntArray(n) { 1 }

    for (i in 0 until n) {
        for (j in 0 until i) {
            if (array[i] > array[j]) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }

    println(dp.max())
}

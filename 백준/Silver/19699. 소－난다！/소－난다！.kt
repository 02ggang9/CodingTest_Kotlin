fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br
        .readLine()
        .trim()
        .split(" ")
        .map(String::toInt)

    val cowWeights = br
        .readLine()
        .trim()
        .split(" ")
        .map(String::toInt)
        .toIntArray()

    val visited = BooleanArray(n) { false }
    val result = mutableListOf<Int>()
    val tempWeights = IntArray(m) { 0 }

    fun isPrime(n: Int): Boolean {
        if (n <= 1) return false
        if (n <= 3) return true

        var i = 2
        while (i * i <= n) {
            if (n % i == 0) return false
            i++
        }

        return true
    }

    fun recursive(k: Int) {
        if (k == m) {
            val sum = tempWeights.sum()
            if (isPrime(sum) && !result.contains(sum)) result.add(sum)
            return
        }

        for (i in 0 until n) {
            if (!visited[i]) {
                visited[i] = true
                tempWeights[k] = cowWeights[i]
                recursive(k + 1)
                visited[i] = false
            }
        }
    }

    recursive(0)
    if (result.isNotEmpty()) println(result.sortedWith(compareBy({ it })).joinToString(" ")) else println(-1)
}
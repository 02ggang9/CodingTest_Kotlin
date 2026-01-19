import kotlin.math.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val numbers = br
        .readLine()
        .trim()
        .split(" ")
        .map(String::toInt)
        .toIntArray()

    val visited = BooleanArray(n) { false }
    val tempNumbers = IntArray(n) { 0 }
    var result = Int.MIN_VALUE

    fun recursive(k: Int) {
        if (k == n) {
            var temp = 0

            for (i in 0 until n - 1) {
                temp += abs(tempNumbers[i] - tempNumbers[i + 1])
            }

            result = maxOf(result, temp)
            return
        }

        for (i in 0 until n) {
            if (!visited[i]) {
                visited[i] = true
                tempNumbers[k] = numbers[i]

                recursive(k + 1)

                visited[i] = false
            }
        }
    }

    recursive(0)
    println(result)
}

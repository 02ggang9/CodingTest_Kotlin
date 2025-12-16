import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val firstLine = StringTokenizer(br.readLine())
    val secondLine = StringTokenizer(br.readLine())
    val thirdLine = StringTokenizer(br.readLine())
    var result = 0

    val n = firstLine.nextToken().toInt()
    val m = firstLine.nextToken().toInt()
    val scoreMatrix = Array(2) { IntArray(3) }

    repeat(3) { scoreMatrix[0][it] = secondLine.nextToken().toInt() }
    repeat(3) { scoreMatrix[1][it] = thirdLine.nextToken().toInt() }

    fun f(n: Int, sum: Int, prevJ: Int) {
        if (n == 0) {
            if (sum >= m) result++
            return
        }

        f(n - 1, sum + if (prevJ == 0) scoreMatrix[0][0] / 2 else scoreMatrix[0][0], 0)
        f(n - 1, sum + if (prevJ == 1) scoreMatrix[0][1] / 2 else scoreMatrix[0][1], 1)
        f(n - 1, sum + if (prevJ == 2) scoreMatrix[0][2] / 2 else scoreMatrix[0][2], 2)
        f(n - 1, sum + if (prevJ == 0) scoreMatrix[1][0] / 2 else scoreMatrix[1][0], 0)
        f(n - 1, sum + if (prevJ == 1) scoreMatrix[1][1] / 2 else scoreMatrix[1][1], 1)
        f(n - 1, sum + if (prevJ == 2) scoreMatrix[1][2] / 2 else scoreMatrix[1][2], 2)
    }

    f(n, 0, -1)

    println(result)
}

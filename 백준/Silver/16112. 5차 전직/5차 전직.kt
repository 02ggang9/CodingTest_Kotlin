import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val firstLine = StringTokenizer(br.readLine())
    val secondLine = StringTokenizer(br.readLine())

    val n = firstLine.nextToken().toInt()
    val k = firstLine.nextToken().toInt()

    val maxExs = IntArray(n)
    repeat(n) { maxExs[it] = secondLine.nextToken().toInt() }
    maxExs.sort()

    var activation = 0
    var result = 0L

    repeat(n) {
        result += maxExs[it].toLong() * activation
        if (activation < k) {
            activation++
        }
    }

    println(result)
}
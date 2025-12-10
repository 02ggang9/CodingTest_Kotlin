import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val line1 = StringTokenizer(br.readLine())
    val line2 = StringTokenizer(br.readLine())
    val n = line1.nextToken().toInt()
    val xPoints = IntArray(n)

    repeat(n) { xPoints[it] = line2.nextToken().toInt() }

    val sortedXPoints = xPoints.toSet().toIntArray().sortedWith(compareBy({ it }))
    val hashMap = HashMap<Int, Int>(sortedXPoints.size)
    sortedXPoints.forEachIndexed { index, value -> hashMap[value] = index }

    val result = StringBuilder()
    xPoints.forEach { result.append(hashMap[it]).append(" ") }

    println(result.toString())
}

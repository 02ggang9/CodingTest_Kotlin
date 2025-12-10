import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val line1 = StringTokenizer(br.readLine())
    val line2 = StringTokenizer(br.readLine())

    val n = line1.nextToken().toInt()
    val xPoints = IntArray(n)

    repeat(n) { xPoints[it] = line2.nextToken().toInt() }

    val sortedXPoints = xPoints.toSortedSet().toIntArray()
    val hashMap = HashMap<Int, Int>(sortedXPoints.size)
    sortedXPoints.forEachIndexed { index, value -> hashMap[value] = index }

    xPoints.forEach { bw.write("${hashMap[it]} ") }

    bw.flush()
    bw.close()
}

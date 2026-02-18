import kotlin.math.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map(String::toInt)
    val cPosition = mutableListOf<IntArray>()
    val hPosition = mutableListOf<IntArray>()

    for (i in 0 until n) {
        val line = br.readLine().split(" ").map(String::toInt)
        for (j in 0 until n) {
            if (line[j] == 2) cPosition.add(intArrayOf(i, j)) else if (line[j] == 1) hPosition.add(intArrayOf(i, j))
        }
    }

    val cCombination = IntArray(m) { 0 }
    var result = Int.MAX_VALUE

    fun recursive(start: Int, depth: Int) {
        if (depth == m) {
            var cDistance = 0
            for (i in 0 until hPosition.size) {
                var minTemp = Int.MAX_VALUE
                for (j in 0 until m) {
                    val cIndex = cCombination[j]
                    val (cX, cY) = cPosition[cIndex]
                    val (hX, hY) = hPosition[i]
                    val distance = abs(cX - hX) + abs(cY - hY)

                    minTemp = minOf(minTemp, distance)
                }

                cDistance += minTemp
            }

            result = minOf(result, cDistance)
            return
        }

        for (i in start until cPosition.size) {
            cCombination[depth] = i
            recursive(i + 1, depth + 1)
        }
    }

    recursive(0, 0)

    println(result)
}

import kotlin.math.*

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val intArray: IntArray = br
            .readLine()
            .trim()
            .split(" ")
            .map { it.toInt() }
            .toIntArray()
            .sortedArray()

        var result = Int.MIN_VALUE

        for (i in 0 until n-2) {
            result = max(abs(intArray[i] - intArray[i+2]), result)
        }

        println(result)
    }
}

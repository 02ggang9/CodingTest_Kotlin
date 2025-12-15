import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val firstLine = StringTokenizer(br.readLine())
    val secondLine = StringTokenizer(br.readLine())

    val n = firstLine.nextToken().toInt()
    val k = firstLine.nextToken().toInt()

    val nums = IntArray(n)
    repeat(n) { nums[it] = secondLine.nextToken().toInt() }

    var leftPoint = 0
    var evenNumberCount = 0
    var oddNumberCount = 0
    var maxCount = Int.MIN_VALUE

    repeat(n) {
        if (nums[it] % 2 == 0) evenNumberCount++ else oddNumberCount++

        while (oddNumberCount > k) {
            if (nums[leftPoint] % 2 == 0) evenNumberCount-- else oddNumberCount--
            leftPoint++
        }

        maxCount = maxOf(maxCount, evenNumberCount)
    }

    println(maxCount)
}
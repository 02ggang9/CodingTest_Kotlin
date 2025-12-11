import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val firstLine = StringTokenizer(br.readLine())
    val secondLine = StringTokenizer(br.readLine())

    val n = firstLine.nextToken().toInt()
    val fruits = IntArray(n)
    val fruitsMap = HashMap<Int, Int>()

    repeat(n) { fruits[it] = secondLine.nextToken().toInt() }


    var leftPointer = 0
    var rightPointer = 0
    var maxLength = Int.MIN_VALUE

    while (rightPointer < n) {
        val value = fruits[rightPointer]
        fruitsMap[value] = fruitsMap[value]?.plus(1) ?: 1

        while (fruitsMap.size > 2) {
            fruitsMap[fruits[leftPointer]] = fruitsMap[fruits[leftPointer]]!!.minus(1)
            if (fruitsMap[fruits[leftPointer]] == 0) fruitsMap.remove(fruits[leftPointer])
            leftPointer++
        }

        maxLength = maxOf(maxLength, rightPointer - leftPointer + 1)
        rightPointer++
    }

    println(maxLength)
}

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().trim().split(" ").map(String::toInt)
    val distance = IntArray(100_000 * 2 + 1) { Int.MAX_VALUE }
    val pQueue = PriorityQueue<IntArray>(compareBy({ it[1] }))

    pQueue.add(intArrayOf(n, 0))
    distance[n] = 0

    while (pQueue.isNotEmpty()) {
        val (currentIndex, currentDistance) = pQueue.poll()

        if (currentDistance > distance[currentIndex]) continue

        val telIndex = currentIndex * 2
        if (telIndex in 0 until 100_000 * 2 + 1 && distance[telIndex] > distance[currentIndex]) {
            distance[telIndex] = distance[currentIndex]
            pQueue.add(intArrayOf(telIndex, distance[telIndex]))
        }

        val leftIndex = currentIndex - 1
        if (leftIndex in 0 until 100_000 * 2 + 1 && distance[leftIndex] > distance[currentIndex] + 1) {
            distance[leftIndex] = distance[currentIndex] + 1
            pQueue.add(intArrayOf(leftIndex, distance[leftIndex]))
        }

        val rightIndex = currentIndex + 1
        if (rightIndex in 0 until 100_000 * 2 + 1 && distance[rightIndex] > distance[currentIndex] + 1) {
            distance[rightIndex] = distance[currentIndex] + 1
            pQueue.add(intArrayOf(rightIndex, distance[rightIndex]))
        }
    }

    println(distance[k])
}

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (v, e) = br
        .readLine()
        .trim()
        .split(" ")
        .map(String::toInt)

    val matrix = Array(v + 1) { mutableListOf<IntArray>() }
    val distance = IntArray(v + 1) { Int.MAX_VALUE }
    val k = br.readLine().toInt()

    repeat(e) {
        val (start, end, distance) = br.readLine().split(" ").map(String::toInt)
        matrix[start].add(intArrayOf(end, distance))
    }

    val qQueue = PriorityQueue<IntArray>(compareBy({ it[1] }))

    qQueue.add(intArrayOf(k, 0))
    distance[k] = 0

    while(qQueue.isNotEmpty()) {
        val (currentStart, currentDistance) = qQueue.poll()

        // 큐에서 꺼낸 거리가 현재 distance에 기록된 거리보다 크면 무시
        if (distance[currentStart] != currentDistance) continue

        for ((nextIndex, nextDistance) in matrix[currentStart]) {
            if (distance[nextIndex] > currentDistance + nextDistance) {
                distance[nextIndex] = currentDistance + nextDistance
                qQueue.add(intArrayOf(nextIndex, distance[nextIndex]))
            }
        }
    }

    val resultBuilder = StringBuilder()
    for (i in 1 until v + 1) {
        if (distance[i] != Int.MAX_VALUE) resultBuilder.append(distance[i]).append("\n")
        else resultBuilder.append("INF\n")
    }

    println(resultBuilder.toString())
}

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().trim().split(" ").map { it.toInt() }
    val sortedIntArray = br.readLine().trim().split(" ").map { it.toInt() }.toIntArray().sortedArray()

    var start = 0L
    var end = sortedIntArray[n-1].toLong()
    var result = 0L

    while (start <= end) {
        val mid = (start + end) / 2
        val sum = sortedIntArray
            .map { if (it < mid) 0 else it - mid }
            .sum()
            .toLong()

        if (sum > m) {
            result = mid
            start = mid + 1
        } else if (sum == m.toLong()) {
            result = mid
            break
        } else {
            end = mid - 1
        }
    }

    println(result)

}
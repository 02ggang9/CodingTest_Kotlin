fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val list = Array(n) { IntArray(2) }

    repeat(n) {
        val (start, end) = br.readLine().trim().split(" ").map(String::toInt)
        list[it] = intArrayOf(start, end)
    }

    val sortedList = list.sortedWith(compareBy({ it[1] }, { it[0] }))
    var result = 0
    var endTime = -1

    for (i in 0 until n) {
        val (start, end) = sortedList[i]

        if (start >= endTime) {
            endTime = end
            result++
        }
    }

    println(result)
}

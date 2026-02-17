fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val matrix = Array(n) { IntArray(3) { 0 } }

    for (i in 0 until n) {
        val line = br.readLine().split(" ").map(String::toInt)
        for (j in 0 until 3) {
            matrix[i][j] = line[j]
        }
    }

    val maxArray = intArrayOf(0, 0, 0)
    val minArray = intArrayOf(0, 0, 0)

    for (i in 0 until n) {
        val tempMax = intArrayOf(0, 0, 0)
        val tempMin = intArrayOf(0, 0, 0)

        // 첫번째 줄
        tempMax[0] = maxOf(maxArray[0], maxArray[1]) + matrix[i][0]
        tempMin[0] = minOf(minArray[0], minArray[1]) + matrix[i][0]

        // 두번째줄
        tempMax[1] = maxOf(maxArray[0], maxArray[1], maxArray[2]) + matrix[i][1]
        tempMin[1] = minOf(minArray[0], minArray[1], minArray[2]) + matrix[i][1]

        // 세번째줄
        tempMax[2] = maxOf(maxArray[1], maxArray[2]) + matrix[i][2]
        tempMin[2] = minOf(minArray[1], minArray[2]) + matrix[i][2]

        repeat(3) {
            maxArray[it] = tempMax[it]
            minArray[it] = tempMin[it]
        }
    }

    println("${maxArray.max()} ${minArray.min()}")
}

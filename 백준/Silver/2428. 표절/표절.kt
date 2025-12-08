fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val fileSizes = br.readLine().trim().split(" ").map { it.toLong() }.sortedWith(compareBy({ it } ))
    var result = 0L
    var rightPointer = 0

    repeat(fileSizes.size) { leftPointer ->
        val targetSize = fileSizes[leftPointer] * 10 / 9
        while (rightPointer < fileSizes.size && fileSizes[rightPointer] <= targetSize) rightPointer++
        result += (rightPointer - leftPointer - 1)
    }

    println(result)
}
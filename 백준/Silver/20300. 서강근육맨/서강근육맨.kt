fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val loss = br.readLine().split(" ").map { it.toLong() }.sortedWith(compareBy({ it }))

    var leftPointer = 0
    var rightPointer = if (n % 2 == 0) n - 1 else n - 2
    var maxM = if (n % 2 == 0) 0L else loss[n - 1]

    while(leftPointer < rightPointer) {
        maxM = maxOf(maxM, loss[leftPointer] + loss[rightPointer])
        leftPointer++
        rightPointer--
    }

    println(maxM)
}
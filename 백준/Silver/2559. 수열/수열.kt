fun main() {
    var br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().trim().split(" ").map{ it.toInt() }
    val temps = br.readLine().trim().split(" ").map { it.toInt() }

    var leftPointer = 0
    var rightPointer = 0
    var sum = 0
    var flag = true
    val tempSumList = mutableListOf<Int>()

    for (i in 0 until n - k + 1) {
        leftPointer = i
        rightPointer = leftPointer + k - 1

        if (flag) {
            for (i in leftPointer until rightPointer + 1) {
                sum += temps[i]
            }

            flag = false
        } else {
            sum -= temps[leftPointer - 1]
            sum += temps[rightPointer]
        }

        tempSumList.add(sum)
    }

    println(tempSumList.max())
}

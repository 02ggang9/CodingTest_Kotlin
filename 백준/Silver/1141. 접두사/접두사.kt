fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val stringArray = Array(n) { "" }

    repeat(n) { stringArray[it] = br.readLine() }

    val sortedArray = stringArray.sortedArray()
    var result = 0

    for (i in 0 until n - 1) {
        if (!sortedArray[i+1].startsWith(sortedArray[i])) result++
    }

    result++
    println(result)
}

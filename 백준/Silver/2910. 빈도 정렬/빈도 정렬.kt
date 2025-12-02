fun main() {
    val br = System.`in`.bufferedReader()
    val (n, c) = br.readLine().split(" ").map { it.toInt() }
    val numbers = br
        .readLine()
        .split(" ")
        .map { it.toInt() }

    val numberCount = LinkedHashMap<Int, Int>()

    numbers.forEach {
        if (numberCount[it] == null) {
            numberCount[it] = 1
        } else {
            numberCount[it] = numberCount[it]!! + 1
        }
    }

    val sortedNumbers = numberCount.toList().sortedWith(compareBy({ -it.second }))
    val result = StringBuilder()

    sortedNumbers.forEach { n1 ->
        repeat(n1.second) {
            result.append(n1.first).append(" ")
        }
    }

    println(result.toString())
    br.close()
}
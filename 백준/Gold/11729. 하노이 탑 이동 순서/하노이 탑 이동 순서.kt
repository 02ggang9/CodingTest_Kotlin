fun main() {
    val n = readln().toInt()
    var result = 0
    val resultBuilder = StringBuilder()

    fun hanoi(n: Int, start: Int, end: Int) {
        if (n == 1) {
            result++
            resultBuilder.append("$start $end\n")
            return
        }
        hanoi(n-1, start, 6 - start - end)
        resultBuilder.append("$start $end\n")
        result++
        hanoi(n-1, 6 - start - end, end)
    }

    hanoi(n, 1, 3)
    println(result)
    println(resultBuilder.toString())
}

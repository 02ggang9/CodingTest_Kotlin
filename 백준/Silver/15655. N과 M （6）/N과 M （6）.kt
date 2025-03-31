fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }.sorted()
    val resultBuilder = StringBuilder()
    val intArray = IntArray(m) { 0 }

    fun back(depth: Int, startIndex: Int) {
        if (depth == m) {
            resultBuilder.append(intArray.joinToString(" ")).append("\n")
            return
        }

        for (i in startIndex until n) {
            intArray[depth] = numbers[i]
            back(depth + 1, i + 1)
        }
    }

    back(0, 0)
    println(resultBuilder.toString())
}
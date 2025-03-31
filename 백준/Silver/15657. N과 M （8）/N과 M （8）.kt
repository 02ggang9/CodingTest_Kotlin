fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray().sortedArray()
    val sequence = IntArray(m) { 0 }
    val resultBuilder = StringBuilder()

    fun back(depth: Int, startIndex: Int) {
        if (depth == m) {
            resultBuilder.append(sequence.joinToString(" ")).append("\n")
            return
        }

        for (i in startIndex until n) {
            sequence[depth] = numbers[i]
            back(depth + 1, i)
        }
    }

    back(0, 0)
    println(resultBuilder.toString())
}
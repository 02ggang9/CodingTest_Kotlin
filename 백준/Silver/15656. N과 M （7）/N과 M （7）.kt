fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val intArray = readln().split(" ").map { it.toInt() }.toIntArray().sortedArray()
    val resultBuilder = StringBuilder()
    val sequence = IntArray(m) { 0 }

    fun back(depth: Int) {
        if (depth == m) {
            resultBuilder.append(sequence.joinToString(" ")).append("\n")
            return
        }

        for (i in 0 until n) {
            sequence[depth] = intArray[i]
            back(depth + 1)
        }
    }

    back(0)
    println(resultBuilder.toString())
}
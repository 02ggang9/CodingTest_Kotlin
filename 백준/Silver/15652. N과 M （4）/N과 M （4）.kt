fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val resultBuilder = StringBuilder()
    val intArray = IntArray(m) { 0 }

    fun back(depth: Int, startNumber: Int) {
        // baseCondition
        if (depth == m) {
            resultBuilder.append(intArray.joinToString(" ")).append("\n")
            return
        }

        for (i in startNumber until n) {
            intArray[depth] = i + 1
            back(depth + 1, i)
        }
    }

    back(0, 0)
    println(resultBuilder.toString())
}
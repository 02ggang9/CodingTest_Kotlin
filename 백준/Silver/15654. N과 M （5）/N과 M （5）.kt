fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }.sorted()
    val visited = BooleanArray(n) { false }
    val resultBuilder = StringBuilder()
    val intArray = IntArray(m) { 0 }

    fun back(depth: Int) {
        if (depth == m) {
            resultBuilder.append(intArray.joinToString(" ")).append("\n")
            return
        }

        for (i in 0 until  n) {
            if (!visited[i]) {
                visited[i] = true
                intArray[depth] = numbers[i]
                back(depth + 1)
                visited[i] = false
            }
        }
    }

    back(0)
    println(resultBuilder.toString())
}
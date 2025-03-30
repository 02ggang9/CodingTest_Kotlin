fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val visited = BooleanArray(n) { false }
    val intArray = IntArray(m) { 0 }

    fun back(depth: Int, startIndex: Int) {
        if (depth == m) {
            println(intArray.joinToString(" "))
            return
        }

        for (i in startIndex until n) {
            if (!visited[i]) {
                visited[i] = true
                intArray[depth] = i + 1
                back(depth + 1, i + 1)
                visited[i] = false
            }
        }
    }

    back(0, 0)
}

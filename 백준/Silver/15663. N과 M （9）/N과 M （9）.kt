fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val sequence = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    val resultBuilder = StringBuilder()
    val visited = BooleanArray(n) { false }
    val intArray = IntArray(m) { 0 }
    val container = HashMap<String, String>()

    fun back(depth: Int) {
        if (depth == m) {
            val key = intArray.joinToString(" ")
            if (!container.containsKey(key)) {
                resultBuilder.append(key).append("\n")
            }
            container[key] = ""
            return
        }

        for (i in 0 until n) {
            if (!visited[i]) {
                intArray[depth] = sequence[i]
                visited[i] = true
                back(depth + 1)
                visited[i] = false
            }
        }
    }

    back(0)
    println(resultBuilder.toString())
}

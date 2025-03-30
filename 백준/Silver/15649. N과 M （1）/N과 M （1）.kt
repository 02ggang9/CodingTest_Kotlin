fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val visited = BooleanArray(n) { false }
    val array = IntArray(m) { 0 }
    fun back(depth: Int) {
        // baseCondition
        if (depth == m) {
            println(array.joinToString(" "))
            return
        }

        for (i in 0 until n) {
            if (!visited[i]) {
                visited[i] = true
                array[depth] = i + 1
                back(depth + 1)
                visited[i] = false
            }
        }
    }

    back(0)
}
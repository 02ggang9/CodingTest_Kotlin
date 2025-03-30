fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val array = IntArray(m) { 0 }
    val result = StringBuilder()

    fun back(depth: Int) {
        // baseCondition
        if (depth == m) {
            result.append(array.joinToString(" "))
            result.append("\n")
            return
        }

        for (i in 0 until n) {
            array[depth] = i + 1
            back(depth + 1)
        }
    }

    back(0)
    println(result.toString())
}
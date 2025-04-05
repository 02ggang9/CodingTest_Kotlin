fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val alphas = readln().split(" ").map { it[0] }.sorted()

    val result = CharArray(n)
    val mos = arrayOf<Char>('a', 'e', 'i', 'o', 'u')
    val resultBuilder = StringBuilder()

    fun back(depth: Int, startIndex: Int) {
        if (depth == n) {
            var moCount = 0
            var jaCount = 0
            result.forEach { if (mos.contains(it)) moCount++ else jaCount++ }
            if (moCount >= 1 && jaCount >= 2) {
                resultBuilder.append(result.joinToString("")).append("\n")
            }
            return
        }

        for (i in startIndex until m) {
            result[depth] = alphas[i]
            back(depth + 1, i + 1)
        }
    }
    back(0, 0)
    println(resultBuilder.toString())
}
fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().trim().split(" ").map { it.toInt() }
    val arrays = CharArray(n)
    val visited = BooleanArray(n) { false }
    val line = br.readLine()!!
    var result = 0

    line.forEachIndexed { index, it -> arrays[index] = it }

    arrays.forEachIndexed { index, it ->
        if (it == 'P') {
            // 왼쪽 탐색
            for (i in k downTo 1) {
                if (index - i < 0) continue

                if (!visited[index - i] && arrays[index - i] == 'H') {
                    visited[index - i] = true
                    result++
                    return@forEachIndexed
                }
            }

            // 오른쪽 탐색
            for (i in 1 until k + 1) {
                if (index + i > n - 1) continue

                if (!visited[index + i] && arrays[index + i] == 'H') {
                    visited[index + i] = true
                    result++
                    return@forEachIndexed
                }
            }
        }
    }

    println(result)
}

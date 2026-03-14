fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map(String::toInt)
    val sortedArray = br.readLine().split(" ").map(String::toInt).toSet().toIntArray().sortedWith(compareBy { it })
    val result = IntArray(m) { 0 }

    fun recursive(depth: Int, k: Int) {
        if (depth == m) {
            println(result.joinToString(" "))
            return
        }

        for (i in k until sortedArray.size) {
            result[depth] = sortedArray[i]
            recursive(depth + 1, i)
        }
    }

    recursive(0, 0)
}

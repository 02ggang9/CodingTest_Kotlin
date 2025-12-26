fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val matrix = Array(n) { IntArray(n) { 0 } }

    repeat(n) {
        val line = br.readLine().trim().split(" ").map { it.toInt() }.toIntArray()
        matrix[it] = line
    }

    fun recursive(k: Int, x: Int, y: Int): Int {
        if (k == 1) return matrix[x][y]
        
        if (k == 2) {
            return intArrayOf(
                matrix[x][y],
                matrix[x + 1][y],
                matrix[x][y + 1],
                matrix[x + 1][y + 1],
            ).sortedWith(compareBy({ it }))[1]
        }

        val half = k / 2
        return intArrayOf(
            recursive(half, x, y),
            recursive(half, x + half, y),
            recursive(half, x, y + half),
            recursive(half, x + half, y + half),
        ).sortedWith(compareBy({ it }))[1]
    }

    println(recursive(n, 0, 0))
}
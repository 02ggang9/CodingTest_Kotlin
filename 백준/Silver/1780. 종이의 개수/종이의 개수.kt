fun main() {
    val n = readln().toInt()
    val matrix = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val results = IntArray(3) { 0 }

    fun isSame(currentX: Int, currentY: Int, n: Int): Boolean {
        val currentValue = matrix[currentX][currentY]
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (matrix[currentX + i][currentY + j] != currentValue) return false
            }
        }
        return true
    }

    fun recursive(currentX: Int, currentY: Int, n: Int) {
        if (isSame(currentX, currentY, n)) {
            results[matrix[currentX][currentY]+1]++
            return
        }

        for (i in 0 until 3) {
            for (j in 0 until 3) {
                recursive(currentX + (n/3 * i), currentY + (n/3 * j), n/3)
            }
        }
    }

    recursive(0, 0, n)

    println(results[0])
    println(results[1])
    println(results[2])
}

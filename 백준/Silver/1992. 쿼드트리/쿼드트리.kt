fun main() {
    val n = readln().toInt()
    val matrix = Array(n) { readln().split("").filter { it.isNotEmpty() }.map { it.toInt() }}
    val result = StringBuilder()

    fun loop(n: Int, currentX: Int, currentY: Int) {
        val initNumber = matrix[currentX][currentY]
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (matrix[currentX + i][currentY + j] != initNumber) {
                    result.append("(")
                    loop(n/2, currentX, currentY)
                    loop(n/2, currentX, currentY + n/2)
                    loop(n/2, currentX + n/2, currentY)
                    loop(n/2, currentX + n/2, currentY + n/2)
                    result.append(")")
                    return
                }
            }
        }

        result.append(if (initNumber == 1) 1 else 0)
    }

    loop(n, 0, 0)
    println(result.toString())
}

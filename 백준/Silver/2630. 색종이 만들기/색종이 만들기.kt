fun main() {
    val n = readln().toInt()
    val matrix = Array(n) { readln().split(" ").map { it.toInt() } }

    var white = 0
    var blue = 0

    fun loop(n: Int, currentX: Int, currentY: Int) {
        val initialNumber = matrix[currentX][currentY]
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (matrix[currentX + i][currentY + j] != initialNumber) {
                    loop(n/2, currentX, currentY)
                    loop(n/2, currentX + n/2, currentY)
                    loop(n/2, currentX, currentY + n/2)
                    loop(n/2, currentX + n/2, currentY + n/2)
                    return
                }
            }
        }

        if (initialNumber == 1) white += 1 else blue += 1
    }

    loop(n, 0, 0)
    println(blue)
    println(white)
}

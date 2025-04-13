fun main() {
    val n = readln().toInt()
    val matrix = Array(n) { CharArray(n) { '*' } }

    fun loop(n: Int, currentX: Int, currentY: Int) {
        if (n == 3) {
            for (i in 0 until 3) {
                for (j in 0 until 3) {
                    matrix[currentX + i][currentY + j] = '*'
                }
            }
            matrix[currentX + 1][currentY + 1] = ' '
            return
        }

        for (i in 0 until n/3) { for (j in 0 until n/3) { matrix[currentX + i][currentY + j] = '*' } } // 1
        for (i in 0 until n/3) { for (j in 0 until n/3) { matrix[currentX + i][currentY + (n/3 * 1) + j] = '*' } } // 2
        for (i in 0 until n/3) { for (j in 0 until n/3) { matrix[currentX + i][currentY + (n/3 * 2) + j] = '*' } } // 3
        for (i in 0 until n/3) { for (j in 0 until n/3) { matrix[currentX + (n/3 * 1) + i][currentY + (n/3 * 0) + j] = '*' } } // 4
        for (i in 0 until n/3) { for (j in 0 until n/3) { matrix[currentX + (n/3 * 1) + i][currentY + (n/3 * 1) + j] = ' ' } } // 5
        for (i in 0 until n/3) { for (j in 0 until n/3) { matrix[currentX + (n/3 * 1) + i][currentY + (n/3 * 2) + j] = '*' } } // 6
        for (i in 0 until n/3) { for (j in 0 until n/3) { matrix[currentX + (n/3 * 2) + i][currentY + (n/3 * 0) + j] = '*' } } // 7
        for (i in 0 until n/3) { for (j in 0 until n/3) { matrix[currentX + (n/3 * 2) + i][currentY + (n/3 * 1) + j] = '*' } } // 8
        for (i in 0 until n/3) { for (j in 0 until n/3) { matrix[currentX + (n/3 * 2) + i][currentY + (n/3 * 2) + j] = '*' } } // 9


        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (i == 1 && j == 1) continue
                loop(n/3, currentX + ((n/3) * i), currentY + ((n/3) * j))
            }
        }
    }

    loop(n, 0, 0)
    for (row in matrix) {
        println(row.joinToString(""))
    }
}

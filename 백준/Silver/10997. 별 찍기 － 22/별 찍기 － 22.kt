fun main() {
    val br = System.`in`.bufferedReader()
    val s = br.readLine()
    if (s == null) return
    val n = s.toInt()

    if (n == 1) {
        println("*")
        return
    }

    val rows = 4 * n - 1
    val cols = 4 * n - 3
    val arr2D = Array(rows) { CharArray(cols) { ' ' } }

    var x = 2 * (n - 1)
    var y = 2 * n

    arr2D[y][x] = '*'
    arr2D[y-1][x] = '*'
    arr2D[y-2][x] = '*'
    arr2D[y-2][x+1] = '*'
    arr2D[y-2][x+2] = '*'

    y -= 2
    x += 2

    for (k in 2..n) {
        if (k > 2) {
            arr2D[y][x+1] = '*'
            arr2D[y][x+2] = '*'
            x += 2
        }

        // Down: length 4k - 4
        val downLen = 4 * k - 4
        repeat(downLen) {
            y++
            arr2D[y][x] = '*'
        }

        // Left: length 4k - 4
        val leftLen = 4 * k - 4
        repeat(leftLen) {
            x--
            arr2D[y][x] = '*'
        }

        // Up: length 4k - 2
        val upLen = 4 * k - 2
        repeat(upLen) {
            y--
            arr2D[y][x] = '*'
        }

        // Right: length 4k - 4
        val rightLen = 4 * k - 4
        repeat(rightLen) {
            x++
            arr2D[y][x] = '*'
        }
    }

    val result = StringBuilder()
    for (i in 0 until rows) {
        var lastIndex = -1
        for (j in cols - 1 downTo 0) {
            if (arr2D[i][j] != ' ') {
                lastIndex = j
                break
            }
        }

        if (lastIndex != -1) {
            for (j in 0..lastIndex) {
                result.append(arr2D[i][j])
            }
        }
        result.append("\n")
    }

    print(result.toString())
}

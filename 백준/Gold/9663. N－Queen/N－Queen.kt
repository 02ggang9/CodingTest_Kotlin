fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val colCheck = BooleanArray(n) { false }
    // 우상향 -> 더하기의 값이 같음
    // 최소: (0, 0) -> 0, 최대: (N - 1, M - 1) -> N - M + 2
    val rightUpCheck = BooleanArray(2  * n - 1) { false }

    // 우하양 -> 빼기의 값이 같음
    // 최소: (0, M - 1) -> -(M - 1), 최대: (N - 1, 0) -> N - 1
    val rightDownCheck = BooleanArray((n - 1) + (n - 1) + 1) { false }
    var result = 0

    fun recursive(row: Int) {
        if (row == n) {
            result++
            return
        }

        for (col in 0 until n) {
            if (colCheck[col]) continue
            if (rightUpCheck[row + col]) continue
            if (rightDownCheck[row - col + n - 1]) continue

            colCheck[col] = true
            rightUpCheck[row + col] = true
            rightDownCheck[row - col + n - 1] = true

            recursive(row + 1)

            colCheck[col] = false
            rightUpCheck[row + col] = false
            rightDownCheck[row - col + n - 1] = false
        }
    }

    recursive(0)
    println(result)
}

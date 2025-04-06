fun main() {
    val (n, r, c) = readln().split(" ").map { it.toInt() }

    fun recur(n: Int, r: Int, c: Int): Int {
        if (n == 0) return 0

        val half = (1 shl (n - 1))

        // 1번째 칸일 때
        if (r < half && c < half) return recur(n-1, r, c)
        // 2번째 칸일 때
        if (r < half && c >= half) return recur(n-1, r, c - half) + (half * half)
        // 3번째 칸일 때
        if (r >= half && c < half) return recur(n-1, r - half, c) + (2 * half * half)
        // 4 번째 칸일 때
        return recur(n-1, r - half, c - half) + (3 * half * half)
    }

    println(recur(n, r, c))
}

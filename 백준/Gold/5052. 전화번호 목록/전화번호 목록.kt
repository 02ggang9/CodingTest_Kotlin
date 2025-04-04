fun main() {
    val t = readln().toInt()
    val ROOT = 1
    val MAX_VALUE = 10_000 * 11
    repeat(t) {
        val n = readln().toInt()
        var unused = 2
        var flag = false
        val trie = Array(MAX_VALUE) { IntArray(10) { -1 } }
        val check = BooleanArray(MAX_VALUE) { false }

        fun charToInt(c: Char): Int = c - '0'

        fun add(s: String): Boolean {
            var current = ROOT
            for (c in s) {
                if (check[current]) return true  // Case 1: 지금 번호가 다른 번호의 접두사
                val digit = charToInt(c)
                if (trie[current][digit] == -1) {
                    trie[current][digit] = unused++
                }
                current = trie[current][digit]
            }
            // Case 2: 이미 있는 번호가 지금 번호의 접두사
            for (i in 0 until 10) {
                if (trie[current][i] != -1) return true
            }
            check[current] = true
            return false
        }

        repeat(n) {
            val number = readln()
            if (add(number)) flag = true
        }

        if (flag) println("NO") else println("YES")
    }
}
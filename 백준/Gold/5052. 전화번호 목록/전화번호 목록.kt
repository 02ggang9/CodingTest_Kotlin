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
            s.forEach {
                if (check[current]) return true
                if (trie[current][charToInt(it)] == -1) trie[current][charToInt(it)] = unused++
                current = trie[current][charToInt(it)]
            }
            if (trie[current].any { it != -1 }) return true
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

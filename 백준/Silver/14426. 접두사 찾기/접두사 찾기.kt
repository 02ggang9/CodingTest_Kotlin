fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val ROOT = 1
    var unused = 2
    val MAX_VALUE = 10_000 * 500
    val trie = Array(MAX_VALUE) { IntArray(26) { -1 } }
    val end = BooleanArray(MAX_VALUE) { false }

    fun charToInt(c: Char): Int {
        return c - 'a'
    }

    fun add(s: String) {
        var current = ROOT
        s.forEach {
            if (trie[current][charToInt(it)] == -1) trie[current][charToInt(it)] = unused++
            current = trie[current][charToInt(it)]
        }
        end[current] = true
    }

    fun findPrefix(s: String): Boolean {
        var current = ROOT
        s.forEach {
            if (trie[current][charToInt(it)] == -1) return false
            current = trie[current][charToInt(it)]
        }
        return true
    }

    repeat(n) {
        add(readln())
    }

    var result = 0
    repeat(m) {
        if (findPrefix(readln())) result++
    }

    println(result)
}
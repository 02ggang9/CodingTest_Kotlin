fun main() {
    val n = readln().toInt()

    val ROOT = 1
    var unused = 2
    val MAX_VALUE = 100_000 * 10
    val trie = Array(MAX_VALUE) { IntArray(26) { -1 } }
    val nicknameMap = mutableMapOf<String, Int>()

    fun charToInt(c: Char): Int = c - 'a'

    fun insert(s: String) {
        var current = ROOT
        val resultBuilder = StringBuilder("")
        var isUsed = false
        s.forEach {
            resultBuilder.append(it)
            if (trie[current][charToInt(it)] == -1) {
                if (!isUsed) {
                    println(resultBuilder.toString())
                    isUsed = true
                }
                trie[current][charToInt(it)] = unused++
            }
            current = trie[current][charToInt(it)]
        }

        if (!isUsed) {
            if (nicknameMap[s] == 1) println(s) else println("$s${nicknameMap[s]!!}")
        }
    }

    repeat(n) {
        val line = readln()
        nicknameMap[line] = (nicknameMap[line] ?: 0) + 1

        insert(line)
    }
}

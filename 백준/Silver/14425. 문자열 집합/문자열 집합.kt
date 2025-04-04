const val ROOT = 1
var unused = 2
const val MAX_VALUE = 10_000 * 500 // 최대 등장 가능한 글자의 수
val check = BooleanArray(MAX_VALUE)
val next = Array(MAX_VALUE) { IntArray(26) { -1 } }

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    repeat(n) {
        insert(readln())
    }

    var result = 0
    repeat(m) {
        if (find(readln())) result++
    }
    
    println(result)
}

fun charToInt(char: Char): Int {
    return char - 'a'
}

fun insert(s: String) {
    var cur = ROOT
    s.forEach {
        if (next[cur][charToInt(it)] == -1) next[cur][charToInt(it)] = unused++
        cur = next[cur][charToInt(it)]
    }
    check[cur] = true
}

fun find(s: String): Boolean {
    var current = ROOT
    s.forEach {
        if (next[current][charToInt(it)] == -1) return false
        current = next[current][charToInt(it)]
    }
    return check[current]
}
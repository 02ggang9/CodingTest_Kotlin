var line = listOf<Int>()
var n = 0
var intArray = IntArray(n)
val resultArray = IntArray(6) { 0 }
var visited = BooleanArray(n) { false }

fun main() {

    while(true) {
        line = readln().split(" ").map { it.toInt() }
        n = line[0]
        if (n == 0) break

        intArray = IntArray(n)
        visited = BooleanArray(n) { false }
        repeat(n) {
            intArray[it] = line[it+1]
        }

        back(0, 0)
        println()
    }

}

fun back(depth: Int, startIndex: Int) {
    if (depth == 6) {
        println(resultArray.joinToString(" "))
        return
    }

    for (i in startIndex until n) {
        resultArray[depth] = intArray[i]
        back(depth + 1, i + 1)
    }
}
fun main() {
    val br = System.`in`.bufferedReader()
    println(br
        .readLine()
        .split("-")
        .map {
            it
                .split("+")
                .map { it.toInt() }
                .sum()
        }
        .reduce { acc, num -> acc - num })
}
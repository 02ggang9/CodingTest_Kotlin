fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val sortedNaturalNumbers = br
        .readLine()
        .split(" ")
        .map { it.toInt() }
        .sortedWith(compareBy({it}))

    if (n % 2 == 0) println(sortedNaturalNumbers[(n / 2) - 1]) else println(sortedNaturalNumbers[(n / 2)])
}
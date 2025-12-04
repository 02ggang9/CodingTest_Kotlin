fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val h = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine().split(" ").map { it.toInt() }

    val sortedA = a.sortedWith(compareBy({ it }))

    val result: Long = h.sumOf { it.toLong() } + sortedA.mapIndexed { index, value -> value.toLong() * index }.sum()

    println(result)
}

fun main() {
    val br = System.`in`.bufferedReader()
    var (n, m) = br.readLine().trim().split(" ").map { it.toInt() }
    val 마일리지 = IntArray(n) { 0 }

    repeat(n) {
        val (신청한사람수, 과목수강인원) = br.readLine().trim().split(" ").map { it.toInt() }
        val scores = br.readLine().trim().split(" ").map { it.toInt() }.sortedWith(compareBy({ it }))

        if (신청한사람수 - 과목수강인원 < 0) 마일리지[it] = 1 else 마일리지[it] = scores[scores.size - 과목수강인원]
    }

    val sorted = 마일리지.sortedWith(compareBy({ it }))
    var result = 0

    repeat(n) {
        if (m - sorted[it] < 0) return@repeat
        m -= sorted[it]
        result++
    }

    println(result)
}

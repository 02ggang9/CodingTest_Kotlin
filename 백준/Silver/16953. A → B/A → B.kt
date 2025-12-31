fun main() {
    val br = System.`in`.bufferedReader()
    val (a, b) = br.readLine().trim().split(" ").map { it.toInt() }
    var temp = b
    var result = 1

    while (temp > a) {
        if (temp % 10 == 1) {
            temp /= 10
        } else if (temp % 2 == 0) {
            temp /= 2
        } else {
            println(-1)
            return
        }

        result++
    }

    if (temp == a) println(result) else println(-1)
}
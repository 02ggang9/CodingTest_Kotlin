fun main() {
    val br = System.`in`.bufferedReader()
    val answer = br.readLine().trim().split(" ").map(String::toInt).toIntArray()
    val temp = IntArray(10) { 0 }
    var result = 0

    fun recursive(k: Int) {
        if (k == 10) {
            var count = 0
            for (i in 0 until 10) {
                if (answer[i] == temp[i]) count++
            }

            if (count >= 5) result++
            return
        }

        if (k >= 2) {
            for (i in 1 until 6) {
                if (temp[k - 2] == i && temp[k - 1] == i) continue
                temp[k] = i
                recursive(k + 1)
            }
        } else {
            for (i in 1 until 6) {
                temp[k] = i
                recursive(k + 1)
            }
        }
    }

    recursive(0)

    println(result)
}

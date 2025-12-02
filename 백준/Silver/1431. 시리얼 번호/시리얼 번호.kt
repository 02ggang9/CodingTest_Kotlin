fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val serials = Array(n) { Pair("", 0) }

    repeat(n) {
        val serial = br.readLine()
        var numberSum = 0
        repeat(serial.length) {
            if (serial[it].isDigit()) {
                val number = serial[it].digitToInt()
                numberSum += number
            }
        }

        serials[it] = Pair(serial, numberSum)
    }

    serials.sortWith(compareBy({ it.first.length }, { it.second }, { it.first }))

    val result = StringBuilder()

    serials.forEach { result.append(it.first).append("\n") }

    println(result.toString())
    br.close()
}

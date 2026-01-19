fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val one = StringBuilder()
    val two = StringBuilder()
    var result = 0

    fun recursive(number: StringBuilder) {
        if (number.length == n) {
            if (number.toString().toInt() % 3 == 0) result++
            return
        }

        recursive(number.append("0"))
        number.deleteAt(number.lastIndex)
        recursive(number.append("1"))
        number.deleteAt(number.lastIndex)
        recursive(number.append("2"))
        number.deleteAt(number.lastIndex)
    }

    recursive(one.append("1"))
    recursive(two.append("2"))

    println(result)
}

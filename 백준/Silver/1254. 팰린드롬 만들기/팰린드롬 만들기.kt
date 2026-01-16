fun main() {
    val br = System.`in`.bufferedReader()
    val words = br.readLine().trim()

    for (i in 0 until words.length) {
        val subWords = words.substring(i until words.length)

        if (subWords == subWords.reversed()) {
            println(i + words.length)
            break
        }
    }
}

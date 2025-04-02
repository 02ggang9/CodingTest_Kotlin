fun main() {
    val n = readln().toInt()
    var bitMask = 0
    val resultBuilder = StringBuilder()

    repeat(n) {
        val line = readln().split(" ")
        when(line[0]) {
            "add" -> bitMask = bitMask.or(1 shl (line[1].toInt() - 1))
            "remove" -> bitMask = bitMask.and((1 shl (line[1].toInt() - 1)).inv())
            "check" -> if (bitMask.and(1 shl (line[1].toInt() - 1)) > 0) resultBuilder.append(1).append("\n") else resultBuilder.append(0).append("\n")
            "toggle" -> bitMask = bitMask.xor(1 shl (line[1].toInt() - 1))
            "all" -> bitMask = 0.or((1 shl 20) - 1)
            "empty" -> bitMask = 0
        }
    }
    
    println(resultBuilder.toString())
}

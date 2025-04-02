import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    var bitMask = 0

    repeat(n) {
        val line = br.readLine().split(" ")
        when(line[0]) {
            "add" -> bitMask = bitMask.or(1 shl (line[1].toInt() - 1))
            "remove" -> bitMask = bitMask.and((1 shl (line[1].toInt() - 1)).inv())
            "check" -> if (bitMask.and(1 shl (line[1].toInt() - 1)) > 0) bw.write("1\n") else bw.write("0\n")
            "toggle" -> bitMask = bitMask.xor(1 shl (line[1].toInt() - 1))
            "all" -> bitMask = 0.or((1 shl 20) - 1)
            "empty" -> bitMask = 0
        }
    }

    bw.flush()
    bw.close()
}

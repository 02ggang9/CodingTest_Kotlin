import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val scores = IntArray(n + 1)

        repeat(n) {
            val line = StringTokenizer(br.readLine())
            val paperScore = line.nextToken().toInt()
            val interviewScore = line.nextToken().toInt()

            scores[paperScore] = interviewScore
        }

        var result = 0
        var minInterviewScore = Int.MAX_VALUE

        for (i in 1 until n + 1) {
            val interviewScore = scores[i]
            if (interviewScore < minInterviewScore) {
                minInterviewScore = interviewScore
                result++
            }
        }

        bw.write("$result\n")
    }

    bw.flush()
    bw.close()
}
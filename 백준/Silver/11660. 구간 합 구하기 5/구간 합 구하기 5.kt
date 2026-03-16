import java.io.InputStream

// 바이트 단위로 입력받아 문자열 객체 생성을 최소화하는 FastReader 클래스
class FastReader(private val inputStream: InputStream) {
    private val buffer = ByteArray(65536)
    private var pointer = 0
    private var bufferLength = 0

    fun nextInt(): Int {
        var c = read()
        while (c >= 0 && c <= 32) c = read()
        if (c == -1) return -1
        
        var neg = false
        if (c == '-'.toInt()) {
            neg = true
            c = read()
        }
        
        var res = 0
        while (c in 48..57) {
            res = res * 10 + (c - 48)
            c = read()
        }
        return if (neg) -res else res
    }

    private fun read(): Int {
        if (pointer == bufferLength) {
            bufferLength = inputStream.read(buffer)
            if (bufferLength <= 0) return -1
            pointer = 0
        }
        return buffer[pointer++].toInt() and 0xFF
    }
}

fun main() {
    val fr = FastReader(System.`in`)
    val n = fr.nextInt()
    val m = fr.nextInt()

    if (n == -1) return

    // 2차원 누적 합(Prefix Sum) 테이블
    val dp = Array(n + 1) { IntArray(n + 1) }

    for (i in 1..n) {
        for (j in 1..n) {
            val value = fr.nextInt()
            // (1,1)부터 (i,j)까지의 합 미리 계산
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + value
        }
    }

    // 결과 출력을 위한 StringBuilder (초기 용량을 넉넉하게 설정)
    val sb = StringBuilder(m * 10)
    repeat(m) {
        val x1 = fr.nextInt()
        val y1 = fr.nextInt()
        val x2 = fr.nextInt()
        val y2 = fr.nextInt()

        // 구간 합 공식 적용: O(1)
        val result = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1]
        sb.append(result).append("\n")
    }
    
    // 최종 결과 한 번에 출력
    print(sb)
}
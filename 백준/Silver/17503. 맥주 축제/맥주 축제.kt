import java.util.*
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    if (!st.hasMoreTokens()) return

    val n = st.nextToken().toInt()
    val m = st.nextToken().toLong()
    val k = st.nextToken().toInt()

    val beers = Array(k) { LongArray(2) }

    for (i in 0 until k) {
        st = StringTokenizer(br.readLine())
        beers[i][0] = st.nextToken().toLong() // 선호도
        beers[i][1] = st.nextToken().toLong() // 도수
    }

    // 1. 도수 기준 오름차순 정렬
    beers.sortBy { it[1] }

    val pQueue = PriorityQueue<Long>()
    var currentPreferenceSum = 0L

    for (beer in beers) {
        val p = beer[0]
        val c = beer[1]

        pQueue.add(p)
        currentPreferenceSum += p

        if (pQueue.size > n) {
            currentPreferenceSum -= pQueue.poll()
        }

        if (pQueue.size == n && currentPreferenceSum >= m) {
            println(c)
            return
        }
    }

    println(-1)
}

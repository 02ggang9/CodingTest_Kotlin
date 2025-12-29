  import java.util.*

  fun main() {
      val br = System.`in`.bufferedReader()
      val n = br.readLine().toInt()
      val counts = IntArray(20_000_001)
      val line = StringTokenizer(br.readLine())

      repeat(n) {
          counts[line.nextToken().toInt() + 10_000_000]++
      }

      val m = br.readLine().toInt()
      val line2 = StringTokenizer(br.readLine())

      val sb = StringBuilder()
      repeat(m) {
          sb.append(counts[line2.nextToken().toInt() + 10_000_000]).append(' ')
      }

      print(sb)
  }
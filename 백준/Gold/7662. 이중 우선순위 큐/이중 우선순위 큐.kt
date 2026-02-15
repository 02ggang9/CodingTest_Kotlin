import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()

    repeat(t) {
        val k = br.readLine().toInt()
        val map = TreeMap<Int, Int>()

        for (i in 0 until k) {
            val (first, second) = br.readLine().split(" ")
            val command = first
            val number = second.toInt()

            when(command) {
                "I" -> {
                    map[number] = map.getOrDefault(number, 0) + 1
                }

                "D" -> {
                    if (map.isEmpty()) continue

                    if (number == -1) {
                        val firstEntry = map.firstEntry()
                        if (firstEntry.value > 1) map[firstEntry.key] = firstEntry.value - 1 else map.pollFirstEntry()
                    } else {
                        val lastEntry = map.lastEntry()
                        if (lastEntry.value > 1) map[lastEntry.key] = lastEntry.value - 1 else map.pollLastEntry()
                    }
                }
            }
        }

        if (map.isEmpty()) {
            println("EMPTY")
        } else {
            println("${map.lastEntry().key} ${map.firstEntry().key}")
        }
    }
}

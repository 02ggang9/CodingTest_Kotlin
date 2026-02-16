import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()

    for (i in 0 until t) {
        val (first, second) = br.readLine().split(" ").map(String::toInt)
        val queue: Queue<Pair<Int, String>> = LinkedList()
        val visited = mutableSetOf<Int>()

        queue.add(Pair(first, ""))
        visited.add(first)

        while (queue.isNotEmpty()) {
            val (currentNumber, currentCommand) = queue.poll()
            if (currentNumber == second) {
                println(currentCommand)
                break
            }

            // D
            val dNumber = (currentNumber * 2) % 10000
            if (!visited.contains(dNumber)) {
                queue.add(Pair(dNumber, currentCommand.plus("D")))
                visited.add(dNumber)
            }

            // S
            val sNumber = if (currentNumber == 0) 9999 else currentNumber - 1
            if (!visited.contains(sNumber)) {
                queue.add(Pair(sNumber, currentCommand.plus("S")))
                visited.add(sNumber)
            }

            // L
            val lNumber = (currentNumber % 1000) * 10 + (currentNumber / 1000)
            if (!visited.contains(lNumber)) {
                queue.add(Pair(lNumber, currentCommand.plus("L")))
                visited.add(lNumber)
            }

            // R
            val rNumber = ((currentNumber % 10) * 1000) + (currentNumber / 10)
            if (!visited.contains(rNumber)) {
                queue.add(Pair(rNumber, currentCommand.plus("R")))
                visited.add(rNumber)
            }
        }
    }
}

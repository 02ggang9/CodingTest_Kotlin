fun main() {
    System.`in`.bufferedReader().use {
        val n = it.readLine().toInt()
        val scores = it.readLine().split(" ").map { it.toInt() }.toHashSet()
        val sum = it.readLine().toInt()
        var result = 0

        scores.forEach {
            val currentNumber = it
            val findNumber = sum - currentNumber

            if (findNumber in scores) result++
        }

        println(result / 2)
    }
}

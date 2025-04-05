fun main() {
    val n = readln().toInt()
    val eggs = Array(n) { IntArray(2) }

    repeat(n) {
        val (durability, weight) = readln().split(" ").map { it.toInt() }
        eggs[it][0] = durability
        eggs[it][1] = weight
    }

    val brokenEgg = BooleanArray(n) { false }
    var maxCount = -1

    fun back(currentIndex: Int) {
        if (currentIndex == n) {
            val brokenEggCount = brokenEgg.count { it }
            if (brokenEggCount > maxCount) maxCount = brokenEggCount
            return
        }

        if (brokenEgg[currentIndex]) {
            back(currentIndex+1)
            return
        }

        var doneHit = false
        for (i in 0 until n) {
            if (brokenEgg[i] || (i == currentIndex)) continue
            doneHit = true
            val beforeHoldingEggDurability = eggs[currentIndex][0]
            val beforeTargetEggDurability = eggs[i][0]

            eggs[currentIndex][0] = eggs[currentIndex][0] - eggs[i][1]
            eggs[i][0] = eggs[i][0] - eggs[currentIndex][1]

            if (eggs[currentIndex][0] <= 0) brokenEgg[currentIndex] = true
            if (eggs[i][0] <= 0) brokenEgg[i] = true

            back(currentIndex+1)

            eggs[currentIndex][0] = beforeHoldingEggDurability
            eggs[i][0] = beforeTargetEggDurability

            if (beforeHoldingEggDurability > 0) brokenEgg[currentIndex] = false
            if (beforeTargetEggDurability > 0) brokenEgg[i] = false
        }

        if (!doneHit) back(currentIndex + 1)
    }

    back(0)
    println(maxCount)
}
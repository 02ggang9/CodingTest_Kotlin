fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val gList= LongArray(n)

    repeat(n) {
        val yOrN = readln().takeLast(m)
        var bitMask = 0L

        for (index in 0 until m) {
            if (yOrN[index] == 'N') continue
            bitMask = bitMask or (1L shl index)
        }

        gList[it] = bitMask
    }

    var isFail = 0L
    gList.forEach { isFail = isFail or it }
    if (isFail == 0L) {
        println(-1)
        return
    }

    val bitMask = (1 shl n) - 1
    var subset = bitMask
    var minGCount = Int.MAX_VALUE
    var maxMCount = 0

    while (subset > 0) {
        var result = 0L
        var gCount = 0
        var mCount = 0
        for (i in 0 until n) {
            if (subset and (1 shl i) == 0) continue
            gCount++
            result = result or gList[i]
        }

        mCount = java.lang.Long.bitCount(result)

        if (mCount > maxMCount) {
            maxMCount = mCount
            minGCount = gCount
        } else if (mCount == maxMCount) {
            if (gCount < minGCount) {
                minGCount = gCount
            }
        }

        subset = bitMask and (subset - 1)
    }
    println(minGCount)
}
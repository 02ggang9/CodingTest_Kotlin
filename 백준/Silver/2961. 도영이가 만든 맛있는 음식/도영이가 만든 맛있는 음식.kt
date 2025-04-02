import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val s = IntArray(n)
    val b = IntArray(n)

    repeat(n) {
        val (sMount, bMount) = readln().split(" ").map { it.toInt() }
        s[it] = sMount
        b[it] = bMount
    }

    var bitMask = 0 or ((1 shl n) - 1)
    var subset = bitMask
    var diff = Int.MAX_VALUE

    while (subset > 0) {
        var sMul = 1
        var bSum = 0
        for (i in 0 until n) {
            if (subset and (1 shl i) == 0) continue
            sMul *= s[i]
            bSum += b[i]
        }
        if (abs(sMul - bSum) < diff) diff = abs(sMul - bSum)
        subset = bitMask and (subset - 1)
    }

    println(diff)
}

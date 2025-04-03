fun main() {
    val n = readln().toInt()
    val ips = IntArray(n)

    repeat(n) {
        val (a, b, c, d) = readln().split(".").map { it.toInt() }
        ips[it] = (a shl 24) or (b shl 16) or (c shl 8) or d
    }

    val minIp = ips.minOrNull()!!
    val maxIp = ips.maxOrNull()!!

    val diff = minIp xor maxIp

    val leading = diff.countLeadingZeroBits()
    val hostBits = 32 - leading  // 뒤쪽 호스트 비트 수

    val networkMask = if (hostBits == 32) {
        0
    } else {
        ((1 shl hostBits) - 1).inv()
    }

    val networkAddress = minIp and networkMask

    fun intToIpString(ip: Int): String {
        return "${(ip ushr 24) and 0xFF}." +
                "${(ip ushr 16) and 0xFF}." +
                "${(ip ushr 8) and 0xFF}." +
                "${ip and 0xFF}"
    }

    println(intToIpString(networkAddress))
    println(intToIpString(networkMask))
}
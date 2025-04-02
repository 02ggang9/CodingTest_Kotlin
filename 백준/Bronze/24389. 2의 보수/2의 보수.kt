fun main() {
    val n = readln().toInt()
    println(Integer.bitCount(n xor -n))
}

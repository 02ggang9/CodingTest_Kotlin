fun main() {
    val br = System.`in`.bufferedReader()
    val (s, p) = br.readLine().trim().split(" ").map { it.toInt() }
    val words = br.readLine()
    val (minA, minC, minG, minT) = br.readLine().split(" ").map { it.toInt() }
    val countMap = HashMap<Char, Int>()

    countMap['A'] = 0
    countMap['C'] = 0
    countMap['G'] = 0
    countMap['T'] = 0

    var result = 0
    var leftPoint = 0
    var rightPoint = p - 1
    var temp = true

    while (rightPoint < s) {
        if (temp) {
            for (i in 0 until rightPoint + 1) {
                if (words[i] == 'A') countMap['A'] = countMap['A']!! + 1
                if (words[i] == 'C') countMap['C'] = countMap['C']!! + 1
                if (words[i] == 'G') countMap['G'] = countMap['G']!! + 1
                if (words[i] == 'T') countMap['T'] = countMap['T']!! + 1
            }
            temp = false
        }
        if (countMap['A']!! >= minA && countMap['C']!! >= minC && countMap['G']!! >= minG && countMap['T']!! >= minT) result++

        if (rightPoint + 1 >= s) break

        countMap[words[leftPoint]] = countMap[words[leftPoint]]!! - 1
        countMap[words[rightPoint+1]] = countMap[words[rightPoint+1]]!! + 1

        leftPoint++
        rightPoint++
    }

    println(result)
}

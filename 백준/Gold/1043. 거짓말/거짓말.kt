fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map(String::toInt)
    val unionFind = IntArray(n + 1) { it }

    fun find(x: Int): Int {
        if (unionFind[x] == x) return x

        unionFind[x] = find(unionFind[x])
        return unionFind[x]
    }

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)

        if (rootX != rootY) {
            if (rootX < rootY) {
                unionFind[rootY] = rootX
            } else {
                unionFind[rootX] = rootY
            }
        }
    }

    val secondLine = br.readLine().split(" ").map(String::toInt)
    val truthCount = secondLine[0]

    if (truthCount == 0) {
        println(m)
        return
    }

    for (i in 2 until secondLine.size) {
        union(secondLine[1], secondLine[i])
    }

    val parties = mutableListOf<List<Int>>()

    for (i in 0 until m) {
        val line = br.readLine().split(" ").map(String::toInt)
        val group = mutableListOf<Int>()
        for (j in 1 until line.size) {
            group.add(line[j])
        }

        parties.add(group)

        for (j in 2 until line.size) {
            union(line[1], line[j])
        }
    }

    var result = 0
    val truthRoot = find(secondLine[1])

    for (party in parties) {
        if (find(party[0]) != truthRoot) {
            result++
        }
    }

    println(result)

}

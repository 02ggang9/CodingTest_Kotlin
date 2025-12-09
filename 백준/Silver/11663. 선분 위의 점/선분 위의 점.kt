fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().trim().split(" ").map(String::toInt)
    val points = br.readLine().trim().split(" ").map(String::toInt).sortedWith(compareBy({ it }))
    val result = StringBuilder()

    repeat(m) {
        val (x1, x2) = br.readLine().trim().split(" ").map(String::toInt)
        val pointX1Index = points.binarySearch(x1)
        val pointX2Index = points.binarySearch(x2)

        val pointX1 = if (pointX1Index < 0) pointX1Index.inv() else pointX1Index
        val pointX2 = if (pointX2Index < 0) pointX2Index.inv() - 1 else pointX2Index

        result.append(pointX2 - pointX1 + 1).append("\n")
    }

    println(result.toString())
}
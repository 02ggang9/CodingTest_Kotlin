fun main() {
    val n = readln().toInt()
    if (n > 0 && n % 2 != 1) throw IllegalArgumentException("홀수를 입력하시오.")

    // default value는 뭘까?
    val numbers = IntArray(n)

    repeat(n) {
        val number = readln().toInt()
        numbers[it] = number
    }

    // 1. 산술 평균
    var sum = 0.0
    for (i in numbers) {
        sum += i
    }
    val mean = sum / n
    println("%.0f".format(mean).toInt())

    // 2. 중앙값
    println(numbers.sortedArray()[n / 2])

    // 3. 최빈값
    val countMap = LinkedHashMap<Int, Int>()
    numbers.forEach {
        if (countMap[it] == null) countMap[it] = 0
        countMap[it] = countMap[it]!! + 1
    }

    var maxValue = -1
    countMap.forEach { (key, value) ->
        if (value > maxValue) maxValue = value
    }

    var maxCount = 0
    countMap.forEach { (_, value) ->
        if (value == maxValue) maxCount++
    }

    val list = arrayListOf<Int>()
    if (maxCount == 1) {
        countMap.forEach {
            if (it.value == maxValue) println(it.key)
        }
    } else {
        countMap.forEach {
            if (it.value == maxValue) list.add(it.key)
        }

        list.sort()
        println(list[1])
    }

    // 4. 범위
    println(numbers.sortedArray()[n-1] - numbers.sortedArray()[0])
}

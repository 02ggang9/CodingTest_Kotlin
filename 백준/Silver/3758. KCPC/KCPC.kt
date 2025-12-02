fun main() {
    System.`in`.bufferedReader().use { br ->
        val testCount = br.readLine().toInt()

        repeat(testCount) {
            val (teamCount, problemCount, myTeamId, logCount) = br.readLine().split(" ").map { it.toInt() }
            val loggers = Array<Logger>(teamCount + 1) { Logger(id = it) }

            repeat(logCount) { count ->
                val (teamId, problemId, getScore) = br.readLine().split(" ").map { it.toInt() }

                loggers[teamId].apply {
                    scores[problemId] = maxOf(scores[problemId] ?: 0, getScore)
                    submissionCount += 1
                    lastSubmissionCount = count
                }
            }

            loggers
                .sortedWith(compareBy({ -it.getTotalScore() }, { it.submissionCount }, { it.lastSubmissionCount }))
                .forEachIndexed { index, logger ->
                    if (logger.id == myTeamId) println(index + 1)
                }
        }
    }
}

data class Logger(
    val id: Int,
    val scores: MutableMap<Int, Int> = mutableMapOf(),
    var submissionCount: Int = 0,
    var lastSubmissionCount: Int = 0,
) {
    fun getTotalScore() = this.scores.values.sum()
}

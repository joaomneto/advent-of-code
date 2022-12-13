package joaomneto

object Day10 {

    fun run() {
        Runner.printResults(
            solutionPart1(this::class.java.getResourceAsStream("/day10.input")!!.bufferedReader().lineSequence()),
            "\n" + solutionPart2(this::class.java.getResourceAsStream("/day10.input")!!.bufferedReader().lineSequence())
        )
    }

    private val CRT_GRID = (1..6).map {
        (1..40).map { "." }
    }

    fun List<List<String>>.toCRTString() = this.joinToString("\n") { it.joinToString("") }

    fun solutionPart2(input: Sequence<String>) =
        input.fold(emptySequence<String>()) { acc, s ->
            when (s) {
                "noop" -> acc.plus(s)
                else -> acc.plus("addnoop").plus(s)
            }
        }.foldIndexed(1 to CRT_GRID) { index, acc, command ->

            // println("Cycle ${index + 1} started - $command")

            val currentX = acc.first
            val targetCol = index % 40
            val targetRow = index / 40

            // println("Coordinates being written: $targetCol,$targetRow")

            val char = if (targetCol >= currentX - 1 && targetCol <= currentX + 1) {
                "#"
            } else
                " "

            val crt =
                acc.second.mapIndexed { yy, dots -> if (yy == targetRow) dots.mapIndexed { xx, dot -> if (xx == targetCol) char else dot } else dots }

            val newX =
                if (command.startsWith("addx")) {
                    acc.first + command.split(" ").last().toInt()
                } else {
                    acc.first
                }

            // println("Cycle ${index + 1} finished - $command: \n${crt.toCRTString()}")
            newX to crt
        }.second.toCRTString()

    fun solutionPart1(input: Sequence<String>) =
        input.fold(emptySequence<String>()) { acc, s ->
            when (s) {
                "noop" -> acc.plus(s)
                else -> acc.plus("addnoop").plus(s)
            }
        }.foldIndexed(1 to 0) { index, acc, command ->

            // println("Cycle ${index + 1} - $command: ${acc.first}")
            val sum = if (setOf(20, 60, 100, 140, 180, 220).contains(index + 1)) {
                acc.second + ((index + 1) * acc.first)
            } else {
                acc.second
            }

            val x =
                if (command.startsWith("addx")) {
                    acc.first + command.split(" ").last().toInt()
                } else {
                    acc.first
                }

            x to sum
        }.second
}

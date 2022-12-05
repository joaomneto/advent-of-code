package joaomneto

import java.io.InputStream

object Day5 {
    fun run() {
        val inputPart1 = parseFilePart1(this::class.java.getResourceAsStream("/day5.input")!!)
        Runner.printResults(
            solutionPart1(inputPart1.first, inputPart1.second),
            solutionPart2(inputPart1.first, inputPart1.second)
        )
    }

    private val MOVE_REGEX = """move (\d+) from (\d+) to (\d+)""".toRegex()

    fun parseFilePart1(inputStream: InputStream) = with(inputStream.bufferedReader()) {
        var line: String? = null
        val stacksRaw = mutableListOf<String>()
        val moves = mutableListOf<List<Int>>()
        var movesListBegun = false
        while (true) {
            line = readLine()

            when {
                line == null -> break
                line.isBlank() -> movesListBegun = true
                !movesListBegun -> stacksRaw.add(line)
                else -> {
                    val values = MOVE_REGEX.find(line)!!.destructured.toList().map(String::toInt)
                    moves.add(values)
                }
            }
        }
        val numberStacks = stacksRaw.last().trim().split("""\s+""".toRegex()).last().toInt()

        val stacks = (1..numberStacks).map { ArrayDeque<String>() }

        stacksRaw.dropLast(1).reversed().forEach { line ->
            (1..numberStacks).forEach { id ->
                val crate = try {
                    (1 + 4 * (id - 1)).let { line.substring(it..it) }
                } catch (e: StringIndexOutOfBoundsException) {
                    ""
                }
                if (crate.isNotBlank()) stacks[id - 1].add(crate)
            }
        }

        stacks to moves
    }

    fun solutionPart1(stacks: List<ArrayDeque<String>>, moves: List<List<Int>>): String {
        val stacksCopy = stacks.map { ArrayDeque(it.toList()) }
        moves.forEach { move ->
            for (i in 1..move[0]) {
                stacksCopy[move[2] - 1].addLast(stacksCopy[move[1] - 1].removeLast())
            }
        }


        return stacksCopy.joinToString("") { it.last() }
    }

    fun solutionPart2(stacks: List<ArrayDeque<String>>, moves: List<List<Int>>): String {
        val stacksCopy = stacks.map { ArrayDeque(it.toList()) }
        moves.forEach { move ->
            stacksCopy[move[2] - 1].addAll(
                (1..move[0]).map {
                        stacksCopy[move[1] - 1].removeLast()
                }.reversed()
            )
        }


        return stacksCopy.joinToString("") { it.last() }
    }
}

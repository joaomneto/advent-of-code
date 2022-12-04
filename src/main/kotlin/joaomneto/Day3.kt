package joaomneto

import java.io.InputStream
import kotlin.streams.asSequence

object Day3 {

    private fun Char.toPriority() = when{
        this.isUpperCase() ->  code - 'A'.code + 27
        this.isLowerCase() ->  code - 'a'.code + 1
        else -> throw IllegalArgumentException()
    }

    fun run() {
        val inputPart1 = parseFilePart1(this::class.java.getResourceAsStream("/day3.input")!!)
        println("Solution for day 3 (part 1): ${solutionPart1(inputPart1)}")
        val inputPart2 = parseFilePart2(this::class.java.getResourceAsStream("/day3.input")!!)
        println("Solution for day 3 (part 2): ${solutionPart2(inputPart2)}")
    }

    fun parseFilePart1(inputStream: InputStream) =
        inputStream.bufferedReader().lines().map {
            with(it) {
                slice(0 until length / 2) to slice(length / 2 until length)
            }
        }.asSequence()

    fun parseFilePart2(inputStream: InputStream) =
        inputStream.bufferedReader().lines().asSequence().chunked(3)

    fun solutionPart1(input: Sequence<Pair<String, String>>) = input.fold(0) { acc, pair ->
        acc + pair.first.toSet().intersect(pair.second.toSet()).first().toPriority()
    }

    fun solutionPart2(input: Sequence<List<String>>) = input.fold(0) { acc, list ->
        acc +  list[0].toSet().intersect(list[1].toSet().intersect(list[2].toSet())).first().toPriority()
    }
}

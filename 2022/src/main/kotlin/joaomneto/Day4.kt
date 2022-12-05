package joaomneto

import java.io.InputStream
import kotlin.streams.asSequence

object Day4 {
    fun run() {
        val inputPart1 = parseFilePart1(this::class.java.getResourceAsStream("/day4.input")!!)
        val inputPart2 = parseFilePart1(this::class.java.getResourceAsStream("/day4.input")!!)
        Runner.printResults(solutionPart1(inputPart1), solutionPart2(inputPart2))
    }

    fun parseFilePart1(inputStream: InputStream) =
        inputStream.bufferedReader().lines().map {
            with(it.split(",")) {
                val firstSectionIds = first().split("-")
                val secondSectionIds = last().split("-")

                firstSectionIds.first().toInt().rangeTo(firstSectionIds.last().toInt()) to secondSectionIds.first()
                    .toInt().rangeTo(secondSectionIds.last().toInt())
            }
        }.asSequence()

    fun solutionPart1(input: Sequence<Pair<IntRange, IntRange>>) = input.fold(0) { acc, pair ->
        if (pair.first.first() <= pair.second.first() && pair.first.last() >= pair.second.last() ||
            pair.second.first() <= pair.first.first() && pair.second.last() >= pair.first.last()
        ) {
            acc + 1
        } else {
            acc
        }
    }

    fun solutionPart2(input: Sequence<Pair<IntRange, IntRange>>) = input.fold(0) { acc, pair ->
        if (pair.first.contains(pair.second.first)
            || pair.first.contains(pair.second.last)
            || pair.second.contains(pair.first.first)
            || pair.second.contains(pair.first.last)) {
                acc + 1
            } else {
            acc
        }
    }
}

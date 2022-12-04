package joaomneto

import joaomneto.Day2.Outcome.*
import joaomneto.Day2.Shape.Companion.fromMyPlay
import joaomneto.Day2.Shape.Companion.fromOpponentPlay
import java.io.InputStream
import kotlin.streams.asSequence

object Day2 {
    enum class Outcome(val id: String) {
        VICTORY("Z"),
        DRAW("Y"),
        LOSS("X");

        companion object {
            fun fromId(code: String) = values().first { it.id == code }
        }
    }

    enum class Shape(
        val opponentId: String,
        val myId: String,
        val baseScore: Int,
        private val winsToRaw: String,
        private val losesToRaw: String
    ) {
        ROCK("A", "X", 1, "SCISSOR", "PAPER"),
        PAPER("B", "Y", 2, "ROCK", "SCISSOR"),
        SCISSOR("C", "Z", 3, "PAPER", "ROCK");

        val winsTo: Shape
            get() = Shape.valueOf(this.winsToRaw)

        val losesTo: Shape
            get() = Shape.valueOf(this.losesToRaw)

        companion object {
            fun fromOpponentPlay(play: String) = values().first { it.opponentId == play }
            fun fromMyPlay(play: String) = values().first { it.myId == play }
        }

        fun outcomeScore(myPlay: Shape) = when {
            this.losesTo == myPlay -> 6
            this == myPlay -> 3
            else -> 0
        }
    }

    fun run() {
        val inputPart1 = parseFilePart1(this::class.java.getResourceAsStream("/day2.input")!!)
        println("Solution for day 2 (part 1): ${solutionPart1(inputPart1)}")
        val inputPart2 = parseFilePart2(this::class.java.getResourceAsStream("/day2.input")!!)
        println("Solution for day 2 (part 2): ${solutionPart2(inputPart2)}")
    }

    fun parseFilePart1(inputStream: InputStream) =
        inputStream.bufferedReader().lines().map {
            with(it.trim().split(" ")) {
                fromOpponentPlay(first()) to fromMyPlay(last())
            }
        }.asSequence()

    fun parseFilePart2(inputStream: InputStream) =
        inputStream.bufferedReader().lines().map {
            with(it.trim().split(" ")) {
                fromOpponentPlay(first()) to Outcome.fromId(last())
            }
        }.asSequence()

    fun solutionPart1(input: Sequence<Pair<Shape, Shape>>) = input.fold(0) { acc, pair ->
        acc + pair.second.baseScore + pair.first.outcomeScore(pair.second)
    }

    fun solutionPart2(input: Sequence<Pair<Shape, Outcome>>) = input.fold(0) { acc, pair ->
        val bestPlay = when(pair.second){
            VICTORY -> pair.first.losesTo
            LOSS -> pair.first.winsTo
            DRAW -> pair.first
        }
        acc + bestPlay.baseScore + pair.first.outcomeScore(bestPlay)
    }
}

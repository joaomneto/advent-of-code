package joaomneto

import joaomneto.Day2.Outcome
import joaomneto.Day2.Outcome.*
import joaomneto.Day2.Shape.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

object Day2Test {

    @Test
    fun `solutionPart1 works as intended`() {
        val input =
            sequenceOf(ROCK to PAPER, PAPER to ROCK, ROCK to SCISSOR, SCISSOR to SCISSOR)

        assertEquals(18, Day2.solutionPart1(input))
    }

    @Test
    fun `solutionPart2 works as intended`() {
        val input =
            sequenceOf(ROCK to DRAW, PAPER to LOSS, SCISSOR to VICTORY)

        assertEquals(12, Day2.solutionPart2(input))
    }

    @Test
    fun `parseFilePart1 works as intended`() {
        val inputString = """A Y
            B X
            C Z""".trimIndent()

        val input = ByteArrayInputStream(inputString.toByteArray())

        val expected =
            listOf(ROCK to PAPER, PAPER to ROCK, SCISSOR to SCISSOR)

        assertEquals(expected, Day2.parseFilePart1(input).toList())
    }

    @Test
    fun `parseFilePart2 works as intended`() {
        val inputString = """A Y
            B X
            C Z""".trimIndent()

        val input = ByteArrayInputStream(inputString.toByteArray())

        val expected =
            listOf(ROCK to DRAW, PAPER to LOSS, SCISSOR to VICTORY)

        assertEquals(expected, Day2.parseFilePart2(input).toList())
    }

}



package joaomneto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

object Day4Test {

    @Test
    fun `solutionPart1 works as intended`() {
        val input =
            sequenceOf(
                2..4 to 6..8,
                2..3 to 4..5,
                5..7 to 7..9,
                2..8 to 3..7,
                6..6 to 4..6,
                2..6 to 4..8
            )

        assertEquals(2, Day4.solutionPart1(input))
    }

    @Test
    fun `solutionPart2 works as intended`() {
        val input =
            sequenceOf(
                2..4 to 6..8,
                2..3 to 4..5,
                5..7 to 7..9,
                2..8 to 3..7,
                6..6 to 4..6,
                2..6 to 4..8
            )

        assertEquals(4, Day4.solutionPart2(input))
    }

    @Test
    fun `parseFilePart1 works as intended`() {
        val inputString ="""
            2-4,6-8
            2-3,4-5
            5-7,7-9
            2-8,3-7
            6-6,4-6
            2-6,4-8
        """.trimIndent()

        val input = ByteArrayInputStream(inputString.toByteArray())

        val expected =
        listOf(
            2..4 to 6..8,
            2..3 to 4..5,
            5..7 to 7..9,
            2..8 to 3..7,
            6..6 to 4..6,
            2..6 to 4..8
        )

        assertEquals(expected, Day4.parseFilePart1(input).toList())
    }
}



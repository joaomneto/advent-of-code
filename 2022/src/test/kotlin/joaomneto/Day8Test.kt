package joaomneto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

object Day8Test {

    private val inputString = """
        30373
        25512
        65332
        33549
        35390""".trimIndent()

    @Test
    fun `parseFilePart1 works as intended`() {
        val input = ByteArrayInputStream(inputString.toByteArray())
        val expected: List<List<Int>> = listOf(
            listOf(3, 0, 3, 7, 3),
            listOf(2, 5, 5, 1, 2),
            listOf(6, 5, 3, 3, 2),
            listOf(3, 3, 5, 4, 9),
            listOf(3, 5, 3, 9, 0)
        )
        assertEquals(expected, Day8.parseFilePart1(input))
    }

    @Test
    fun `solutionPart1 works as intended`() {
        val input = ByteArrayInputStream(inputString.toByteArray())
        assertEquals(21, Day8.solutionPart1(Day8.parseFilePart1(input)))
    }

    @Test
    fun `solutionPart2 works as intended`() {
        val input = ByteArrayInputStream(inputString.toByteArray())
        assertEquals(8, Day8.solutionPart2(Day8.parseFilePart1(input)))
    }

}



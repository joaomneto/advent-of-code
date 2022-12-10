package joaomneto

import joaomneto.Day9.Point
import joaomneto.Day9.moveTail
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

object Day9Test {

    private val inputString = """
        R 4
        U 4
        L 3
        D 1
        R 4
        D 1
        L 5
        R 2""".trimIndent()

    private val inputString2 = """
        R 5
        U 8
        L 8
        D 3
        R 17
        D 10
        L 25
        U 20
    """.trimIndent()

    @Test
    fun `solutionPart1 works as intended`() {
        val input = ByteArrayInputStream(inputString.toByteArray())
        assertEquals(13, Day9.solutionPart1(input.bufferedReader().lineSequence()))
    }

    @Test
    fun `solutionPart2 works as intended`() {
        // val input = ByteArrayInputStream(inputString.toByteArray())
        // assertEquals(1, Day9.solutionPart2(input.bufferedReader().lineSequence()))
        val input2 = ByteArrayInputStream(inputString2.toByteArray())
        assertEquals(36, Day9.solutionPart2(input2.bufferedReader().lineSequence()))
    }

    @Test
    fun `moveTail works as intended`() {
        assertEquals(Point(0, 0), moveTail(Point(0, 0), Point(0, 0)))
        assertEquals(Point(0, 0), moveTail(Point(0, 0), Point(1, 0)))
        assertEquals(Point(1, 0), moveTail(Point(0, 0), Point(2, 0)))
        assertEquals(Point(2, 0), moveTail(Point(1, 0), Point(3, 0)))
        assertEquals(Point(4, 1), moveTail(Point(3, 0), Point(4, 2)))
        assertEquals(Point(4, 2), moveTail(Point(4, 1), Point(4, 3)))
        assertEquals(Point(4, 3), moveTail(Point(4, 2), Point(4, 4)))
        assertEquals(Point(4, 3), moveTail(Point(4, 3), Point(3, 4)))
        assertEquals(Point(3, 4), moveTail(Point(4, 3), Point(2, 4)))
    }
}



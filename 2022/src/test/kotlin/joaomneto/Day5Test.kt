package joaomneto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

object Day5Test {

    @Test
    fun `solutionPart1 works as intended`() {
        val stacks = listOf(
            ArrayDeque(listOf("Z", "N")),
            ArrayDeque(listOf("M", "C", "D")),
            ArrayDeque(listOf("P"))
        )
        val moves = listOf(
            listOf(1, 2, 1),
            listOf(3, 1, 3),
            listOf(2, 2, 1),
            listOf(1, 1, 2),
        )

        assertEquals("CMZ", Day5.solutionPart1(stacks, moves))
    }

    @Test
    fun `solutionPart2 works as intended`() {
        val stacks = listOf(
            ArrayDeque(listOf("Z", "N")),
            ArrayDeque(listOf("M", "C", "D")),
            ArrayDeque(listOf("P"))
        )
        val moves = listOf(
            listOf(1, 2, 1),
            listOf(3, 1, 3),
            listOf(2, 2, 1),
            listOf(1, 1, 2),
        )

        assertEquals("MCD", Day5.solutionPart2(stacks, moves))
    }
}



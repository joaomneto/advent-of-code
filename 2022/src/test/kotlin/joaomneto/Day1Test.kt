package joaomneto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

object Day1Test {

    @Test
    fun `solutionPart1 works as intended`() {
        val input =
            listOf(listOf(1000, 2000, 3000), listOf(4000), listOf(5000, 6000), listOf(7000, 8000, 9000), listOf(10000))

        assertEquals(24000, Day1.solutionPart1(input))
    }

    @Test
    fun `parseFile works as intended`() {
        val inputString = """
            1000
            2000
            3000
            
            4000
            
            5000
            6000
            
            7000
            8000
            9000
            
            10000
        """.trimIndent()

        val input = ByteArrayInputStream(inputString.toByteArray())

        val expected =
            listOf(listOf(1000, 2000, 3000), listOf(4000), listOf(5000, 6000), listOf(7000, 8000, 9000), listOf(10000))

        assertEquals(expected, Day1.parseFilePart1(input))
    }


    @Test
    fun `solutionPart2 works as intended`() {
        val input =
            listOf(listOf(1000, 2000, 3000), listOf(4000), listOf(5000, 6000), listOf(7000, 8000, 9000), listOf(10000))

        assertEquals(45000, Day1.solutionPart2(input))
    }
}



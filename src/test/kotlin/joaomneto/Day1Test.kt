package joaomneto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class Day1Test {

    @Test
    fun `solutionMax returns max calories for list of calories`() {
        val input =
            listOf(listOf(1000, 2000, 3000), listOf(4000), listOf(5000, 6000), listOf(7000, 8000, 9000), listOf(10000))

        assertEquals(24000, Day1().solutionMax(input))
    }

    @Test
    fun `parseFile converts an inputstream into a list of list of ints`() {
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

        assertEquals(expected, Day1().parseFile(input))
    }


    @Test
    fun `solutionTop3 returns max calories for list of calories`() {
        val input =
            listOf(listOf(1000, 2000, 3000), listOf(4000), listOf(5000, 6000), listOf(7000, 8000, 9000), listOf(10000))

        assertEquals(45000, Day2().solutionTop3(input))
    }
}



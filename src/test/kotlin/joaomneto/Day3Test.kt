package joaomneto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

object Day3Test {

    @Test
    fun `solutionPart1 works as intended`() {
        val input =
            sequenceOf(
                "vJrwpWtwJgWr" to "hcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGL" to "rsFMfFZSrLrFZsSL",
                "PmmdzqPrV" to "vPwwTWBwg",
                "wMqvLMZHhHMvwLH" to "jbvcjnnSBnvTQFn",
                "ttgJtRGJ" to "QctTZtZT",
                "CrZsJsPPZsGz" to "wwsLwLmpwMDw"

            )

        assertEquals(157, Day3.solutionPart1(input))
    }

    @Test
    fun `solutionPart2 works as intended`() {
        val input =
            sequenceOf(
                listOf(
                    "vJrwpWtwJgWrhcsFMMfFFhFp",
                    "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                    "PmmdzqPrVvPwwTWBwg"
                ), listOf(
                    "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                    "ttgJtRGJQctTZtZT",
                    "CrZsJsPPZsGzwwsLwLmpwMDw"
                )
            )

        assertEquals(70, Day3.solutionPart2(input))
    }

    @Test
    fun `parseFilePart1 works as intended`() {
        val inputString =
            "vJrwpWtwJgWrhcsFMMfFFhFp\n" +
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" +
                "PmmdzqPrVvPwwTWBwg\n" +
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" +
                "ttgJtRGJQctTZtZT\n" +
                "CrZsJsPPZsGzwwsLwLmpwMDw"

        val input = ByteArrayInputStream(inputString.toByteArray())

        val expected =
            listOf(
                "vJrwpWtwJgWr" to "hcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGL" to "rsFMfFZSrLrFZsSL",
                "PmmdzqPrV" to "vPwwTWBwg",
                "wMqvLMZHhHMvwLH" to "jbvcjnnSBnvTQFn",
                "ttgJtRGJ" to "QctTZtZT",
                "CrZsJsPPZsGz" to "wwsLwLmpwMDw"

            )

        assertEquals(expected, Day3.parseFilePart1(input).toList())
    }

    @Test
    fun `parseFilePart2 works as intended`() {
        val inputString =
            "vJrwpWtwJgWrhcsFMMfFFhFp\n" +
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" +
                "PmmdzqPrVvPwwTWBwg\n" +
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" +
                "ttgJtRGJQctTZtZT\n" +
                "CrZsJsPPZsGzwwsLwLmpwMDw"

        val input = ByteArrayInputStream(inputString.toByteArray())

        val expected =
            listOf(
                listOf(
                    "vJrwpWtwJgWrhcsFMMfFFhFp",
                    "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                    "PmmdzqPrVvPwwTWBwg"
                ), listOf(
                    "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                    "ttgJtRGJQctTZtZT",
                    "CrZsJsPPZsGzwwsLwLmpwMDw"
                )
            )

        assertEquals(expected, Day3.parseFilePart2(input).toList())
    }
}



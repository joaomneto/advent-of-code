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
        val inputString =
            "2-4,6-8\n" +
                "2-3,4-5\n" +
                "5-7,7-9\n" +
                "2-8,3-7\n" +
                "6-6,4-6\n" +
                "2-6,4-8"

        val input = ByteArrayInputStream(inputString.toByteArray())

        val expected =
            // listOf(
            //     setOf(2,3,4) to setOf(6,7,8),
            //     setOf(2,3) to setOf(4,5),
            //     setOf(5,6,7) to setOf(3,4,5,6,7),
            //     setOf(6) to setOf(4,5,6),
            //     setOf(2,3,4,5,6) to setOf(4,5,6,7,8)
            // )
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

    // @Test
    // fun `parseFilePart2 works as intended`() {
    //     val inputString =
    //         "vJrwpWtwJgWrhcsFMMfFFhFp\n" +
    //             "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" +
    //             "PmmdzqPrVvPwwTWBwg\n" +
    //             "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" +
    //             "ttgJtRGJQctTZtZT\n" +
    //             "CrZsJsPPZsGzwwsLwLmpwMDw"
    //
    //     val input = ByteArrayInputStream(inputString.toByteArray())
    //
    //     val expected =
    //         listOf(
    //             listOf(
    //                 "vJrwpWtwJgWrhcsFMMfFFhFp",
    //                 "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
    //                 "PmmdzqPrVvPwwTWBwg"
    //             ), listOf(
    //                 "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
    //                 "ttgJtRGJQctTZtZT",
    //                 "CrZsJsPPZsGzwwsLwLmpwMDw"
    //             )
    //         )
    //
    //     assertEquals(expected, Day3.parseFilePart2(input).toList())
    // }
}



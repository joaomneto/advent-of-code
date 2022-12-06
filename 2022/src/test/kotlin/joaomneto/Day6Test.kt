package joaomneto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object Day6Test {

    @Test
    fun `solutionPart1 works as intended`() {
        assertEquals(7, Day6.solutionPart1("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
        assertEquals(5, Day6.solutionPart1("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(6, Day6.solutionPart1("nppdvjthqldpwncqszvftbrmjlhg"))
        assertEquals(10, Day6.solutionPart1("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        assertEquals(11, Day6.solutionPart1("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }

    @Test
    fun `solutionPart2 works as intended`() {
        assertEquals(19, Day6.solutionPart2("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
        assertEquals(23, Day6.solutionPart2("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(23, Day6.solutionPart2("nppdvjthqldpwncqszvftbrmjlhg"))
        assertEquals(29, Day6.solutionPart2("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        assertEquals(26, Day6.solutionPart2("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }
}



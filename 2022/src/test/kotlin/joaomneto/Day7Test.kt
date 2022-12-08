package joaomneto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

object Day7Test {

    val inputString = """
            ${'$'} cd /
            ${'$'} ls
            dir a
            14848514 b.txt
            8504156 c.dat
            dir d
            ${'$'} cd a
            ${'$'} ls
            dir e
            29116 f
            2557 g
            62596 h.lst
            ${'$'} cd e
            ${'$'} ls
            584 i
            ${'$'} cd ..
            ${'$'} cd ..
            ${'$'} cd d
            ${'$'} ls
            4060174 j
            8033020 d.log
            5626152 d.ext
            7214296 k
        """.trimIndent()



    @Test
    fun `solutionPart1 works as intended`() {
        val input = ByteArrayInputStream(inputString.toByteArray())
        assertEquals(95437, Day7.solutionPart1(Day7.parseFilePart1(input)))
    }

    @Test
    fun `solutionPart2 works as intended`() {
        val input = ByteArrayInputStream(inputString.toByteArray())
        assertEquals(24933642, Day7.solutionPart2(Day7.parseFilePart1(input)))
    }
}



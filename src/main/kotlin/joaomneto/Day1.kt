package joaomneto

import joaomneto.Runner.printResults
import java.io.InputStream

object Day1 {
    fun run(){
        val input = parseFilePart1(this::class.java.getResourceAsStream("/day1.input")!!)
        printResults(solutionPart1(input), solutionPart2(input))
    }

    fun parseFilePart1(inputStream: InputStream) = inputStream.bufferedReader().lines().toList().fold(mutableListOf(mutableListOf<Int>())){acc, s ->
        if(s.isBlank()){
            acc.add(mutableListOf())
        }else{
            acc.last().add(s.toInt())
        }
        acc
    }

    fun solutionPart2(input: List<List<Int>>) =
        input.map { it.sum() }.sortedDescending().let { it[0] + it[1] + it[2] }

    fun solutionPart1(input: List<List<Int>>) = input.maxOfOrNull { it.sum() }
}

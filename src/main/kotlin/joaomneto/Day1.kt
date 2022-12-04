package joaomneto

import java.io.InputStream

object Day1 {
    fun run(){
        val input = parseFile(this::class.java.getResourceAsStream("/day1.input")!!)
        println("Solution for day 1 (part 1): ${solutionPart1(input)}")
        println("Solution for day 1 (part 2): ${solutionPart2(input)}")
    }

    fun parseFile(inputStream: InputStream) = inputStream.bufferedReader().lines().toList().fold(mutableListOf(mutableListOf<Int>())){acc, s ->
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

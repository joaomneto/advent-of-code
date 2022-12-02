package joaomneto

import java.io.InputStream

open class Day1 {
    fun run(){
        val input = parseFile(this::class.java.getResourceAsStream("/day1/input.txt")!!)
        println("Solution for day 1 (a): ${solutionMax(input)}")
        println("Solution for day 1 (b): ${solutionTop3(input)}")
    }

    fun parseFile(inputStream: InputStream) = inputStream.bufferedReader().lines().toList().fold(mutableListOf(mutableListOf<Int>())){acc, s ->
        if(s.isBlank()){
            acc.add(mutableListOf())
        }else{
            acc.last().add(s.toInt())
        }
        acc
    }

    fun solutionTop3(input: List<List<Int>>) =
        input.map { it.sum() }.sortedDescending().let { it[0] + it[1] + it[2] }

    fun solutionMax(input: List<List<Int>>) = input.maxOfOrNull { it.sum() }
}

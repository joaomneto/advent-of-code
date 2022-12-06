package joaomneto

import java.lang.IllegalArgumentException

object Day6 {

    val input = this::class.java.classLoader.getResourceAsStream("day6.input").bufferedReader().readText()

    fun run() {
        Runner.printResults(
            solutionPart1(input),
            solutionPart2(input)
        )
    }

    private fun String.hasRepeatingCharacters(): Boolean {
        this.forEachIndexed{index, c ->
            if(this.removeRange(index, index+1).contains(c)){
                return true
            }
        }
        return false
    }

    fun solutionPart1(input: String): Int {
        for(i in 4 until input.length){
            if(!input.substring(i-4, i).hasRepeatingCharacters()){
                return i
            }
        }
        throw IllegalArgumentException()
    }

    fun solutionPart2(input: String): Int {
        for(i in 14 until input.length){
            if(!input.substring(i-14, i).hasRepeatingCharacters()){
                return i
            }
        }
        throw IllegalArgumentException()
    }
}

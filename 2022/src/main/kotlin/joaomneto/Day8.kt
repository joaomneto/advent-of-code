package joaomneto

import java.io.InputStream

object Day8 {

    fun run() {
        val inputPart1 = parseFilePart1(this::class.java.getResourceAsStream("/day8.input")!!)
        Runner.printResults(
            solutionPart1(inputPart1),
            solutionPart2(inputPart1)
        )
    }

    fun clearToLeft(matrix: List<List<Int>>, col: Int, row: Int) =
        matrix[row].subList(0, col).all { it < matrix[row][col] }

    fun clearToRight(matrix: List<List<Int>>, col: Int, row: Int) =
        matrix[row].subList(col + 1, matrix[row].size).all { it < matrix[row][col] }

    fun clearToUp(matrix: List<List<Int>>, col: Int, row: Int) =
        matrix.subList(0, row).all { it[col] < matrix[row][col] }

    fun clearToDown(matrix: List<List<Int>>, col: Int, row: Int) =
        matrix.subList(row + 1, matrix.size).all { it[col] < matrix[row][col] }

    fun scenicScoreCalculator(trees: List<Int>, current: Int) =
        trees.fold(0) { acc, i ->
            if (i >= current) {
                return acc + 1
            }
            acc + 1
        }

    fun scenicScoreLeft(matrix: List<List<Int>>, col: Int, row: Int) =
        scenicScoreCalculator(matrix[row].subList(0, col).reversed(), matrix[row][col])

    fun scenicScoreRight(matrix: List<List<Int>>, col: Int, row: Int) =
        scenicScoreCalculator(matrix[row].subList(col + 1, matrix[row].size), matrix[row][col])

    fun scenicScoreUp(matrix: List<List<Int>>, col: Int, row: Int) =
        scenicScoreCalculator(matrix.subList(0, row).map { it[col] }.reversed(), matrix[row][col])

    fun scenicScoreDown(matrix: List<List<Int>>, col: Int, row: Int) =
        scenicScoreCalculator(matrix.subList(row + 1, matrix.size).map { it[col] }, matrix[row][col])

    fun solutionPart1(input: List<List<Int>>): Int {
        var baseValue = input.first().size * 2 + (input.size - 2) * 2

        for (row in 1..input.first().size - 2) {
            for (col in 1..input.size - 2) {
                if (clearToLeft(input, col, row)
                    || clearToRight(input, col, row)
                    || clearToUp(input, col, row)
                    || clearToDown(input, col, row)
                ) baseValue++
            }
        }

        return baseValue
    }

    fun solutionPart2(input: List<List<Int>>): Int {
        val scores = mutableListOf<Int>()

        for (row in 1..input.first().size - 2) {
            for (col in 1..input.size - 2) {
                scores.add(
                    scenicScoreLeft(input, col, row)
                        * scenicScoreRight(input, col, row)
                        * scenicScoreUp(input, col, row)
                        * scenicScoreDown(input, col, row)
                )
            }
        }

        return scores.max()
    }

    fun parseFilePart1(inputStream: InputStream): List<List<Int>> =
        inputStream.bufferedReader().lineSequence().fold(emptyList()) { acc, s ->
            acc.plusElement(s.toCharArray().toList().map { it.toString().toInt() })
        }
}

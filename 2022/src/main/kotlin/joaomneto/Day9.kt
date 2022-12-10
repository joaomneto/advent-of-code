package joaomneto

object Day9 {

    fun run() {
        Runner.printResults(
            solutionPart1(this::class.java.getResourceAsStream("/day9.input")!!.bufferedReader().lineSequence()),
            solutionPart2(this::class.java.getResourceAsStream("/day9.input")!!.bufferedReader().lineSequence())
        )
    }

    data class Point(val x: Int, val y: Int) {
        fun moved(direction: String, steps: Int) = when (direction) {
            "U" -> (y + 1..y + steps).map { Point(x, it) }
            "D" -> (y - steps until y).reversed().map { Point(x, it) }
            "L" -> (x - steps until x).reversed().map { Point(it, y) }
            "R" -> (x + 1..x + steps).map { Point(it, y) }
            else -> throw IllegalArgumentException()
        }
    }

    fun moveTail(t: Point, h: Point): Point {
        return when {
            t.x == h.x && t.y == h.y - 2 -> t.copy(y = t.y + 1)
            t.x == h.x && t.y == h.y + 2 -> t.copy(y = t.y - 1)
            t.y == h.y && t.x == h.x - 2 -> t.copy(x = t.x + 1)
            t.y == h.y && t.x == h.x + 2 -> t.copy(x = t.x - 1)
            t.y < h.y - 1 && t.x < h.x || t.y < h.y && t.x < h.x - 1 -> t.copy(x = t.x + 1, y = t.y + 1)
            t.y < h.y - 1 && t.x > h.x || t.y < h.y && t.x > h.x + 1 -> t.copy(x = t.x - 1, y = t.y + 1)
            t.y > h.y + 1 && t.x < h.x || t.y > h.y && t.x < h.x - 1 -> t.copy(x = t.x + 1, y = t.y - 1)
            t.y > h.y + 1 && t.x > h.x || t.y > h.y && t.x > h.x + 1 -> t.copy(x = t.x - 1, y = t.y - 1)
            else -> t
        }
    }

    fun solutionPart1(input: Sequence<String>): Int {
        val tailPositions = mutableSetOf<Point>()
        var lastTailPosition = Point(0, 0)
        var lastHeadPosition = Point(0, 0)
        input.forEach { line ->
            with(line.split(" ")) {
                lastHeadPosition.moved(this[0], this[1].toInt())
            }.forEach { point ->
                lastHeadPosition = point
                lastTailPosition = moveTail(lastTailPosition, lastHeadPosition)
                tailPositions.add(lastTailPosition)
            }
        }
        return tailPositions.size
    }

    fun solutionPart2(input: Sequence<String>): Int {
        val knotPositions = mutableListOf((1..10).map { Point(0, 0) })
        // printPositions("Initial State", knotPositions.last())
        input.forEach { line ->
            with(line.split(" ")) {
                knotPositions.last().first().moved(this[0], this[1].toInt())
            }.forEach { point ->
                var currentHead = point
                val currentLastPositions = knotPositions.last()
                val otherKnots = (1..9).map {
                    currentHead = moveTail(currentLastPositions[it], currentHead)
                    currentHead
                }
                knotPositions.add(listOf(point).plus(otherKnots))
            }
            // printPositions(line, knotPositions.last())
        }

        return knotPositions.map { it[9] }.toSet().size
    }

    private fun printPositions(line: String, positions: List<Day9.Point>) {

        println("== $line ==\n")

        for (yy in (-5..15).reversed()) {
            for (xx in -11..14) {
                for (pos in positions.indices) {
                    val hasPrinted = with(positions[pos]) {
                        when {
                            pos == 0 && x == xx && y == yy -> {
                                print("H"); true
                            }

                            x == xx && y == yy -> {
                                print("$pos"); true
                            }

                            else -> false
                        }
                    }
                    if (hasPrinted) break
                    when {
                        (xx == 0 && yy == 0 && pos == positions.size - 1) -> print("s")
                        (pos == positions.size - 1) -> print(".")
                    }
                }
            }
            println("")
        }

        println("")
    }
}

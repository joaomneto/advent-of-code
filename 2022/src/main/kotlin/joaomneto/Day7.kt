package joaomneto

import java.io.InputStream

object Day7 {

    data class File(
        val name: String,
        val children: MutableMap<String, File> = mutableMapOf(),
        val size: Long = 0,
        val parent: File?,
        val isDir: Boolean
    ) {
        fun size(): Long {
            return if (isDir) {
                children.values.fold(0) { acc, file ->
                    acc + file.size()
                }
            } else {
                size
            }
        }

        override fun toString(): String {
            return """{ name: "$name", size: $size, parent: "${parent?.name}", isDir: $isDir }"""
        }
    }

    fun run() {
        val inputPart1 = parseFilePart1(this::class.java.getResourceAsStream("/day7.input")!!)
        Runner.printResults(
            solutionPart1(inputPart1),
            solutionPart2(inputPart1)
        )
    }

    private fun visitDirectory(f: File, action: (f: File) -> Unit) {
        action(f)

        f.children.values.filter { it.isDir }.forEach { visitDirectory(it, action) }
    }

    fun solutionPart1(input: File): Long {
        var totalSize = 0L

        visitDirectory(input){
            with(it.size()) {
                if (this <= 100000) totalSize += this
            }
        }

        return totalSize
    }

    fun solutionPart2(input: File): Long {
        val candidates = mutableListOf<Long>()
        val occupiedSpace = input.size()

        visitDirectory(input){
            with(it.size()) {
                if (70000000 - occupiedSpace + this >= 30000000){
                    candidates.add(this)
                }
            }
        }

        return candidates.min()
    }

    fun parseFilePart1(inputStream: InputStream): File {
        var currentDirectory: File? = File(name = "/", parent = null, isDir = true)
        val topDirectory: File = currentDirectory!!
        inputStream.bufferedReader().lines().forEach { command ->
            when {
                command == "$ cd .." -> currentDirectory = currentDirectory?.parent
                command == "$ cd /" -> currentDirectory = topDirectory
                command.startsWith("$ cd") -> {
                    val name = command.replace("$ cd", "").trim()
                    val dir = currentDirectory?.children?.getOrElse(name) {
                        File(
                            name = name,
                            parent = currentDirectory,
                            isDir = true
                        )
                    }!!
                    currentDirectory?.children?.put(name, dir)
                    currentDirectory = dir
                }

                command.startsWith("$ ls") -> Unit
                command.startsWith("dir") -> {
                    val name = command.replace("dir", "").trim()
                    val dir = currentDirectory?.children?.getOrElse(name) {
                        File(
                            name = name,
                            parent = currentDirectory,
                            isDir = true
                        )
                    }!!
                    currentDirectory?.children?.put(name, dir)
                }

                else -> {
                    val tokens = command.split(" ")
                    val file = currentDirectory?.children?.getOrElse(tokens.last()) {
                        File(
                            name = tokens.last(),
                            parent = currentDirectory,
                            isDir = false,
                            size = tokens.first().toLong()
                        )
                    }!!
                    currentDirectory?.children?.put(tokens.last(), file)
                }
            }
        }
        return topDirectory
    }
}

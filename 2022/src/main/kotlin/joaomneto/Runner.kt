package joaomneto

object Runner{
    fun printResults(vararg results: Any?){
        val day = Thread.currentThread().stackTrace[2].className.replace("joaomneto." ,"").chunked(3).last()
        results.forEachIndexed { index, s ->
            println("Solution for day $day (part ${index+1}): $s")
        }
    }
}

fun main() {
    for(day in 1..5){
        try {
            val kclass = Class.forName("joaomneto.Day$day").kotlin
            kclass.members.first { it.name == "run" }.call(kclass.objectInstance)
        }catch (e: ClassNotFoundException){
        }
    }
}

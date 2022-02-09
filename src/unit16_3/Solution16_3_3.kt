package unit16_3

import java.nio.file.attribute.AclEntry

/*
Разделите список на два списка по профессии
 */
fun main() {
    val dividerTask = DividerTask()

    dividerTask.divideAndPrint()
}

class DividerTask {
    val list = listOf(
        Person("Ann", "Builder"),
        Person("Bob", "Worker"),
        Person("Judy", "Builder"),
        Person("Doris", "Worker"),
        Person("Tommy", "Worker"),
        Person("Jim", "Builder"),
        Person("Sam", "Worker"),
        Person("Colin", "Builder"),
        Person("Connor", "Worker"),
        Person("Vick", "Builder"),
        Person("Polly", "Worker"),
        Person("Angela", "Builder")
    )

    fun divideAndPrint() {
        //напишите логику разделения
        val workGroup = list.groupBy {
            it.profession
        }
        println("Builders: " + workGroup["Builder"])
        println("Workers: " + workGroup["Worker"])

    }
}

data class Person(val name: String, val profession: String)
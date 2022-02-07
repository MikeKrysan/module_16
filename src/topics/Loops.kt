package topics

fun main() {
    //for each
    val items = listOf("apple", "banana", "orange") //List.of() Java 9   - список, который мы получим, будет неизменяемым
    mutableListOf("apple", "banana", "orange")  //ArrayList - список будет изменяемым

    for(item in items)  //временная переменная item в коллекции items
        println(item)   //выводим на экран каждую из этих строк

    //while
    var index = 0
    while(index < items.size) {
        println("Item at $index is ${items[index]}")
        index++
    }

    //Диапазоны (как в Pyton)
    println(5 in 3..10) //true

    for(i in 1..10)
        println(i)

    println()

    for(i in 1 until 10) {  //до 10, кроме 10
        println(i)
    }

    println()

    for(i in 10 downTo 1)   //от 10 до 1
        println(i)

    println()

    for (i in 0..100 step 10) { //с зададнным шагом
        println(i)
    }
}
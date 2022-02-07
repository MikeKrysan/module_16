package topics

fun main() {
    val a = listOf(1, 2, 3, 4, 5)
    //Когда мы итетрируемся по коллекции в Kotlin, временную переменную мы должны всегда называть it
    a.forEach { e -> println(e) }
    println(a.map { e -> e * 2 })  //map - преобразует элементы в какие-то другие элементы
    println(a.filter { e -> e % 2 == 0 })
    println(a.reduce { sum, e -> sum + e })  //Метод reduce выполняет терминальные операции сведения, возвращая некоторое значение - результат операции.

    a.sortedByDescending { it }   //сортировка по убыванию(если бы у нас был список объектов, то здесь мы могли бы на объекте вызывать геттер, получать поле и сортировать объекты по какому-то полю)

    a.any { it > 10 }  //false .
    a.all { it < 10 }    //true

    val numbers = listOf(1, 3, -4, 2, -11, 0)
    val (positive, negative) = numbers.partition { it > 0 }

    println(positive)
    println(negative)

    val result = listOf("a", "b", "ba", "ccc", "ad").groupBy { it.length }
    println(result) //HashMap или LinkedHashMap
}
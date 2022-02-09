package unit16_4

fun main() {

    //if-else
    val a = 1
    val b = 2

    if (a > b) {
        println(a)
    } else {
        println(b)  //2
    }
    //нет тернерного оператора, как в Java:
    //System.out.println(a > b ? a:b)
    //зато в Kotlin if-else может быть использовано как выражение, потому как оно возвращает значение
    val result =
        if (a > b) {    //для того, чтобы использовать if-else для возвращения значения, вариант else обязателен
            a
        } else {
            b
        }
    println(result) //2

    //range
    for (i in 0..3) {    //диапазон
        println("Num is: $i")
    }

    for (i in 3 downTo 0) {  //диапазон в обратном порядке
        println("Number is: $i")
    }

    for (i in 0..6 step 2) { //итерация
        println("num is: $i")
    }
    for (i in 0 until 3) {   //не учитываем последнее число
        println("NumUntil is: $i")
    }

    //when
    when (result) {
        0 -> println("Zero")
        1 -> println("One")
        2 -> println("Two")
        else -> println("Other number")
    }

    when(result) {
        1, 3, 5 -> println("Odd")
        2, 4, 6 -> println("Even")
    }

    when {
        result % 2 == 0 -> println("Odd")
        else -> println("Even")
    }

    val resulting = 42
    when(resulting) {
        in 0..25 -> println("Very Low")
        in 26..50 -> println("Low") //low
        in 51..75 -> println("High")
        in 76..100 -> println("Very Low")
    }

    val resulting1 = 101
    val whenResult = when(resulting1) {
        in 0..25 -> "very low"
        in 26..50 -> "low"
        in 51..75 -> "high"
        in 76..100 -> "very high"
        else -> "Out of limit"  //Важно. чтобы вернуть значение, все условия должня на него указывать. И обязательно должен быть вариант else
    }
    println(whenResult) //out of limit

    //repeat
    repeat(10) {times ->
        println(times)  // по times мы получаем доступ к номеру повтора. Отсчет идет с 0, это удобно использовать со списками, так как нумерация там тоже начинается с 0
    }

    //forEach
    println("forEach:")
    val list = mutableListOf(1, 2, 3, 4, 5)
    list.forEach{
        println(it+1)
    }

    //forEachIndexed
    list.forEachIndexed { index, i ->
        if(index == 1) {
            println(i + 100)
        } else {
            println(i + 1)
        }
    }
}
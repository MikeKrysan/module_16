package topics

fun main() {
    println(testSimple(3, 10)) //10
    println(testString(10))

    testNamedArguments(y = 4, z = 2, x = 5)

    testDefaultArguments()
    testDefaultArguments(y = 1)
    testDefaultArguments(3, 5)  //аргументы по умолчанию - очень хорошая альтернатива перегрузке методов

    printEven(1, 2, 3, 4, 5, 6, 7, 8)
    println("PrintEven")
    printEven(*intArrayOf(1, 2, 3, 4, 5), 6, 7, 8, 9)   //оператор, который берет массив из элмементов, и распределяет их под vararg-и
}

//vararg
fun printEven(vararg numbers: Int) {
    numbers.forEach { e -> if (e % 2 == 0) println(e) }
}

//fun testSimple(): Int {
//    return 5 + 5
//}

//fun testSimple(x: Int, y: Int): Int = x + y   //оба варианта верны, но если функция возвращает простое вычислиние, то можно записать так

fun testSimple(x: Int, y: Int): Int = x + y //еще более сократили, так как kotlin предугадывает тип возвращаемого значения

fun testString(x: Int): String {
    return "String is $x"
}

fun testNamedArguments(x: Int, y:Int, z: Int): List<Int> {
    return listOf(x, y, z)
}

//void
fun testDefaultArguments(x: Int =1, y: Int = 2) {
    println(x + y)

    //4 перегруженных метода в Java
//    public String foo(String name, int number, boolean toUpperCase) {
//        return(toUpperCase ? name.toUpperCase() : name ) + number;
//    }
//
//    public String foo(String name, int number) {
//        return foo(name, namber, false);
//    }
//
//    public String foo(String name, boolean toUpperCase) {
//        return foo(name, 42, toUpperCase);
//    }
//
//    public String foo(String name) {
//        return foo(name, 42);
//    }

    // в Kotlin 4 перегруженных метода в Java пишем так:
    fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false) { //т.о в Kotlin не нужна перегрузка методов, потому что есть аргументы по умолчанию
        (if(toUpperCase) name.toUpperCase() else name) + number
    }

    //vararg    - когда в функцию передаем любое количество аргументов
//    fun printEven(list: List<Int>) {  //мы могли бы делать так
//    }


}
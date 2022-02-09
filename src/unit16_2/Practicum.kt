package unit16_2

fun main() {
    val string = "Hello"

    val numInt = 1
    val numFloat = 1.toFloat()
    println(numFloat) //вывод в консоль 1.0

    val div = 1 / 2.0
    println(div) //вывод в консоль 0.5

    val div1 = 1 / 2.toDouble()
    println(div1)

    //as - оператор приведения

    //val a:String = b as String    //небезопасный тип приведения, если приведение не получится, выкинет exception
    //val a:String? = b as?String   //безопасный способ. В случае неудачи вернет null и программа продолджит выполнение

    //is и !is - знакомый подход проверки на принадлежность объекта к определенному классу - instanceOf()
//    val num = 5
//    if(num is Int) {
//        println("True")
//    } else {
//        println("False")
//    }
//
//    if(num !is Int) {
//        println("True")
//    } else {
//        println("False")
//    }

    //Элвис
    var num: Int?
    num = null

    if (num is Int) {
        println(num ?: "1")
    }

    //Smart casts - умные преобразования. Позволяет не приводить переменную к определенному типу, если ранее была проверка этой переменной на тип
    val a = A()
    checkClass(a)
    val d = D()
    checkClass(d)

    //Равенства:
    //Структурное равенство
//    val stringA = "abc"
//    val stringB = "abc"
//
//    println(stringA == stringB) //true
//    println(stringA != stringB) //false

    //Реферальное равенство
    val stringA = "abc"
    val stringB = stringA

    println(stringA === stringB)    //true
    println(stringA !== stringB)    //false

    //null-safety
    val string1:String? = null
   // val stringLength1: Int =string1.length   //напрямую обратится к переменной нельзя. Можно написать проверку через if else:
    /**
     * if(string1 == null){
     *      println("null")
     * } else {
     *      val stringLength: Int = string1.length
     */
    //Ошибка пропадет. но это не Kotlin-style
    //В Kotlin есть операторы безопасного вызова
//    val stringLength: Int? = string?.length
    //в случае, если прийдет null, он его и вернет. Чтобы не писать if else у нас есть оператор Элвис(?:)
    var stringLength2 = string1?.length ?: -1 //-1
    println (stringLength2)

    //оператор(!!) в тех случаях, когда вы точно уверены, что переменна не будет null, однако если это не так, то получайте NPE
//    val string3:String? = null
//    val stringLength3 = string3!!.length    //NPE!


}

fun checkClass(any: Any ) {
    if(any is A) {
        any.methodA()
    }
    if(any is B) {
        any.methodB()
    }
    if(any is C) {
        any.methodC()
    }
    if(any is D) {
        any.methodD()
    }
}

class A {
    fun methodA() {
        println("A method")
    }
}

class B {
    fun methodB() {
        println("B method")
    }
}

class C {
    fun methodC() {
        println("C method")
    }
}

class D {
    fun methodD() {
        println("D method")
    }
}

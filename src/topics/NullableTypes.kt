package topics

fun main() {
    var a: String = "Hello"
    //a = null // NPE исключены
    println(a.length)

    var b: String? = "Test" //если создать переменную с таким типом, то мы не сможем на ней вызывать напрямую методы.
    b = null
   // println(b.length)

    //вернет длину b, если null -> null, никакого NPE!
    b?.length   //воспользуемся save-call

    //bob?.departament?.head?.name -> null (Никаких NPE!)

    a?.length   //здесь не может быть null и среда разработки нам подсказывает, что можно обойтись без "?"

    //Elvis оператор    //1
    val l = b?.length ?: -1

    //!! - выбрасывает NPE в случае, если в переменной null
    b = if((0..10).random() > 5) "asdf" else null
    val t = b!!.length
}

/*
1. Elvis оператор
    Работает c null. Предположим, что в переменной b содержится не null, то мы хотим получить это значение, если null - то какое-то другое значение, которое мы сами определим

 */
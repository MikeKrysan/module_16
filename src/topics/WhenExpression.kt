package topics

//похоже на switch-case в Java, но позволяет делать некоторые вещи удобнее

fun main() {
    testWhen(1)
    testWhen("Hello")
    testWhen(15)
}

//testWhen(Object object)   //Java
fun testWhen(input : Any) {

    when(input) {
        1 -> println("Единица")
        2 -> println("Двойка")
        in 10..20 -> println("Oт 10 до 20")
        is String -> println("Была введена строка ${input.length}") //(а)особенность Kotlin, в данном случае он сам делает много работы за нас
        else -> println("Что-то еще")
    }

    //(String) object - в Java нужно будет делать даункаст, преобразовывать типы, чтобы получить то поле, которое характерно для объектов класса String
}

/**
 * public void test(Object input) {
 * if(input instandeOf String) {
 *      String strInput = (String) input;
 * }
 *
 * if(input instanceOf Integer) {
 *      ...
 *      }
 * }
 */
package unit16_2
/*
Расставьте условия таким образом, чтобы вывод в консоль был sword.
 */
//fun main() {
//    GiveMePassword().getPassword()
//}
//
//class GiveMePassword {
//    var password = ""
//
//    val a = A()
//    val b = a
//
//    val num = 1
//    val num1 = 1
//
//    val string = "Hi"
//    val string1 = "Hei"
//
//    fun getPassword () {
//        if (a == b) {
//            password += "s"
//        } else {
//            password += "i"
//        }
//        if (a !== b) {
//            password += "w"
//        }
//        if (b !is A) {
//            password += "o"
//        } else {
//            password += "9"
//        }
//        if (num === num1) {
//            password += "r"
//        } else {
//            password += "m"
//        }
//        if (string != string1) {
//            password += "d"
//        }
//
//        println(password)
//    }
//}
//
//open class A
//class B : A()

fun main() {
    GiveMePassword().getPassword()  //sword
}

class GiveMePassword {
    var password = ""

    val a = A1()
    val b = a

    val num = 1
    val num1 = 1

    val string = "Hi"
    val string1 = "Hei"

    fun getPassword() {
        if (a === b) {  //true - сравнили ссылки по адресу(реферальное равенство)
            password += "s"
        } else {
            password += "i"
        }
        if(a == b) {    //true - равенство по значению (структурное равенство)
            password +="w"
        }
        if(b is A1) {   //true
            password += "o"
        } else {
            password += "9"
        }
        if(num == num1) {   //true - равенство по значению (1)
            password +="r"
        } else {
            password +="m"
        }
        if(string != string1) { //true - не равны структурно
            password +="d"
        }

        println(password)
    }
}

open class A1
class B1:A1()
package topics

fun main() {
    var child = Person("Jerry", "Jones", 1)
    val p1 = Person("Tom", "Jones", 35, child)
    print(p1.firstName)

    var rectangle1 = Rectangle(5.0, 2.0)
    println("The perimetr is ${rectangle1.perimeter}")

    var rectangle2 = Rectangle(5.0, 2.0)
    println(rectangle1 == rectangle2)       //Если бы не было метода hashCode().equals() - (data) -> false, а так true

}

class Person(val firstName: String, val lastName: String, var age: Int) {   //первичный конструктор
    var children: MutableList<Person> = mutableListOf() //ArrayList

    init {
        println("Person is created $firstName")
    }

    //вторичный конструктор. Нужно обязательно указать первичный конструктор. Похоже на перегрузку методов в Java
    constructor(firstName: String, lastName: String, age: Int, child: Person) : this(firstName, lastName, age) {
        children.add(child)
    }

    //конструктор без аргументов
    constructor() : this("", "", -1)

}

data class Rectangle(var height: Double, var length: Double) {  //если пометить класс data, то автоматически у нас будут созданы методы equals, hashCode, toString и другие полезные методы
    var perimeter = (height + length) * 2

    var test = 1
        //для любого поля можно создавать свой геттер и сеттер
        get() = field + 1 //this.поле - как в конструкторе Java
        set(value) {
            if (value < 0) println("Negative value")
            field = value
        }

    fun area() = height * length

}
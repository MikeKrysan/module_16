package unit16_3

fun main() {
    //Kotlin поддерживает изменяемые и неизменяемые коллекции
    val list: MutableList<Int> = mutableListOf(1, 2, 3, 4)
    list.add(5)
    println(list)

    val list1: List<Int> = listOf(1, 2, 3, 4)
    //list1.add(5)  - ошибка

    //создание списка в Java
    //ArrayList<String> list = new ArrayList<>()

    //в Kotlin создание коллекций происходит через соответствующие методы, хотя можно делать и так: val list = ArrayList<String>()
    val list2 = mutableListOf<String>()
    val set = mutableSetOf<String>()
    val map = mutableMapOf<String, Int>()

    //создаем неизменяемый map
    val map1 = mutableMapOf(Pair("string", 1), Pair("string2", 2))
    //явно указывать тип не надо, Kotlin позволяет писать код проще, используя infix функции
    val map2 = mutableMapOf("string" to 1, "string2" to 2)

    val element = list.get(1)   //-> val element = list[1]


    //----------Работа со списками------------
    /////Получение элементов//////
    //getOrElse
    val list3 = mutableListOf(1, 2, 3, 4, 5)
    val element1 = list.getOrElse(6) {
        -1
    }
    println(element1)   //-1

    //getOrNull
    val list4 = mutableListOf(1, 2, 3, 4, 5)
    val element2 = list.getOrNull(6) ?: -2
    println(element2)   //-2

    //////Фильтрация///////
    //filter
    val list5 = mutableListOf(1, 2, 3, 4, 5)
    val newList = list5.filter {
        it % 2 == 0
    }
    println(newList)    //[2, 4]

    //drop, dropWhile, dropLast, dropLastWhile

    val list6 = listOf(1, 2, 3, 4, 5)
    println(list6.drop(2))  //[3, 4, 5]
    println(list6.dropWhile {
        it <= 3
    })  //[4, 5]
    println(list6.dropLast(2))   //[1, 2, 3]
    println(list6.dropLastWhile {
        it >= 3
    })  //[1,2]
    println("take:")

    //take, takeWhile, takeLast, takeLastWhile
    val list7 = listOf(1, 2, 3, 4, 5)
    println(list7.take(2))   //[1, 2]
    println(list7.takeWhile {
        it <= 3
    })  //[1, 2, 3]
    println(list7.takeLast(2))  //[4, 5]
    println(list7.takeLastWhile {
        it >= 3
    })  //[3, 4, 5]
//Важно! takeWhile прервется после первого неудовлетворенного условия, filter - пройдет всю коллекцию и отберет то, что удовлетворяет условию

    //max
    println("max:")
    val list8 = listOf(1, 2, 3, 4, 5)
    val max = list8.maxOrNull()
    println(max)    //5

    //min
    println("min:")
    val list9 = listOf(1, 2, 3, 4, 5)
    val min = list.minOrNull()
    println(min)    //1

    //maxBy
    println("maxBy:")
    val carList = listOf(Car("Ford", 200), Car("Ferrari", 300))
    val fasterCar = carList.maxByOrNull {
        it.maxSpeed
    }
    println(fasterCar)  //Car(model=Ferrari, maxSpeed=300)

    //maxWith - здесь мы можем использовать свое условие сортировки(Comporator)
    println("maxWith:")
    val carList1 = listOf(
        Car("Ford", 200),
        Car("Ferrari", 300),
        Car("Koenigsegg", 400)
    )
    val longestNameCar = carList1.maxWithOrNull(
        Comparator { car1, car2 ->
            car1.Name.length - car2.Name.length
        })
    println(longestNameCar) //Car(model = Koenigsegg, maxSpeed = 400)

    //groupBy - группирует списки по заданному условию, на выходе получается Map, где пара ключ-значение - это [Тип параметра сортировки, список сгруппированных объектов]
    println("groupBy:")
    val carList2 = mutableListOf(
        Car1(Name = "Ferrari", maxSpeed = 300, carClass = "s"),
        Car1(Name = "Ford", maxSpeed = 200, carClass = "a"),
        Car1(Name = "Koenigsegg", maxSpeed = 400, carClass = "s")
    )
    val carGroups = carList2.groupBy {
        it.carClass
    }
    println(carGroups)
    //{s=[Car1(Name=Ferrari, maxSpeed=300, carClass=s), Car1(Name=Koenigsegg, maxSpeed=400, carClass=s)], a=[Car1(Name=Ford, maxSpeed=200, carClass=a)]}
    //В нашем случае мы получили 2 списка, которые сгруппированы по классу машины carClass

    //distinct, distinctBy - методы, которые оставляют первые элементы и удаляют все последующие их дубликаты
    //distinct - возвращает новый список без дубликатов
    println("distinct:")
    val list10 = listOf(3, 1, 2, 3, 3, 2, 1)
    val distincted = list10.distinct()
    println(distincted) //[3, 1, 2]

    //distinctBy  - позволяет задать условие проверки на дубликат
    println("distinctBy:")
    val carList3 = mutableListOf(
        Car1(Name = "Ferrari", maxSpeed = 300, carClass = "s"),
        Car1(Name = "Ford", maxSpeed = 200, carClass = "a"),
        Car1(Name = "Koenigsegg", maxSpeed = 400, carClass = "s")
    )
    val carDistinct = carList3.distinctBy {
        it.carClass
    }
    println(carDistinct)    //[Car1(Name=Ferrari, maxSpeed=300, carClass=s), Car1(Name=Ford, maxSpeed=200, carClass=a)]

    ///////Трансформация////////

    //Map
    println("map:")
    val list11 = mutableListOf(1, 2, 3, 4, 5)
    val listOfMap = list11.map {
        it + 1
    }
    println(listOfMap)  //[2, 3, 4, 5, 6]

    //flatMap - объединение коллекций в еще одну, в один список
    println("flatMap")
    val list12 = listOf(1, 2, 3, 4, 5)
    val list13 = listOf(6, 7, 8, 9, 10)
    val all = listOf(list12, list13)
    // println(all)    //[[1, 2, 3, 4, 5], [6, 7, 8, 9, 10]]
    //мы можем их объединить в один список нашей функцией:
    val listOfMap1 = all.flatMap {
        it
    }
    println(listOfMap1) //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    //Также, если я не хочу в лямбде еще что то делать со списком (например, развернуть порядок)
    val listOfMap2 = all.flatMap {
        it.reversed()
    }
    println(listOfMap2) //[5, 4, 3, 2, 1, 10, 9, 8, 7, 6]
    //а лишь хотите их объединить, то можно воспользоваться функцией flatten()
    val listOfMap3 = all.flatten()
    println(listOfMap3)  //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    //fill - заполняет весь список элементом, переданным в параметре
    println("fill:")
    val list14 = mutableListOf("One", "Two", "Three")
    list14.fill("num")
    println(list14) //[num, num, num]

    ///////Условия//////

    //any - если выполняется хоть одно условие - true
    println("any:")
    val list15 = listOf(1, 2, 3, 4, 5)
    val isThereFive = list15.any {
        it == 5
    }
    println(isThereFive)    //true

    //all- проверяет, соответсвуют ли все элементы предикату:
    println("all:")
    val list16 = listOf(1, 2, 3, 4, 5)
    val isBiggerThanZero = list16.all {
        it > 0
    }
    println(isBiggerThanZero)   //true

    //none - противоположность all
    println("none:")
    val isLesserThanZero = list16.none {
        it < 0
    }
    println(isLesserThanZero)   //true

    //count - работает как any, но возвращает количество элементов, которые удовлетворяют условиям предиката
    println("count:")
    val list17 = listOf(1, 2, 3, 4, 5)
    val oddsCount = list17.count {
        it % 2 != 0
    }
    println(oddsCount)  //3

    //contains - проверяет, есть ли элемент в списке, если есть  - true
    println("contains:")
    val listString = listOf("a", "b", "c")
    println(listString.contains("b")) //true

    //containsAll - проверяет сразу несколько элементов на присутствие в списке
    println("containsAll:")
    println(listString.containsAll(listOf("a", "d")))   //false


    ///////Сортировка////////

    //reverse, reversed - разворачивают список в обратном направлении. reverse - работает с изменяемыми списками, reversed - с неизменяемыми
    println("reverse, reversed:")
    val mutableList = mutableListOf(1, 2, 3, 4, 5)
    val immutableList = listOf(1, 2, 3, 4, 5)
    println(mutableList.reverse())  //[5, 4, 3, 2, 1] - ? эта функция меняет порядок элементов в списке, но не возвращает сам список, после вызова этой функции нужно выводить в консоль сам список
    println(mutableList)
    println(immutableList.reversed())   //[5, 4, 3, 2, 1]

    //sort - сортирует список по возрастанию, работает только с изменяемыми коллекциями
    println("sort:")
    val list18 = mutableListOf(5, 3, 2, 1, 4)
    list18.sort()
    println(list18) //[1, 2, 3, 4, 5]

    //sortDescending - аналогичен sort, но выстраивает список по убыванию
    println("sortDescending")
    val list19 = mutableListOf(5, 3, 2, 1, 4)
    list19.sortDescending()
    println(list19) //[5, 4, 3, 2, 1]

    //sorted, sortedDescending - работают с неизменяемыми списками
    println("sorted:")
    val list20 = listOf(5, 3, 2, 1, 4)
    val sorted = list20.sorted()
    println(sorted)  //[1, 2, 3, 4, 5]

    println("sortedDescending:")
    val list21 = listOf(5, 3, 2, 1, 4)
    val sorted1 = list21.sortedDescending()
    println(sorted1)    //[5, 4, 3, 2, 1]

    //sortBy -  сортирует по возрастанию изменяемый список, модифицируя его
    println("sortBy:")
    val carList4 = mutableListOf(
        Car("Ferrari", 300),
        Car("Ford", 200),
        Car("Koenigsegg", 400)
    )
    carList4.sortBy {
        it.maxSpeed
    }
    println(carList4)   //[Car(Name=Ford, maxSpeed=200), Car(Name=Ferrari, maxSpeed=300), Car(Name=Koenigsegg, maxSpeed=400)]

    //sortByDescending - сортирует по убыванию
    println("sortByDescending:")
    val carList5 = mutableListOf(
        Car("Ferrari", 300),
        Car("Ford", 200),
        Car("Koenigsegg", 400)
    )
    carList4.sortByDescending {
        it.maxSpeed
    }
    println(carList5)   //[Car(Name=Ferrari, maxSpeed=300), Car(Name=Ford, maxSpeed=200), Car(Name=Koenigsegg, maxSpeed=400)]

    //shuffle, shuffled - перемешивает список случайным образом. shuffle - на изменяемом списке, shuffled - можно применять и на неизменяемом
    println("shuffle:")
    val list22 = mutableListOf(1, 2, 3)
    list22.shuffle()
    println(list22) //будет случайный порядок

    println("shuffled:")
    val list23 = listOf(1, 2, 3)
    val shuffled = list23.shuffled()
    println(shuffled)   //случайный порядок

    //average - считает среднее значение элементов списка и возвращает double
    println("avarage:")
    val list24 = listOf(1, 2, 3)
    println(list24.average())   //2.0


    //--------Добавление/удаление элементов

    //+
    println("+:")
    val list25 = listOf(1, 2, 3)
    val list26 = listOf(4, 5, 6)
    val listAll = list25 + list26
    println(listAll)    //[1, 2, 3, 4, 5, 6]

    //plus - добавляет один элемент в конец списка. Используется с неизменямыми списками
    println("plus:")
    val list27 = listOf(1, 2, 3)
    println(list27.plus(4)) //[1, 2, 3, 4]

    //minus- удаляет элемет из списка с указанным значением
    println("minus:")
    val list28 = listOf(1, 2, 3)
    println(list28.minus(3))    //[1, 2]
    //важно:
    val list29 = listOf(3, 1, 2, 3)
    println(list29.minus(3))    //[1, 2, 3] - удален будет только первый элемент

    //addAll
    println("addAll:")
    val list30 = mutableListOf(1, 2, 3)
    val list31 = listOf(3, 2, 1)
    list30.addAll(list31)
    println(list30) //[1, 2, 3, 3, 2, 1]

    //plusAssign - плюс в том, что это inline-функция
    println("plusAssign:")
    val list32 = mutableListOf(1, 2, 3)
    val list33 = listOf(3, 2, 1)
    list32.plusAssign(list33)
    println(list32)


    //zip -  объединяет два листа в map. Те кому пары не досталось, в map не попадут
    println("zip:")
    val list34 = listOf("One", "Two", "Three")  //если только в этом списке добавить "Four" - ничего не произойдет
    val list35 = listOf(1, 2, 3)    //если только в этом списке добавить "4" - ничего не произойде
    val zip = list34.zip(list35)
    println(zip)    //[(One, 1), (Two, 2), (Three, 3)]

    //joinToString - объединяет весь список в одну строку
    println("joinToString:")
    val list36 = listOf("One", "Two", "Three")
    val join = list36.joinToString("/")    //разделитель по-умолчанию - запятая
    println(join)   //One, Two, Three

    //Sequences - представляет тот же функционал что и Iterable(промежуточный вариант всей коллекции в Java для каждой операции), только возвращает результат, только когда оно потребуется где-то еще
    //поэтому sequences позволяет избежать ненужного создания промежуточных вариантов
    //Sequence можно сразу создать из элеметов:
    val namesSequance = sequenceOf("Tom", "Bill", "Eddy")
    //можно создать из уже имеющегося Iterable:
    val list37 = mutableListOf(1, 2, 3, 4, 5)
    val listSequance1 = list37.asSequence()

    // создание Sequance из функции
    val seq = generateSequence(1) {
        if(it<15)it+1
        else null
    }

}


data class Car(val Name: String, val maxSpeed: Int) {
}

data class Car1(val Name: String, val maxSpeed: Int, val carClass: String) {
}
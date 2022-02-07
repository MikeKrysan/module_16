package yandex

fun main() {
    //Даны два массива: [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2]  - берем минимум раз одинаковых чисел в каждом из массивов, из двух этих массивов, и выводим минимальное количество повторений в  массивах
    //надо вернуть [1, 2, 2, 3]
    println(getRepeatedIntersection(intArrayOf(1, 2, 3, 2, 0), intArrayOf(5, 1, 2, 7, 3, 2)))
}

fun getRepeatedIntersection(a1: IntArray, a2: IntArray): List<Int> {    //возвращаем количество множеств, которые учитывают количество повторений
    val s1 = a1.toHashSet() //Returns a new HashSet of all elements.
    val s2 = a2.toHashSet() //вызывем toHashSet и получим HashSet для каждого из этих массивов

    //результирующий список
    val result = mutableListOf<Int>()   //Returns an empty new MutableList.(A generic ordered collection of elements that supports adding and removing elements.)

    //пойдем по сету s1
    for (el in s1) {    //для каждого элемента в этом сете
        //мы проверяем, что такой элемент есть во втором сете
        if (s2.contains(el)) {  //contains быстро работает на Set, именно потому мы создали Set из двух массивов
            //мы должны понять, сколько раз есть пересечения в двух массивах
            val numOfRepeats = minOf(a1.count{it == el}, a2.count{it == el})
            repeat(numOfRepeats) { result.add(el)}
        }
    }
    return  result
}
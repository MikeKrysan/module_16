package yandex

fun main() {
    /**
     * Sample Input ["eat", "tea", "tan", "ate", "nat", "bat"]
     * Samplt Output[["ate", "eat", "tea"], ["nat", "tan"], ["bat"]]
     * То-есть нужно сгруппировать слова по общим буквам
    */
    println(groupWords(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))  //запустим на массиве - arrayOf()
}

//возвращаем список, охарактеризованный еще одним списком и этот список уже параметризован строкой
fun groupWords(words: Array<String>): List<List<String>> {  //функция будет принимать список из строк и будет возвращать список из списков (список, характеризованный еще одним списком и этот список параметризован строкой - хранит строки)
    val result: MutableList<List<String>> = mutableListOf()

    val map = mutableMapOf<String, MutableList<String>>()   //в качестве ключей - отсортированные слова, в качестве значений - списки

    for(word in words) {    //будем идти по словам, которые есть в списке words
        //['a', 'b', 'c'].joinToString() ->'abc'
        //['a', 'b', 'c'].joinToString("-") ->'a-b-c'
        val sortedWord = word.toCharArray().sorted().joinToString("")   //(1)для каждого слова сортируем лексиграфически, по алфавитному порядку. Берем слово, превращаем его в массив из char, сортируем его и обратно преобразуем в строку

        if(map.containsKey(sortedWord)) //(2)проверяем, что в мапе у нас есть уже слово в качестве ключа
            map[sortedWord]?.add(word)  //(3)каждый раз, когда мы будем встречать такое-же отсортированное слово, мы будем в список добавлять новое слово
        else
            map[sortedWord] = mutableListOf(word)   //если же там такого слова нет, то в мапу мы помещаем список, который содержит одно это слово. Когда мы первый раз встречаем такое отсортированное слово, мы помещаем под этим ключем значение списка с этим одним словом
    }

    for((key, value) in map) {  //пройдемся по мапе со всеми словами
        result.add(value)   //добавим каждый из массивов, который был сформирован в этой мапе
    }

    return result
}

/*
1. sorted() - Returns a list of all elements sorted according to their natural sort order.
2. containsKey() - Returns true if the map contains the specified key.
3. Используем save-call, так как теоретически здесь может находится null
 */
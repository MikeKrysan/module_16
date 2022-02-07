package yandex

fun main() {
    //AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBB -> A4B3C2XYZD4E3F3A6B12
    println(countLetters("AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBB"))
}

fun countLetters(str: String): String {
    var currentLetter = str[0]
    var count = 1
    var result = ""

    for(letter in str.substring(1)) {   //берем всю строку, кроме первого элемента
        if(currentLetter == letter) {//если первая буква равняется второй букве, где мы сейчас находимся
            count++ //увеличиваем счетчик для нашей повторяющейся буквы
        } else {    //(а)
            if(count == 1)
                result +=currentLetter
            else
                result += "$currentLetter$count"

            count = 1
            currentLetter = letter
        }
    }
    //для последних букв в строке, так как мы никогда не дойдем до условия, прописанного в строке а)
    if(count ==1)
        result +=currentLetter
    else
        result +="$currentLetter$count"


    return result

}
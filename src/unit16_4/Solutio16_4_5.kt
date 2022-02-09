package unit16_4

/*
Используя полученные знания о циклах, сгенерируйте с помощью них дату своего рождения, то есть должны быть сгенерированы 8 цифр + 2 разделителя (на ваш вкус).
Вывод должен быть примерно такой: 01.01.1970 или 01/01/1970.
 */
fun main() {
    val birthDateGenerator = BirthDateGenerator()
    println(birthDateGenerator.generateDate())
}

class BirthDateGenerator {

    fun generateDate(): String {
        var date = ""
        repeat(10) {
            when (it) {
                0 -> {
                    for (i in 0..3) {
                        if (i == 2) {
                            date += i
                        }
                    }
                }
                1 -> {
                    for (i in 0..9) {
                        if (i == 4) {
                            date += i
                        }
                    }
                }
                2 -> date += "/"
                3 -> {
                    for (i in 0..1) {
                        if (i == 0) {
                            date += i
                        }
                    }
                }
                4 -> {
                    for (i in 0..9) {
                        if (i == 7) {
                            date += i
                        }
                    }
                }
                5 -> date += "/"
                6 -> {
                    for (i in 0..1) {
                        if (i == 1) {
                            date += i
                        }
                    }
                }
                7 -> {
                    for (i in 0..9) {
                        if (i == 9) {
                            date += i
                        }
                    }
                }
                8 -> {
                    for (i in 0..9) {
                        if (i == 8) {
                            date += i
                        }
                    }
                }
                9 -> {
                    for (i in 0..9) {
                        if (i == 7) {
                            date += i
                        }
                    }
                }
            }
        }
        return date
    }
}

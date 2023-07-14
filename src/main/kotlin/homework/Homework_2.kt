package homework

fun main(args: Array<String>) {
    printMenu2()
}
fun printMenu2() {
    // Вставляем пустую строку,
    // чтобы отделить заголовок меню
    println()
    // Заголовок меню
    val hello = "*** Welcome to Taernyl's Folly ***"
    // Количество символов в заголовке меню
    val cnt = hello.count()
    // Выводим заголовок меню
    println(hello)
    // Создаем изменяемый список с видами элементов меню
    val typeList = mutableListOf<String>()
    // Цикл по количеству элементов меню
    menuList.forEach { t ->
        // "Разбирем" строку меню на элементы
        val (type, _, _) = t.split(',')
        // Если такого элемента нет...
        if (typeList.contains(type) == false) {
            // ... добавляем его в список
            typeList.add(type)
            //Формируем и выводим заголовок вида
            val titleType = "           ~[" + type + "]~"
            println(titleType)
            // Ищем все записи в таким видом
            menuList.forEach { tt ->
                val (type2, name, price) = tt.split(',')
                // Если вид текущей записи совпадает с выбранным...
                if (type == type2) {
                    // ... выводим его в меню
                    // Делаем первую букву названия заглавной
                    val nameOut = name[0].toUpperCase() + name.substring(
                        1,
                        name.count()
                    )
                    // Определяем, сколько символов после десятичной точки
                    val pos = price.indexOf('.')
                    // Если он один, то добавляем 0
                    val priceOut = if (price.count() - pos == 2) {
                        price + '0'
                    } else {
                        price
                    }
                    // Дополняем название пункта меню нужным количество точек
                    val s = nameOut.padEnd(cnt - priceOut.count(), '.')
                    // Печатаем пункт меню с точками, дополненный ценой
                    println(s + priceOut)
                }
            }
        }

    }
    println() // Пустая строка для отделения меню
}
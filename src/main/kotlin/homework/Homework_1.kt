package homework

import java.io.File


val menuList = File("src/main/kotlin/data/tavern-menu-items.txt").readText().split("\n")
val fileListWriter = mutableListOf<String>()
fun printMenu() {
    // Вставляем пустую строку,
    // чтобы отделить заголовок меню
    println()
    // Заголовок меню
    val hello = "*** Welcome to Taernyl's Folly ***"
    // Количество символов в заголовке меню
    val cnt = hello.count()
    // Выводим заголовок меню
    println(hello)
    println() // Пустая строка
    // Цикл по количеству элементов меню
    menuList.forEach {t ->
        // "Разбирем" строку меню на элементы
        val (_, name, price) = t.split(',')
        // Делаем первую букву названия заглавной
        val nameOut = name[0].toUpperCase() + name.substring(1, name.count())
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

    println() // Пустая строка для отделения меню
}

fun main(args: Array<String>) {
    printMenu()
}


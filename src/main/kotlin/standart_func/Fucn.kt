package standart_func

import java.io.File
//apply---------------------------------------------------------------------------------------------------------------
val menuFile = File("menu-file.txt")
//menuFile.setReadable(true)
//menuFile.setWritable(true)
//menuFile.setExecutable(false)

val menuFile1 = File("menu-file.txt").apply {
    setReadable(true)
    setWritable(true)
    setExecutable(false)
}

//let---------------------------------------------------------------------------------------------------------------
val firstItemSquared = listOf(1,2,3).first().let {
    it * it
}

fun formatGreeting(vipGuest: String?): String {
    return vipGuest?.let {
        "Welcome, $it. Please, go straight back - your table is ready."
    } ?: "Welcome to the tavern. You'll be seated soon."
}

//fun formatGreeting(vipGuest: String?): String {
//    return if (vipGuest != null) {
//        "Welcome, $vipGuest. Please, go straight back - your table is ready."
//    } else {
//        "Welcome to the tavern. You'll be seated shortly."
//    }
//}

//run---------------------------------------------------------------------------------------------------------------
val menuFile2 = File("menu-file.txt")
val servesDragonsBreath = menuFile2.run {
    readText().contains("Dragon's Breath")
}
//with---------------------------------------------------------------------------------------------------------------
//Рекомендуем избегать with и  использовать вместо нее run
val nameTooLong = with("Polarcubis, Supreme Master of NyetHack") {
    length >= 20
}
//also---------------------------------------------------------------------------------------------------------------
//Функция also похожа на функцию let. Как и let, also передает объект-при-
//емник как аргумент в лямбду. Но есть одно большое различие между let и also:
//вторая возвращает объект-приемник, а не результат лямбды.

//Это делает also особенно полезной для добавления различных побочных
//эффектов. Пример ниже дважды вызывает also для выполнения двух разных
//операций: первая выводит имя файла, а вторая записывает содержимое файла
//в переменную fileContents.

//var fileContents: List<String>
//File("file.txt")
//.also {
//    print(it.name)
//}.also {
//    fileContents = it.readLines()
//}

//takeIf---------------------------------------------------------------------------------------------------------------
//takeIf работает немного иначе,
//чем другие стандартные функции: она вычисляет условие, или предикат, за-
//данное в лямбде, которое возвращает истинное или ложное значение. Если
//условие истинно, takeIf вернет объект-приемник. Если условие ложно, она
//вернет null.

val fileContents = File("myfile.txt")
    .takeIf { it.canRead() && it.canWrite() }
    ?.readText()

//Без takeIf это выглядит более громоздко:
//    val file = File("myfile.txt")
//    val fileContents = if (file.canRead() && file.canWrite()) {
//        file.readText()
//    } else {
//        null
//    }
//Вариант с takeIf не требует временной переменной file и явного возврата
//null. takeIf удобно использовать для проверки условия перед присваиванием
//значения переменной или продолжением работы. Концептуально takeIf — это
//оператор if, но с преимуществом прямого воздействия на экземпляр, что часто
//позволяет избавиться от временной переменной.


//takeUnless---------------------------------------------------------------------------------------------------------------
//Функция takeUnless действует так же, как takeIf,
//но возвращает объект-приемник, если условие ложно.
val fileContents1 = File("myfile.txt").takeUnless { it.isHidden }?.readText()

//   takeIf — возвращает значение, если условие истинно;
//   takeUnless — возвращает значение, если условие не истинно
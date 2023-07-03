fun main(args: Array<String>) {
//----------------------------------------------------------------------------------------
//    Вариант первый: Испльзование безопасного вызова let ПРЕДПОЧТИТЕЛЬНЕЕ
//    var beverage = readLine()?.let {
//        if (it.isNotBlank()){
//            it.capitalize()
//        }else{
//            "Buttered Ale"
//        }
//    }
//    beverage = null
//    println(beverage)

//-----------------------------------------------------------------------------------------
//    Вариант второй: оператор !!.( Использовать !!. — все равно что сказать компилятору:
//«Если я хочу провести операцию с несуществующим значением, то ТРЕБУЮ,
//чтобы ты вызвал NullPointerException!»)

//    var beverage = readLine()!!.capitalize()
//    println(beverage)

//-----------------------------------------------------------------------------------------
//    Вариант третий: проверить значение на равенство null.

//    var beverage = readLine()
//   beverage = null
//    if (beverage != null) {
//        beverage = beverage.capitalize()
//    } else {
//        println("I can't do that without crashing - beverage was null!")
//    }
//    println(beverage)


//-----------------------------------------------------------------------------------------
//    Оператор ?: (null coalescing
//operator, или оператор объединения по null, также известный как оператор
//«Элвис», потому что похож на прическу Элвиса Пресли).
//    Оператор как бы
//    говорит: «Если операнд слева от меня — null, выполнить операцию справа».
    var beverage = readLine()
//   beverage = null
    if (beverage != null) {
        beverage = beverage.capitalize()
    } else {
        println("I can't do that without crashing - beverage was null!")
    }
    val beverageServed: String = beverage ?: "Buttered Ale"
    println(beverageServed)
}
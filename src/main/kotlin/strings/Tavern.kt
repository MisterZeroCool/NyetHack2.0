package strings

import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME ="Taernyl's Folly"
var bochka = 5.0
val pinta = 0.125
var playerGold = 10
var playerSilver = 10

//коллекция только для чтения
val patronList = listOf("Eli","Mordoc", "Sophie")
//изменяемая коллекция
val patronMutableList = mutableListOf("Eli","Mordoc", "Sophie")
val menuList = File("src/main/kotlin/data/tavern-menu-items.txt").readText().split("\n")

fun main(args: Array<String>) {
    //contains
    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards.")
    } else {
        println("The tavern master says: Eli isn't here.")
    }
//containsAll
    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    } else {
        println("The tavern master says: Nay, they departed hours ago.")
    }


//    placeOrder("shandy, Dragon's Breath, 5.91")


    val ostatoc = countPintBeer(10000)
    println(ostatoc)
    println(patronList[0])

    println( patronList.getOrElse(4) { "Unknown Patron" })

    val fifthPatron = patronList.getOrNull(4) ?: "Unknown Patron"
    println(fifthPatron)

    patronMutableList.remove("Eli")
    patronMutableList.add("Alex")
    patronMutableList.add(0,"Alex")
    println(patronMutableList)

    val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
    val readOnlyPatronList = patronList.toList()
    patronList.add("Alex")
    patronList.add(0,"Alex")
    //изменим имеющееся значение
    patronList[0] = "Alexis"
    println(patronList)
//  clean, removeIf, -=, +=,

//for
    for (patron in patronList){
        println("Good evening, $patron")
    }
    println()
//foreEach
    patronList.forEach { patron ->
        println("Good evening, $patron")
    }

    println()
//foreEachIndexed
    patronList.forEachIndexed { index, patron ->
        println("Good evening, $patron - you're #${index + 1}")
        placeOrder(patron, menuList.shuffled().first())
    }

    menuList.forEachIndexed(){index, product ->
        println("$index: $product")
    }



}

private fun toDragonSpeak(phrase: String)=
    phrase.replace(Regex("[aeiou]")){
        when(it.value){
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }


private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")


    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price."
    println(message)

//    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "$patronName says: Thanks for the $name."
    }
    println(phrase)
}

fun performPurchase(price: Double){
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    val remainingBalance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

private fun displayBalance(){
    println("Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
}

private fun countPintBeer(order: Int = 0)
    =        if (order > 40){
    "открывайте новую бочку"
}else {
    when(order){
        40 -> "в бочке ничего не осталось"
        in 1..39 -> {
            val pints = (pinta * order)
            bochka -= pints
            "после $order заказов, остаток в пинтах  составил $bochka "
        }
        0 -> "no orders"
        else -> {}
    }
}
//    if(order != 0){
//        val pints = (pinta*order)
//        bochka -= pints
//        println("остаток в пинтах $bochka после $order заказов ")
//    }else{
//        println("no orders")
//    }

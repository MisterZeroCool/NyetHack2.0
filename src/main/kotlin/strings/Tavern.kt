package strings

import kotlin.math.roundToInt

const val TAVERN_NAME ="Taernyl's Folly"

var playerGold = 10
var playerSilver = 10

fun main(args: Array<String>) {
    placeOrder("shandy, Dragon's Breath, 5.91")
    println(countPintBeer(40))


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


private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price"
    println(message)

    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        "Madrigal exclaims ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "Madrigal says: Thanks for the $name."
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

private fun countPintBeer(order: Int = 0){
    var bochka = 5.0
    val pinta = 0.125
    when(order){
        40 -> "empty"
        in 1..39 -> {
            val pints = (pinta*order)
            bochka -= pints
            "остаток в пинтах $bochka после $order заказов "}
        0 -> "no orders"
    }
//    if(order != 0){
//        val pints = (pinta*order)
//        bochka -= pints
//        println("остаток в пинтах $bochka после $order заказов ")
//    }else{
//        println("no orders")
//    }
}
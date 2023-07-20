package ru.bignerdranch.nyethack

import kotlin.math.pow

fun main(args: Array<String>) {


//  Создаем объект класса
    val player = Player("Madrigal")
//    Вызывае функцию для данного объекта
    player.castFireball()

    // Состояние игрока
    printPlayerStatus(player)

    // Аура
    player.auraColor(player.isBlessed)


    println( intoxication())





//Карма-----------------------------------------------------------------------------------------------------------------------------
    val karma = (Math.random().pow((110 - player.healthPoints) / 100.0) *
            20 ).toInt()

    val karmaAuraColor = when(karma){
        in 16..20 -> "green"
        in 11..15 -> "purple"
        in 6..10 -> "orange"
        in 0..5 -> "red"
        else -> "has not karma"
    }
    println(karmaAuraColor)
}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor(player.isBlessed)}) " +
            "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus(player.healthPoints, player.isBlessed)}")
}

//Вывод о том, на сколько пьян игрок
private fun intoxication(numFireball: Int = 0)
   = when(numFireball){
        in 41 .. 50 -> "t0aSt3d"
        in 31 .. 40 -> "Stewed"
        in 21 .. 30 -> "Soused"
        in 11 .. 20 -> "Sloshed"
        in 1 .. 10 -> "Tipsy"
    else -> {"трезвый"}
}





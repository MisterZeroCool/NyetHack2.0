package ru.bignerdranch.nyethack

import java.lang.Exception
import java.lang.IllegalStateException
import java.util.*
import kotlin.math.pow

fun main(args: Array<String>) {
    Game.play()
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

object Game {
    //  Создаем объект класса
    private val player = Player("Madrigal")
    //    val currentRoom = Room("Foyer")
    private var currentRoom: Room = TownSquare()

    //Карта Мира где игрок может перемещаться
    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room")))

    init {
        println("Welcome, adventurer.")
        //    Вызывае функцию для данного объекта
        player.castFireball()
    }

    fun play(){
        while (true){
            //вывод информации о комнате
            println(currentRoom.description())
            println(currentRoom.load())

            // Состояние игрока
            printPlayerStatus(player)

            // Аура
            player.auraColor(player.isBlessed)
            println(karmaAuraColor)

            print("> Enter your command: ")
            println(GameInput(readLine()).processCommand())
        }
    }

    private fun printPlayerStatus(player: Player) {
        println("(Aura: ${player.auraColor(player.isBlessed)}) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus(player.healthPoints, player.isBlessed)}")
    }

    //Карма-----------------------------------------------------------------------------------------------------------------------------
    private val karma = (Math.random().pow((110 - player.healthPoints) / 100.0) *
            20 ).toInt()

    private val karmaAuraColor = when(karma){
        in 16..20 -> "green"
        in 11..15 -> "purple"
        in 6..10 -> "orange"
        in 0..5 -> "red"
        else -> "has not karma"
    }


    private fun move(directionInput: String) =
        try {
            val direction = Direction.valueOf(directionInput.toUpperCase())
            val newPosition = direction.updateCoordinate(player.currentPosition)
            if (!newPosition.isInBounds) {
                throw IllegalStateException("$direction is out of bounds.")
            }
            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom
            "OK, you move $direction to the ${newRoom.name}.\n${newRoom.load()}"
        } catch (e: Exception) {
            "Invalid direction: $directionInput."
        }

    private fun fight() = currentRoom.monster?.let{
        while (player.healthPoints > 0 && it.healthPoints > 0) {
            Thread.sleep(1000)
        }
        "Combat complete."
    } ?: "There's nothing here to fight."


    private class GameInput(arg: String?){
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1) { "" }

        fun processCommand() = when(command.toLowerCase()){
            "move" -> move(argument)
            else -> commandNotFound()
        }

        private fun commandNotFound() = "I'm not quite sure what you're trying to do!"
    }



}





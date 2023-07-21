package ru.bignerdranch.nyethack

open class Room(private val name:String) {
    //уровень опасности комнаты
    protected open val dangerLevel = 5
    //returns name of room
    fun description() = "Room: $name\n" +
            "Danger level: $dangerLevel"

    //returns string if some enter in room
    open fun load() = "Nothing much to see here..."

}

class TownSquare : Room("Town Square"){

    override val dangerLevel = super.dangerLevel - 3
    private val bellSound = "GWONG"


    final override fun load() = "The villagers rally and cheer as you enter!\n${ringBell()}"
    private fun ringBell() = "The bell tower announces your arrival. $bellSound"

}
package ru.bignerdranch.nyethack

interface FightTable {
    var healthPoints: Int
    val diceCount: Int
    val diceSides: Int
    val damageRoll: Int

    fun attack(opponent: FightTable):Int
}
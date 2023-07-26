package ru.bignerdranch.nyethack

import java.util.Random

interface FightTable {
    var healthPoints: Int
    val diceCount: Int
    val diceSides: Int
    val damageRoll: Int
        //Реализация по умолчанию.Метод чтения должен
        // возвращать сумму очков, выпавших на всех костях,
        // чтобы определить величину урона, нанесенного
        // противнику в одном раунде битвы.
        get() = (0 until diceCount).map {
            Random().nextInt(diceSides + 1)
        }.sum()

    fun attack(opponent: FightTable):Int
}

abstract class Monster (val name: String,
                        val description: String, override var healthPoints: Int): FightTable{
    override fun attack(opponent: FightTable): Int {
        val damageDealt = damageRoll
        opponent.healthPoints -= damageRoll
        return damageDealt
    }
}

class Goblin(name: String = "Goblin",
             description: String = "A nasty-looking goblin",
healthPoints: Int = 30) : Monster(name, description, healthPoints){
    override val diceCount: Int = 2
    override val diceSides: Int = 8

}
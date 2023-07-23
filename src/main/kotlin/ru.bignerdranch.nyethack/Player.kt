package ru.bignerdranch.nyethack

import java.io.File
import java.util.*

//Главный конструктор
class Player(
    _name: String,
    var healthPoints: Int = 100,
    val isBlessed: Boolean,
    private val isImmortal: Boolean
) {
    var name = "Madrigal"
        get() = "${field.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }} of $hometown"
        set(value) {
            field = value.trim()
        }

    //Город где родился игрок
    //val hometown = selectHometown()
    private val hometown by lazy { selectHometown() }

    //перемещение игрока по карте
    var currentPosition = Coordinate(0,0)

    //Блок инициализации
    //Если хотя бы одно из условий не выполнится, будет возбуждено исключение
    //IllegalArgumentException (можем проверить это в Kotlin REPL, передав в Player
    //другие параметры).
    init {
        require(healthPoints > 0) { "healthPoints must be greater than zero." }
        require(name.isNotBlank()) { "Player must have a name" }
    }

    //Вспомогательный конструктор
    constructor(name: String) :
            this(
                name,
                isBlessed = true,
                isImmortal = false
            ) {
        if (name.lowercase(Locale.getDefault()) == "kar") healthPoints = 40
    }

    //    Выводим ауру игрока
    fun auraColor(
        isBlessed: Boolean,
    ): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        return if (auraVisible) "GREEN" else "NONE"

    }

    //  Вывод статуса о здоровье игрока
    fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
        when (healthPoints) {
            100 -> "is in excellent condition!"
            in 90..99 -> "has a few scratches."
            in 75..89 -> if (isBlessed) {
                "has some minor wounds but is healing quite quickly!"
            } else {
                "has some minor wounds."
            }

            in 15..74 -> "looks pretty hurt."
            else -> "is in awful condition!"
        }


    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. (x$numFireballs)")

    private fun selectHometown() = File("src/main/kotlin/data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()

}


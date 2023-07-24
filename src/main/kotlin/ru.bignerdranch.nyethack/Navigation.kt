package ru.bignerdranch.nyethack

data class Coordinate(val x:Int, val y:Int){
    val isInBounds = x >= 0 && y >= 0
}

enum class Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST
}
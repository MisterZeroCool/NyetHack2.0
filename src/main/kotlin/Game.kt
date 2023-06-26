import kotlin.math.pow

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)
    println("$name $healthStatus")

    // Аура
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)

    // Состояние игрока
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    castFireball()


// if/else
// --------------------------------------------------------------------------------------------------------------------------
//    val healthStatus = if (healthPoints == 100) {
//        "is in excellent condition!"
//    } else if (healthPoints in 90..99) {
//        "has a few scratches."
//    } else if (healthPoints in 75..89) {
//        if (isBlessed) {
//            "has some minor wounds but is healing quite quickly!"
//        } else {
//            "has some minor wounds."
//            }
//    } else if (healthPoints in 15..74) {
//        "looks pretty hurt."
//    } else {
//        "is in awful condition!" }
//    // Состояние игрока
//    println("$name $healthStatus")

//    when
//----------------------------------------------------------------------------------------------------------------------------


//-----------------------------------------------------------------------------------------------------------------------------
    val karma = (Math.random().pow((110 - healthPoints) / 100.0) *
            20 ).toInt()

    val karmaAyraColor = when(karma){
        in 16..20 -> "green"
        in 11..15 -> "purple"
        in 6..10 -> "orange"
        in 0..5 -> "red"
        else -> "has not karma"
    }
    println(karmaAyraColor)

    val B = isBlessed
    val A = auraColor
    val H = healthStatus
    val HP = healthPoints

    val statusFormatString = "($HP)($A) -> $H"
    println(statusFormatString)

}

private fun auraColor(
    isBlessed: Boolean,
    healthPoints: Int,
    isImmortal: Boolean
): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    println(
        "(Aura: $auraColor) " +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    )
    return auraColor
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
    val healthStatus = when (healthPoints) {
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
    return healthStatus
}

private fun printPlayerStatus(auraColor: String,
                              isBlessed: Boolean,
                              name: String,
                              healthStatus: String) {
    println(
        "(Aura: $auraColor) " +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    )
    println("$name $healthStatus")
}

private fun castFireball(numFireball: Int = 2) {
    println("A glass of Fireball springs into existence. (x$numFireball)")
}

import kotlin.math.pow

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    // Аура
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    println("(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")


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
        println("$name $healthStatus")
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
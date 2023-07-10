package standart_func

import java.io.File
//apply---------------------------------------------------------------------------------------------------------------
val menuFile = File("menu-file.txt")
//menuFile.setReadable(true)
//menuFile.setWritable(true)
//menuFile.setExecutable(false)

val menuFile1 = File("menu-file.txt").apply {
    setReadable(true)
    setWritable(true)
    setExecutable(false)
}

//let---------------------------------------------------------------------------------------------------------------
val firstItemSquared = listOf(1,2,3).first().let {
    it * it
}

fun formatGreeting(vipGuest: String?): String {
    return vipGuest?.let {
        "Welcome, $it. Please, go straight back - your table is ready."
    } ?: "Welcome to the tavern. You'll be seated soon."
}

//fun formatGreeting(vipGuest: String?): String {
//    return if (vipGuest != null) {
//        "Welcome, $vipGuest. Please, go straight back - your table is ready."
//    } else {
//        "Welcome to the tavern. You'll be seated shortly."
//    }
//}
import kotlinx.serialization.json.Json
import java.io.File

fun main(args: Array<String>) {
    val file = File("C:/HSE/Second COurse HSe/KPO/Семинар 5/task1/task1/src/main/kotlin/items.json")
    val json = file.readText()
    val items: List<Item> = Json.decodeFromString<List<Item>>(json)
    println()
}
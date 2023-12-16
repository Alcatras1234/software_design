@Serializable
class Items(val a: Int) {}

fun main(args: Array<String>) {
    val file = File("file.txt")
    val content = file.readText()

    val data = Json.decodeFromString<Project>(content)
    println(data)
}
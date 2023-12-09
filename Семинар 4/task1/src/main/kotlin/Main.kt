fun main(args: Array<String>) {
    val str: String = readln()

    val parts = str.split(" ")
    val lastW: String = parts.last;
    for (i in 3 downTo 1 step 1) {
        println(lastW)
    }
}
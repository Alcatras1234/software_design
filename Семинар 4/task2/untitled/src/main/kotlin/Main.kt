fun main(args: Array<String>) {
    var counts = 0
    val str: String = readln()
    val numbers = str.split(" ")
    val n = numbers.distinct();
    println(n.size)
}
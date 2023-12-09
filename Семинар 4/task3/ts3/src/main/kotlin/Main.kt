import java.util.Random

fun main(args: Array<String>) {
    val n: Int = readln().toInt()
    var table = Array(n) {Array(n) {0} }
    for (i in 0..<n) {
        for (j in 0..<n) {
            table[i][j] = Random().nextInt(0, 10)
        }
    }
    for (i in 0..<n) {
        for (j in 0 ..<n) {
            print(table[i][j])
            print(' ')
        }
        println('\n')
    }
    var sum = 0
    for (i in 1..<n) {
        for (j in n - 1 downTo n - i step 1) {
             sum += table[i][j]
        }
    }
    println(sum)

}
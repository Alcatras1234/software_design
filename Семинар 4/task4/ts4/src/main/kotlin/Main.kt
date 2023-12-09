import kotlin.math.sqrt

fun main(args: Array<String>) {
    print("Введите тип фигуры(куб, конус, цилиндр): ")
    var str = readln()
    print("Введите высоту фигуры: ")
    var h = readln().toDouble()
    print("Введите строну/диаметр: ")
    var d= readln().toDouble()
    if (str == "куб") {
        val f: Cube= Cube(d, h)
        println(f.volume())
        println(f.square())
    }
    else if (str == "конус") {
        val f: Cone= Cone(d, h)
        println(f.volume())
        println(f.square())
    } else {
        val f: Сylinder= Сylinder(d, h)
        println(f.volume())
        println(f.square())
    }
}

interface Figure {
    fun volume() : Double
    fun square() : Double
}
class Cube (val side: Double, val high: Double) : Figure{

    override fun volume() : Double{
        var result = high * high * high
        return result;
    }

    override fun square() : Double {
        var result = side * side
        return result;
    }

}

class Cone(val side: Double, val high: Double) : Figure{

    override fun volume() : Double{
        var result = 1/3 * 3.14 * (side*side)/4 * high
        return result;
    }

    override fun square() : Double {
        val l = sqrt((side*side)/4 * high * high)
        var result = 3.14 * (side*side)/4 + 3.14 * side/2 * l
        return result;
    }

}

class Сylinder(val side: Double, val high: Double) : Figure{

    override fun volume() : Double{
        var result = 3.14 * (side*side)/4 * high
        return result;
    }

    override fun square() : Double {
        val l = sqrt((side*side)/4 * high * high)
        var result = 2 * 3.14 * (side*side)/4 + 2 * 3.14 * side/2 * high
        return result;
    }

}

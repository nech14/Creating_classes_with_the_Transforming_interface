

fun main() {

    val movable: Movable = Rect(0,0,1,1)
    movable.move(1,1)
    val f: Figure = Rect(0,0,2,3)
    val f2: Figure = Circle(0, 0 , 5)
    val f3: Figure = Square(2, 3, 7)


    println("Rect area: ${f.area()}")
    println("Circle area: ${f2.area()}")
    println("Square area: ${f3.area()} \n")


    val tr1:Transforming = Rect(0,0,2,3)
    val tr2:Transforming = Circle(0, 0 , 5)
    val tr3:Transforming = Square(0,0,4)

    tr1.resize(2)
    println(tr1)
    tr2.resize(4)
    println(tr2)
    tr3.resize(3)
    println("$tr3 \n")


    tr1.rotate(RotateDirection.CounterClockwise, 1, 1)
    print(tr1)

    tr3.rotate(RotateDirection.CounterClockwise, 3, 2)
    print(tr1)
}


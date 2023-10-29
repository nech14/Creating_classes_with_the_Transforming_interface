fun main() {

    val array = arrayOf(
        Rect(0, 0, 2, 3),
        Circle(0, 0, 5),
        Square(2, 3, 7)
    )
    println("We create:")
    println("${array[0]}\n")
    println("${array[1]}\n")
    println("${array[2]}\n\n")

    println("Rect area: ${array[0].area()}")
    println("Rect area: ${array[1].area()}")
    println("Rect area: ${array[2].area()}\n")

    array[0].resize(2)
    println("zoom 2x:\n${array[0]} \n")
    array[1].resize(4)
    println("zoom 4x:\n${array[1]} \n")
    array[2].resize(3)
    println("zoom 3x:\n${array[2]} \n")

    array[0].rotate(RotateDirection.CounterClockwise, 1, 1)
    println("rotate on CounterClockwise from (1;1):\n${array[0]} \n")
    array[1].rotate(RotateDirection.Clockwise, 1, 0)
    println("rotate on Clockwise from (1;0):\n${array[1]} \n")
    array[2].rotate(RotateDirection.CounterClockwise, 3, 2)
    println("rotate on CounterClockwise from (3;2):\n${array[2]} \n")
}

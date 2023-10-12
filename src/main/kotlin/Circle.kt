import kotlin.math.PI


class Circle(var x: Int, var y: Int, var r:Int) : Figure(2), Movable, Transforming {

    override fun area(): Float {
        return  (PI* r * r).toFloat();
    }

    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun resize(zoom: Int) {
        r *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int){
        return
    }

    override fun toString(): String {
        return "Circle($x, $y), r = $r"
    }
}
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin


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
        when(direction){
            RotateDirection.Clockwise -> {
                val bufX = x
                x = -(y-centerY) + centerX
                y = bufX-centerX + centerY
            }
            RotateDirection.CounterClockwise -> {
                val bufX = x
                x = ((y-centerY.toFloat()) + centerX.toFloat()).toInt()
                y = (-(bufX-centerX.toFloat()) + centerY.toFloat()).toInt()
            }
        }
    }

    override fun toString(): String {
        return "Circle($x, $y), r = $r"
    }
}
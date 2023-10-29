
class Square() : Movable, Figure(1), Transforming {

    private var x: Int = 0
    private var y: Int = 0
    private var width: Int = 0
    private var height: Int = width

    private var angles: Array<Float> = Array(8) { 0f }

    constructor(x: Int, y: Int, w: Int, h: Int = w) : this() {
        this.x = x
        this.y = y
        this.width = w
        this.height = this.width

        findAngles()
    }

    private fun findAngles() {
        angles[0] = (x + width / 2).toFloat()
        angles[1] = (y + height / 2).toFloat()

        angles[2] = (x + width / 2).toFloat()
        angles[3] = (y - height / 2).toFloat()

        angles[4] = (x - width / 2).toFloat()
        angles[5] = (y + height / 2).toFloat()

        angles[6] = (x - width / 2).toFloat()
        angles[7] = (y - height / 2).toFloat()
    }


    override fun area(): Float {
        return (width * height).toFloat()
    }


    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun resize(zoom: Int) {
        width *= zoom
        height = width

        for (i in 0..3) {
            angles[i * 2] = x + (x - angles[i * 2]) * zoom
            angles[i * 2 + 1] = y + (y - angles[i * 2 + 1]) * zoom
        }
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        var bufX: Float
        when (direction) {
            RotateDirection.Clockwise -> {
                for (i in 0..3) {
                    bufX = angles[i * 2]
                    angles[2 * i] = -(angles[2 * i + 1] - centerY) + centerX
                    angles[2 * i + 1] = bufX - centerX + centerY
                }
            }

            RotateDirection.CounterClockwise -> {
                for (i in 0..3) {
                    bufX = angles[i * 2]
                    angles[2 * i] = (angles[2 * i + 1] - centerY.toFloat()) + centerX.toFloat()
                    angles[2 * i + 1] = -(bufX - centerX.toFloat()) + centerY.toFloat()
                }
            }
        }
    }

    override fun toString(): String {
        var str = "angles:\n"
        for (i in 0 until 3) {
            str += "$i (" + angles[i * 2] + ", " + angles[i * 2 + 1] + ") \n"
        }
        str += "3 (" + angles[3 * 2] + ", " + angles[3 * 2 + 1] + ")"
        return "Square($x, $y), width = $width\n$str"
    }
}
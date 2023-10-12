import kotlin.math.cos
import kotlin.math.sin

class Square(): Movable, Figure(1), Transforming  {

    var x: Int = 0
    var y: Int = 0
    var width: Int = 0
    var height: Int = width

    var angles:Array<Float> = Array(8) { 0f }

    constructor(squere: Square) : this(squere.x, squere.y, squere.width, squere.height)

    constructor(x: Int, y: Int, w: Int, h: Int = w) : this() {
        this.x = x
        this.y = y
        this.width = w
        this.height = this.width

        findAngles()
    }

    private fun findAngles() {
        angles[0] = (x + width/2).toFloat()
        angles[1] = (y + height/2).toFloat()

        angles[2] = (x + width/2).toFloat()
        angles[3] = (y - height/2).toFloat()

        angles[4] = (x - width/2).toFloat()
        angles[5] = (y + height/2).toFloat()

        angles[6] = (x - width/2).toFloat()
        angles[7] = (y - height/2).toFloat()
    }


    override fun area(): Float {
        return (width*height).toFloat()
    }


    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun resize(zoom: Int) {
        width *= zoom
        height = width

        for (i in 0..3){
            angles[i*2] = x + (x - angles[i*2])*zoom
            angles[i*2+1] = y + (y - angles[i*2+1])*zoom
        }
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int, ) {
        val alpha:Float = 90F
        var bufX:Float
        if(direction == RotateDirection.Clockwise){
            for (i in 0..3){
                bufX = angles[i*2]
                angles[2*i] = -(angles[2*i+1]-centerY) + centerX
                angles[2*i+1] = angles[2*i]-centerX + centerY
            }
        }else if(direction == RotateDirection.CounterClockwise){
            for (i in 0..3){
                bufX = angles[i*2]
                angles[2*i] = (angles[2*i+1]-centerY.toFloat()) + centerX.toFloat()
                angles[2*i+1] = -(bufX-centerX.toFloat()) + centerY.toFloat()
            }
        } else{
            for (i in 0..3){
                bufX = angles[i*2]
                angles[2*i] =  (angles[2*i]-centerX) * cos(alpha) + (angles[2*i+1]-centerY) * sin(alpha) + centerX
                angles[2*i+1] = (angles[2*i+1]-centerY) * cos(alpha) + (angles[2*i]-centerX) * sin(alpha) + centerY
            }
        }
    }

    override fun toString(): String {
        return "Square($x, $y), w = $width"
    }

}
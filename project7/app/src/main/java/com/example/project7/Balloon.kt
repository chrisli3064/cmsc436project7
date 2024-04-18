package com.example.project7
import kotlin.math.sqrt

class Balloon {

    private var x: Float = 0f
    private var y: Float = 0f
    private var radius: Float = 0f

    private var popped: Boolean = false

    constructor(newX: Float, newY: Float, newRadius: Float) {
        setX(newX)
        setY(newY)
        setRadius(newRadius)
    }


    fun getX():Float{
        return x
    }


    fun setX(newX:Float) {
        x = newX
    }

    fun getY():Float{
        return y
    }

    fun setY(newY:Float) {
        y = newY
    }

    fun setRadius(newRadius:Float) {
        radius = newRadius
    }


    override fun toString(): String {
        return "($x;,$y;) $radius"
    }

    fun getDistance(pointX: Float, pointY: Float): Float {
        val deltaX = (pointX - x)
        val deltaY = (pointY - y)
        return sqrt((deltaX * deltaX + deltaY * deltaY).toFloat())
    }

    fun getRadius(): Float {
        return radius
    }

    fun getPopped(): Boolean {
        return popped
    }

    fun pop() {
        popped = true
    }
}
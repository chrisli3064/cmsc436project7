package com.example.project7
import kotlin.math.sqrt

class Balloon {

    private var x: Int? = null
    private var y: Int? = null
    private var radius: Int? = null

    private var popped: Boolean = false

    constructor(newX: Int?, newY: Int?, newRadius: Int?) {
        setX(newX)
        setY(newY)
        setRadius(newRadius)
    }


    fun setX(newX:Int?) {
        x = newX
    }

    fun setY(newY:Int?) {
        y = newY
    }

    fun setRadius(newRadius:Int?) {
        radius = newRadius
    }


    override fun toString(): String {
        return "($x;,$y;) $radius"
    fun getDistance(pointX: Int, pointY: Int): Double {
        val deltaX = (pointX - x!!)
        val deltaY = (pointY - y!!)
        return sqrt((deltaX * deltaX + deltaY * deltaY).toDouble())
    }

    fun getRadius(): Int? {
        return radius
    }

    fun getPopped(): Boolean {
        return popped
    }

    fun pop() {
        popped = true
    }
}
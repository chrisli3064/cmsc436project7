package com.example.project7

class Balloon {

    private var x: Int? = null
    private var y: Int? = null
    private var radius: Int? = null

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

}
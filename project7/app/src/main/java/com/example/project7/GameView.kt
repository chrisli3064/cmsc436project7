package com.example.project7

import android.content.Context
import android.graphics.Paint
import android.view.View

class GameView : View {

    private lateinit var paint : Paint

    private var width: Int = 0
    private var height: Int = 0

    private lateinit var balloons: Balloons

    constructor (context : Context, statusBarHeight :Int, width : Int, height : Int, bestScore : Int) : super() {

        paint = Paint()
        paint.textSize = 130f
        this.width = width
        this.height = height

    }

    fun setBalloons(balloonList: ArrayList<Balloon>){
        balloons = Balloons(balloonList)
    }
}
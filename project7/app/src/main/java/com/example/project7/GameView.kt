package com.example.project7

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.Log
import android.view.View

class GameView : View {

    private lateinit var paint : Paint

    private var width: Int = 0
    private var height: Int = 0

    private lateinit var balloons: Balloons

    constructor (context : Context, statusBarHeight :Int, width : Int, height : Int,balloonList: ArrayList<Balloon>) : super(context) {

        paint = Paint()

        this.width = width
        this.height = height

        val screenRect = Rect(0,statusBarHeight,width, height)

        balloons = Balloons(balloonList,screenRect)
    }

    fun getBalloons(): Balloons{
        return balloons
    }
    override fun onDraw(canvas: Canvas){

        super.onDraw(canvas)

        val balloonList = balloons.getAllBalloons()

        for (balloon in balloonList){
            if (!balloon.getPopped()){
                canvas.drawCircle(balloon.getX().toFloat(), balloon.getY().toFloat(), balloon.getRadius().toFloat(),paint )
            }
        }



    }
}
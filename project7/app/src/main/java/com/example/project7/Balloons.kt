package com.example.project7

import android.graphics.Rect
import android.util.Log
import kotlinx.coroutines.awaitAll

class Balloons {

    private lateinit var allBalloons: ArrayList<Balloon>
    private var counter = 0
    private var allPopped = false

    private lateinit var screenRect: Rect

    constructor(newBalloons: ArrayList<Balloon>,screenRect: Rect) {
        this.screenRect = screenRect
        allBalloons = newBalloons
        counter = allBalloons.size + 3
    }
    fun onClick (x: Float, y: Float) {
        val adjustedY = y - screenRect.top
        counter ++

        for (balloon in allBalloons) {

            if (!balloon.getPopped()) {
                val distance = balloon.getDistance(x, adjustedY)

                if (distance <= balloon.getRadius()) {
                    balloon.pop()
                }
            }
        }
    }

    fun hasWon(): Boolean {

        var pops = 0
        for( balloon in allBalloons) {
            if (balloon.getPopped())
                pops += 1
        }

        if (pops == allBalloons.size){
            allPopped = true

            if (counter <= allBalloons.size + 3)
                return true
        }

        return false
    }

    fun hasLost(): Boolean {
        return counter > allBalloons.size + 3
    }

    fun getAllBalloons(): ArrayList<Balloon>{
        return allBalloons
    }


}
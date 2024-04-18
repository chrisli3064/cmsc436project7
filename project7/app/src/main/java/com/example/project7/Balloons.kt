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
        counter = 0
    }
    fun onClick (x: Float, y: Float) : Int {
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

        // now return -1 if the user lost, 1 if the user won, and 0 if game is not over yet
        return if (hasWon()) {
            1
        } else if (hasLost()) {
            -1
        } else {
            0
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

            if (counter <= allBalloons.size + 3){
                return true
            }
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
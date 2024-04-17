package com.example.project7

import kotlinx.coroutines.awaitAll

class Balloons {

    private var allBalloons: ArrayList<Balloon>? = null
    private var counter = 0
    private var allPopped = false

    constructor(newBalloons: ArrayList<Balloon>) {

        allBalloons = newBalloons
        counter = allBalloons!!.size + 3
    }
    fun onClick (x: Int, y: Int) {

        counter ++

        for (balloon in allBalloons!!) {

            if (!balloon.getPopped()) {
                val distance = balloon.getDistance(x, y)

                if (distance < balloon.getRadius()!!) {
                    balloon.pop()
                }
            }
        }
    }

    fun hasWon(): Boolean {

        var pops = 0
        for( balloon in allBalloons!!) {
            if (balloon.getPopped())
                pops += 1
        }

        if (pops == allBalloons!!.size){
            allPopped = true

            if (counter <= allBalloons!!.size + 3)
                return true
        }

        return false
    }

    fun hasLost(): Boolean {
        return counter > allBalloons!!.size + 3
    }


}
package com.example.project7

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

    }

    fun hasLost(): Boolean {

    }


}
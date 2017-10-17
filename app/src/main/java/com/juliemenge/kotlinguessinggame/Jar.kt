package com.juliemenge.kotlinguessinggame

import java.util.*

class Jar (var itemName: String, var MAX_ITEMS: Int) {
    fun fillJar(): Int {

        //get a random number
        val randomNumberGenerator = Random()
        val randomNumber = randomNumberGenerator.nextInt(MAX_ITEMS)

        return randomNumber
    }
}
package com.juliemenge.kotlinguessinggame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //fill jar with random amount of items and display correct amount of items
        fillJarButton!!.setOnClickListener {

            //fill the jar with a random amount of items
            val jar = Jar(itemNameEditText.toString(), Integer.parseInt(maxAmountEditText!!.text.toString()))
            val actualAmount = jar.fillJar()

            itemActualTextView!!.text = actualAmount.toString()
            actualItemNameTextView.text = itemNameEditText!!.text

            //display a message whether the user is too high, too low, or correct
            when {
                Integer.parseInt(itemGuessEditText!!.text.toString()) > actualAmount -> Toast.makeText(this, "You're too high!", Toast.LENGTH_SHORT).show()
                Integer.parseInt(itemGuessEditText!!.text.toString()) < actualAmount -> Toast.makeText(this, "You're too low!", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this, "You're right!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

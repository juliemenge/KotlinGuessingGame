package com.juliemenge.kotlinguessinggame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    //variables for all of the layout items
    private var itemNameEditText: EditText? = null
    private var maxAmountEditText: EditText? = null
    private var fillJarButton: Button? = null
    private var itemGuessEditText: EditText? = null
    private var itemActualTextView: TextView? = null
    private var actualItemName: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //assign the variables to actual layout items
        itemNameEditText = findViewById(R.id.itemNameEditText)
        maxAmountEditText = findViewById(R.id.maxAmountEditText)
        fillJarButton = findViewById(R.id.fillJarButton)
        itemGuessEditText = findViewById(R.id.itemGuessEditText)
        itemActualTextView = findViewById(R.id.itemActualTextView)
        actualItemName = findViewById(R.id.actualItemNameTextView)


        //fill jar with random amount of items and display correct amount of items
        fillJarButton!!.setOnClickListener {

            //fill the jar with a random amount of items
            val jar = Jar(itemNameEditText.toString(), Integer.parseInt(maxAmountEditText!!.text.toString()))
            val actualAmount = jar.fillJar()

            itemActualTextView!!.text = actualAmount.toString()
            actualItemName!!.text = itemNameEditText!!.text

            //display a message whether the user is too high, too low, or correct
            when {
                Integer.parseInt(itemGuessEditText!!.text.toString()) > actualAmount -> Toast.makeText(this, "You're too high!", Toast.LENGTH_SHORT).show()
                Integer.parseInt(itemGuessEditText!!.text.toString()) < actualAmount -> Toast.makeText(this, "You're too low!", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this, "You're right!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

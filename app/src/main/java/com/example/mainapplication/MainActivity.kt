package com.example.mainapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_0.setOnClickListener { setTextFields("0") }
        btn_multiply.setOnClickListener { setTextFields("*") }
        btn_minus.setOnClickListener { setTextFields("-") }
        btn_delen.setOnClickListener { setTextFields("/") }
        btn_Plus.setOnClickListener { setTextFields("+") }
        btn_dot.setOnClickListener { setTextFields(".") }
        btn_1.setOnClickListener { setTextFields("1") }
        btn_2.setOnClickListener { setTextFields("2") }
        btn_3.setOnClickListener { setTextFields("3") }
        btn_4.setOnClickListener { setTextFields("4") }
        btn_5.setOnClickListener { setTextFields("5") }
        btn_6.setOnClickListener { setTextFields("6") }
        btn_7.setOnClickListener { setTextFields("7") }
        btn_8.setOnClickListener { setTextFields("8") }
        btn_9.setOnClickListener { setTextFields("9") }
        btn_Skoba1.setOnClickListener { setTextFields("(") }
        btn_Skoba2.setOnClickListener { setTextFields(")") }
        btn_Ac.setOnClickListener {
            mytxt.text = ""
            txt2.text = ""
        }
        btn_bck.setOnClickListener {

            val str = mytxt.text.toString()
            if (str.isNotEmpty())

                mytxt.text = str.substring(0, str.length - 1)
            txt2.text = ""
        }

        btn_equal.setOnClickListener {
            try {
                val ex = ExpressionBuilder(mytxt.text.toString()).build()
                val res = ex.evaluate()
                val longres = res.toLong()
                if (res == longres.toDouble())
                    txt2.text = longres.toString()
                else
                    txt2.text = res.toString()
            } catch (e: Exception) {
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }


    }

    fun setTextFields(str: String) {
        if (txt2.text != "") {
            mytxt.text = txt2.text
            txt2.text = ""
        }
        mytxt.append(str)
    }
}

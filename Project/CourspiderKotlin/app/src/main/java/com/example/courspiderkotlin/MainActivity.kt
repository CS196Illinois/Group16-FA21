package com.example.courspiderkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.courspiderkotlin.R
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val username = findViewById<TextView>(R.id.username)
        val password = findViewById<TextView>(R.id.password)
        val loginButton = findViewById<View>(R.id.loginbtn) as MaterialButton

        // admin and admin
        loginButton.setOnClickListener {
            if (username.text.toString() == "admin" && password.text.toString() == "admin") {
                //correct
                Toast.makeText(this@MainActivity, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show()
            } else {
                //incorrect
                Toast.makeText(this@MainActivity, "LOGIN FAILED", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
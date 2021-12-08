package com.example.courspidermvp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.courspidermvp.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val username = findViewById<TextView>(R.id.username)
        val password = findViewById<TextView>(R.id.password)
        val loginButton = findViewById<Button>(R.id.loginbtn)

        loginButton.setOnClickListener {
            if (username.text.toString() == "admin" && password.text.toString() == "admin") {
                //correct
                val launchDashboardActivity = Intent(this, DashboardActivity::class.java)
                startActivity(launchDashboardActivity)
                Toast.makeText(this@LoginActivity, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show()
            } else {
                //incorrect
                Toast.makeText(this@LoginActivity, "LOGIN FAILED", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
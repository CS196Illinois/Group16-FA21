package com.example.courspider.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.courspider.R

class CourseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        // display information
        val name = findViewById<TextView>(R.id.name)
        val number = findViewById<TextView>(R.id.number)
        val time = findViewById<TextView>(R.id.time)
        val type = findViewById<TextView>(R.id.type)
        val location = findViewById<TextView>(R.id.location)
        val platformURL = findViewById<TextView>(R.id.platformURL)
        val contactInfo = findViewById<TextView>(R.id.contactInfo)

        // get info about courses
        val courseName = intent.getStringExtra("name")
        val courseNumber = intent.getStringExtra("number")
        val courseTime = intent.getStringExtra("time")
        val courseType = intent.getStringExtra("type")
        val courseLocation = intent.getStringExtra("location")
        val coursePlatformURL = intent.getStringExtra("platformURL")
        val courseContactInfo = intent.getStringExtra("contactInfo")

        name.text = courseName
        number.text = courseNumber
        time.text = courseTime
        type.text = courseType
        location.text = courseLocation
        platformURL.text = coursePlatformURL
        contactInfo.text = courseContactInfo
    }
}

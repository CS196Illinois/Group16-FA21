package com.example.courspider.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.courspider.R
import com.google.android.material.textfield.TextInputLayout

class AddCourseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_course)

        // get data from EditText
        val name = findViewById<TextInputLayout>(R.id.courseName)
        val number = findViewById<TextInputLayout>(R.id.courseNumber)
        val time = findViewById<TextInputLayout>(R.id.courseTime)
        val type = findViewById<TextInputLayout>(R.id.courseType)
        val location = findViewById<TextInputLayout>(R.id.courseLocation)
        val platformURL = findViewById<TextInputLayout>(R.id.coursePlatform)
        val contactInfo = findViewById<TextInputLayout>(R.id.courseContactInfo)

        // set up save button
        val saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {
            val launchMainActivity = Intent(this, DashboardActivity::class.java)
            launchMainActivity.putExtra("name", name.editText!!.text.toString())
            launchMainActivity.putExtra("number", number.editText!!.text.toString())
            launchMainActivity.putExtra("time", time.editText?.text.toString())
            launchMainActivity.putExtra("type", type.editText?.text.toString())
            launchMainActivity.putExtra("location", location.editText?.text.toString())
            launchMainActivity.putExtra("platformURL", platformURL.editText?.text.toString())
            launchMainActivity.putExtra("contactInfo", contactInfo.editText?.text.toString())
            setResult(Activity.RESULT_OK, launchMainActivity)
            finish()
        }
    }
}

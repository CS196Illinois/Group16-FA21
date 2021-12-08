package com.example.courspidermvp.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.courspidermvp.R
import com.example.courspidermvp.firebase.Response
import com.example.courspidermvp.adapters.CourseBoardAdapter
import com.example.courspidermvp.firebase.CourseViewModel
import com.example.courspidermvp.firebase.FirebaseCallback
import com.example.courspidermvp.models.Course
import com.google.firebase.database.FirebaseDatabase

class DashboardActivity : AppCompatActivity() {
    // set up views
    private lateinit var rvBoard: RecyclerView
    private lateinit var adapter: CourseBoardAdapter
    private lateinit var addCourseButton: Button

    // courses
    private lateinit var viewModel: CourseViewModel
    private var courses: List<Course> = mutableListOf()
    private var numCourses = courses.size

    // course data
    private var name: String? = ""
    private var number: String? = ""
    private var time: String? = ""
    private var type: String? = ""
    private var location: String? = ""
    private var platformURL: String? = ""
    private var contactInfo: String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        viewModel = ViewModelProvider(this).get(CourseViewModel::class.java)
        viewModel.getResponse(object: FirebaseCallback {
            override fun onResponse(response: Response) {
                courses = response.courses!!
                Log.d("numCourses", courses.toString())
                numCourses = courses.size
                // set up recycler view
                rvBoard = findViewById(R.id.rvBoard)
                adapter = CourseBoardAdapter(this@DashboardActivity, numCourses, courses)
                rvBoard.adapter = adapter
                rvBoard.setHasFixedSize(true)
                rvBoard.layoutManager = GridLayoutManager(this@DashboardActivity, 2)
            }
        })

        // set up add course button
        addCourseButton = findViewById(R.id.addCourseBtn)

        val getNewCourseData: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                name = it.data?.getStringExtra("name")
                number = it.data?.getStringExtra("number")
                time = it.data?.getStringExtra("time")
                type = it.data?.getStringExtra("type")
                location = it.data?.getStringExtra("location")
                platformURL = it.data?.getStringExtra("platformURL")
                contactInfo = it.data?.getStringExtra("contactInfo")

                courses += Course(name, number, time, type, location, platformURL, contactInfo)
                storeNewCourseData()
                numCourses++
                val launchDashboardActivity = Intent(this, DashboardActivity::class.java)
                startActivity(launchDashboardActivity)
                Log.d("numCourses", numCourses.toString())
            }
        }

        addCourseButton.setOnClickListener {
            val launchAddCourseActivity = Intent(this, AddCourseActivity::class.java)
            getNewCourseData.launch(launchAddCourseActivity)
        }

    }

    private fun storeNewCourseData() {
        var reference = FirebaseDatabase.getInstance().getReference("Courses")
        var newCourse = Course(name, number, time, type, location, platformURL, contactInfo)
        reference.child(number!!).setValue(newCourse)
    }
}
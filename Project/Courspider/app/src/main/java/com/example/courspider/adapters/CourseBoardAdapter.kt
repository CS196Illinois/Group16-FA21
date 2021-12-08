package com.example.courspider.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.courspider.R
import com.example.courspider.activities.CourseActivity
import com.example.courspider.models.Course
import kotlin.math.min
import kotlin.math.roundToInt

class CourseBoardAdapter(
    private val context: Context,
    private val numCourses: Int,
    private val courses: List<Course>
    ) : RecyclerView.Adapter<CourseBoardAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val courseButton = itemView.findViewById<Button>(R.id.courseButton)
        fun bind(position: Int) {
            val course = courses[position]
            courseButton.text = course.number
            courseButton.setOnClickListener {
                var launchCourseActivity = Intent(context, CourseActivity::class.java)
                launchCourseActivity.putExtra("name", course.name)
                launchCourseActivity.putExtra("number", course.number)
                launchCourseActivity.putExtra("time", course.time)
                launchCourseActivity.putExtra("type", course.type)
                launchCourseActivity.putExtra("location", course.location)
                launchCourseActivity.putExtra("platformURL", course.platformURL)
                launchCourseActivity.putExtra("contactInfo", course.contactInfo)
                context.startActivity(launchCourseActivity)
            }
        }
    }

    companion object {
        private const val MARGIN_SIZE = 10
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val cardWidth = parent.width / 2 - (2 * MARGIN_SIZE)
        val cardHeight = parent.height / 4 - (2 * MARGIN_SIZE)
        val cardSideLength = min(cardWidth, cardHeight)
        val view = LayoutInflater.from(context).inflate(R.layout.course_card, parent, false)
        val layoutParams = view.findViewById<CardView>(R.id.cardView).layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.width = (cardSideLength * 1.25).roundToInt()
        layoutParams.height = cardSideLength
        layoutParams.setMargins(MARGIN_SIZE * 2, MARGIN_SIZE * 4, MARGIN_SIZE, MARGIN_SIZE * 4)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return numCourses
    }

}

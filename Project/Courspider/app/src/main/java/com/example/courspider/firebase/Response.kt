package com.example.courspider.firebase

import com.example.courspider.models.Course
import java.lang.Exception

class Response(
    var courses: List<Course>? = null,
    var exception: Exception? = null
) {
}

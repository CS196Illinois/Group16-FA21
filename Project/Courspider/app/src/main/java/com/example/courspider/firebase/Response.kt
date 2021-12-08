package com.example.courspidermvp.firebase

import com.example.courspidermvp.models.Course
import java.lang.Exception

class Response(
    var courses: List<Course>? = null,
    var exception: Exception? = null
) {
}
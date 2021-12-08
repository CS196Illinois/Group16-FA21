package com.example.courspidermvp.firebase

import com.example.courspidermvp.models.Course
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CourseRepository(
    private val ref: DatabaseReference = FirebaseDatabase.getInstance().reference.child("Courses")
) {
    fun getResponseFromDatabase(callback: FirebaseCallback) {
        ref.get().addOnCompleteListener {
            val response = Response()
            if (it.isSuccessful) {
                val result = it.result
                result?.let {
                    response.courses = result.children.map {
                        it.getValue(Course::class.java)!!
                    }
                }
            } else {
                response.exception = it.exception
            }
            callback.onResponse(response)
        }
    }
}
package com.example.courspidermvp.firebase

import androidx.lifecycle.ViewModel

class CourseViewModel(
    private val repository: CourseRepository = CourseRepository()
) : ViewModel() {
    fun getResponse(callback: FirebaseCallback) {
        repository.getResponseFromDatabase(callback)
    }
}
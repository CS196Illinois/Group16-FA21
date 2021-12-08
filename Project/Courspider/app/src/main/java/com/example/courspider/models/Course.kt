package com.example.courspidermvp.models

class Course(
    val name: String?,
    val number: String?,
    val time: String? = "",
    val type: String? = "",
    val location: String? = "",
    val platformURL: String? = "",
    val contactInfo: String? = ""
) {
    constructor() : this("", "","","","","","")
}
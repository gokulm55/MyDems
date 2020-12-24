package com.example.mydems.dataclass
data class data (
    val id : String,
    val user_type : String,
    val name : String,
    val code : String,
    val email : String,
    val phone : String,
    val token : String,
    val gender : String,
    val profile_pic : String,
    val active : String,
    val device_token : String,
    val email_verified_at : String,
    val blocked_at : String,
    val created_by : String,
    val updated_by : String,
    val deleted_at : String,
    val created_at : String,
    val updated_at : String,
    val key : String
)
data class profile (

    val success : String,
    val data : data
)
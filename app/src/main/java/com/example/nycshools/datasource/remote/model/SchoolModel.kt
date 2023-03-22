package com.example.nycshools.datasource.remote.model


import com.google.gson.annotations.SerializedName

//Data model for schools
data class SchoolModel(
    @SerializedName("dbn")
    val dbn: String? = null,
    @SerializedName("latitude")
    val latitude: String? = null,
    @SerializedName("location")
    val location: String? = null,
    @SerializedName("longitude")
    val longitude: String? = null,
    @SerializedName("overview_paragraph")
    val overview_paragraph: String? = null,
    @SerializedName("phone_number")
    val phone_number: String? = null,
    @SerializedName("school_email")
    val school_email: String? = null,
    @SerializedName("school_name")
    val school_name: String? = null,
    @SerializedName("transfer")
    val transfer: String? = null,
    @SerializedName("website")
    val website: String? = null,
    @SerializedName("zip")
    val zip: String? = null
)

data class School(
    val dbn: String? = null,
    val school_name: String? = null,
    val overview_paragraph: String? = null,
    val phone_number: String? = null,
    val school_email: String? = null,
    val transfer: String? = null,
    val website: String? = null,
    val latitude: String? = null,
    val longitude: String? = null,
    val location: String? = null,
    val zip: String? = null
)
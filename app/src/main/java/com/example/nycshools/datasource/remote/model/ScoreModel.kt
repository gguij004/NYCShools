package com.example.nycshools.datasource.remote.model

import com.google.gson.annotations.SerializedName

//Data and model for Sat scores
data class ScoreModel(
    @SerializedName("dbn")
    val dbn: String? = null,
    @SerializedName("num_of_sat_test_takers")
    val numOfSatTestTakers: String? = null,
    @SerializedName("sat_critical_reading_avg_score")
    val satCriticalReadingAvgScore: String? = null,
    @SerializedName("sat_math_avg_score")
    val satMathAvgScore: String? = null,
    @SerializedName("sat_writing_avg_score")
    val satWritingAvgScore: String? = null,
    @SerializedName("school_name")
    val schoolName: String? = null
)

data class SatScore(
    val dbm: String? = null,
    val school_name: String? = null,
    val num_of_sat_test_takers: String? = null,
    val sat_critical_reading_avg_score: String? = null,
    val sat_math_avg_score: String? = null,
    val sat_writing_avg_score: String? = null
)

fun List<ScoreModel>?.toDomain(): List<SatScore> =

    this?.map {
        SatScore(

            dbm = it.dbn ?: "Not available",
            school_name = it.schoolName ?: "Not available",
            num_of_sat_test_takers = it.numOfSatTestTakers ?: "Not available",
            sat_critical_reading_avg_score = it.satCriticalReadingAvgScore ?: "Not available",
            sat_math_avg_score = it.satMathAvgScore ?: "Not available",
            sat_writing_avg_score = it.satWritingAvgScore ?: "Not available",

            )
    } ?: emptyList()
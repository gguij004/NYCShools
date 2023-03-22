package com.example.nycshools.datasource.remote.api

import com.example.nycshools.datasource.remote.model.SatScore
import com.example.nycshools.datasource.remote.model.SchoolModel
import com.example.nycshools.datasource.remote.utils.NYC_SCHOOLS
import com.example.nycshools.datasource.remote.utils.SAT_SCORES
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SchoolsAPI {

    /**
     * Method to get schools list from API
     */
    @GET(NYC_SCHOOLS)
    suspend fun getSchools(): Response<List<SchoolModel>>

    /**
     * Method to get SAT Results from API
     */
    @GET(SAT_SCORES)
    suspend fun getSatResults(
        @Query("dbn") dbn: String
    ): Response<List<SatScore>>

}
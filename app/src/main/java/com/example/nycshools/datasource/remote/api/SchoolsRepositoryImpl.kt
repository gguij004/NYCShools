package com.example.nycshools.datasource.remote.api

import com.example.nycshools.datasource.remote.model.SatScore
import com.example.nycshools.datasource.remote.model.SchoolModel
import com.example.nycshools.shared.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SchoolRepositoryImpl @Inject constructor(
    private val serviceApi: SchoolsAPI,

) : SchoolsRepository {

    //Get the list of all schools
    override suspend fun getALlSchools(): Flow<UIState<List<SchoolModel>>> = flow {
        emit(UIState.LOADING)

        try {
            val response = serviceApi.getSchools()
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(UIState.SUCCESS(it))
                } ?: throw Exception("Schools are empty")
            } else {
                throw Exception(response.errorBody()?.string())
            }

        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }

    //Get Stat Score for an specific school using the dbn
    //throw an exception if empty or error
    override suspend fun getSatScores(dbn: String): Flow<UIState<List<SatScore>>> = flow {
        emit(UIState.LOADING)

        try {
            val response = serviceApi.getSatResults(dbn)
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(UIState.SUCCESS(it))
                } ?: throw Exception("Schools are empty")
            } else {
                throw Exception(response.errorBody()?.string())
            }

        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }
}
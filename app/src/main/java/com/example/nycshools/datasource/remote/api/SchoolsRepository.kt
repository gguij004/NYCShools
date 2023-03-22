package com.example.nycshools.datasource.remote.api

import com.example.nycshools.datasource.remote.model.SatScore
import com.example.nycshools.datasource.remote.model.SchoolModel
import com.example.nycshools.shared.UIState
import kotlinx.coroutines.flow.Flow

interface SchoolsRepository {
    suspend fun getALlSchools(): Flow<UIState<List<SchoolModel>>>
    suspend fun getSatScores(dbn: String): Flow<UIState<List<SatScore>>>
}

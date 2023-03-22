package com.example.nycshools.di

import com.example.nycshools.datasource.remote.api.SchoolRepositoryImpl
import com.example.nycshools.datasource.remote.api.SchoolsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Binds  Repository interface to be able to Inject it in viewModel
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideSchoolRepository(schoolRepositoryImpl: SchoolRepositoryImpl): SchoolsRepository

}
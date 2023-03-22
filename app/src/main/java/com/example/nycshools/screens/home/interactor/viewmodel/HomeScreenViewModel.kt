package com.example.nycshools.screens.home.interactor.viewmodel

import androidx.lifecycle.*
import androidx.navigation.NavController
import com.example.nycshools.datasource.remote.api.SchoolsRepository
import com.example.nycshools.datasource.remote.model.SatScore
import com.example.nycshools.datasource.remote.model.SchoolModel
import com.example.nycshools.shared.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val schoolsRepository: SchoolsRepository,
    private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {

    //Use to know what school was selected by user to show details
    private var selectedSchool: SchoolModel? = null

    /**
     * School live data
     */
    private val _schools: MutableLiveData<UIState<List<SchoolModel>>> =
        MutableLiveData(UIState.LOADING)

    val school: LiveData<UIState<List<SchoolModel>>> get() = _schools

    /**
     * Sat scores live data
     */
    private val _scores: MutableLiveData<UIState<List<SatScore>>> =
        MutableLiveData(UIState.LOADING)

    val scores: LiveData<UIState<List<SatScore>>> get() = _scores

    //Initialize data (get all schools )
    init {
        getInitData()
    }

    private fun getInitData() = viewModelScope.launch(ioDispatcher) {
        schoolsRepository.getALlSchools().collect {
            _schools.postValue(it)
        }
    }

    //Navigate to detail page when selected
    fun navigateToDetailScreen(school: SchoolModel, navController: NavController) {
        selectedSchool = school
        getSatResults(school.dbn.toString())
        navController.navigate("details")

    }

    /**
     * get Sat for an spesific School
     * @String dbn
     */
    private fun getSatResults(dbn: String) = viewModelScope.launch(ioDispatcher){
        schoolsRepository.getSatScores(dbn).collect {
            _scores.postValue(it)
        }

    }

}
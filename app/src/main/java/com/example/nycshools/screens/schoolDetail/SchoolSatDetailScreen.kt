package com.example.nycshools.screens.schoolDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.nycshools.datasource.remote.model.SatScore
import com.example.nycshools.screens.home.interactor.viewmodel.HomeScreenViewModel
import com.example.nycshools.screens.schoolDetail.components.SatDetailsCard
import com.example.nycshools.shared.CircularProgressBar
import com.example.nycshools.shared.TopAppBarSample
import com.example.nycshools.shared.UIState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchoolSatDetailScreen(
    homeScreenViewModel: HomeScreenViewModel,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = { TopAppBarSample("NYC Schools Sat Details") },
        content = { paddingValues ->
            schoolSatDetailScreenContent(homeScreenViewModel,modifier = modifier.padding(paddingValues))
        }
    )
}

@Composable
fun schoolSatDetailScreenContent(
    homeScreenViewModel: HomeScreenViewModel,
    modifier: Modifier
) {

    //control Ui state to be displayed to user
    when (val state = homeScreenViewModel.scores.observeAsState(UIState.LOADING).value) {
        is UIState.LOADING -> {
            CircularProgressBar()
        }
        is UIState.SUCCESS -> {
            SchoolSatScore(scores = state.response.firstOrNull(), homeScreenViewModel)
        }
        is UIState.ERROR -> {
            Text("Error retrieving SAT Scores")
        }
    }
}

@Composable
fun SchoolSatScore(
    scores: SatScore?,
    viewModel: HomeScreenViewModel,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        SatDetailsCard(scores,viewModel)
    }
}
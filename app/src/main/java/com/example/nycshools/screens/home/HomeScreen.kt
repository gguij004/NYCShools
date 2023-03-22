package com.example.nycshools.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.nycshools.screens.home.components.SchoolList
import com.example.nycshools.screens.home.interactor.viewmodel.HomeScreenViewModel
import com.example.nycshools.shared.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeScreenViewModel: HomeScreenViewModel,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            TopAppBarSample("NYC Schools")
        },
        content = { paddingValues ->
            HomeScreenContent(
                modifier = modifier.padding(paddingValues),
                homeScreenViewModel,
                navController
            )

        },
    )

}

@Composable
fun HomeScreenContent(
    modifier: Modifier,
    homeScreenViewModel: HomeScreenViewModel,
    navController: NavController
) {
    //Control The Ui state to be displayed to user.
    when (val state = homeScreenViewModel.school.observeAsState(UIState.LOADING).value) {
        is UIState.LOADING -> {
            CircularProgressBar()
        }
        is UIState.SUCCESS -> {
            SchoolList(schools = state.response, homeScreenViewModel, navController)
        }
        is UIState.ERROR -> {
            Text("Error retrieving SAT Scores")
        }
    }
}




package com.example.nycshools.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nycshools.screens.home.HomeScreen
import com.example.nycshools.screens.home.interactor.viewmodel.HomeScreenViewModel
import com.example.nycshools.screens.schoolDetail.SchoolSatDetailScreen


/**
 * App Navigation graph
 */
@Composable
fun Navigation(
    homeScreenViewModel: HomeScreenViewModel,
    navHostController: NavHostController,
) {

    NavHost(navController = navHostController, startDestination = "schoolScreen") {
        //Home Screen
        composable(route = "schoolScreen") {
            HomeScreen(homeScreenViewModel, navHostController)
        }
        //Detail Screen
        composable(route = "details") {
            SchoolSatDetailScreen(homeScreenViewModel = homeScreenViewModel)
        }
    }
}

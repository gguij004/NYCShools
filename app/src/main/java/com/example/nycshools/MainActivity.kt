package com.example.nycshools

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.nycshools.design.theme.NYCShoolsTheme
import com.example.nycshools.navigation.Navigation
import com.example.nycshools.screens.home.interactor.viewmodel.HomeScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

//Hilt entry point
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
            NYCShoolsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(
                        navHostController = navController,
                        homeScreenViewModel = homeScreenViewModel
                    )
                }
            }
        }
    }
}
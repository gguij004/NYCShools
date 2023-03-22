package com.example.nycshools.screens.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nycshools.datasource.remote.model.SchoolModel
import com.example.nycshools.screens.home.interactor.viewmodel.HomeScreenViewModel

/**
 * School list component: simple task to show all schools as a list
 * could be later reuse we some simple adjustment to be use in different places
 * @SchoolModel: Data representation of a school
 * @ViewModel: This can be change to accept different models and make it more reusabl
 * @NavController: app navigation
 */
@Composable
fun SchoolList(
    schools: List<SchoolModel>,
    viewModel: HomeScreenViewModel,
    navController: NavController,
) {
    LazyColumn(
        modifier = Modifier.padding(top = 70.dp),
        content = {
        itemsIndexed(items = schools) { _, school ->
            SchoolCard(school = school, viewModel, navController)
        }
    })
}
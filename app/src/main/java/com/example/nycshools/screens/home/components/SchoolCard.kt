package com.example.nycshools.screens.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nycshools.datasource.remote.model.SchoolModel
import com.example.nycshools.screens.home.interactor.viewmodel.HomeScreenViewModel

/**
 * School card component used to show the school data
 * could be later reuse we some simple adjustment to be use in different places
 * @SchoolModel: Data representation of a school
 * @ViewModel: This can be change to accept different models and make it more reusabl
 * @NavController: app navigation
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchoolCard(
    school: SchoolModel,
    viewModel: HomeScreenViewModel,
    navController: NavController,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 16.dp, vertical = 7.dp),
        shape = RoundedCornerShape(corner = CornerSize(18.dp)),
        onClick = {
            viewModel.navigateToDetailScreen(school, navController)
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(22.dp), verticalArrangement = Arrangement.Center
        ) {
            school.school_name?.let {
                Text(
                    text = it,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,

                    )
            }
            Spacer(modifier = Modifier.padding(top = 6.dp))
            school.location?.let {
                Text(
                    text = it.substringBefore("("),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                )
            }
            school.phone_number?.let {
                Text(
                    text = it,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            school.website?.let {
                Text(
                    text = it,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
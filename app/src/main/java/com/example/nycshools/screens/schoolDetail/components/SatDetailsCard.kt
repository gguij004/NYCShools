package com.example.nycshools.screens.schoolDetail.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nycshools.datasource.remote.model.SatScore
import com.example.nycshools.screens.home.interactor.viewmodel.HomeScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SatDetailsCard(
    scores: SatScore?,
    viewModel: HomeScreenViewModel,
) {
    Spacer(modifier = Modifier.padding(top = 70.dp))
    if (scores != null) {
        scores.school_name?.let {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = it,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
    Spacer(modifier = Modifier.padding(top = 30.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 16.dp, vertical = 7.dp),
        shape = RoundedCornerShape(corner = CornerSize(18.dp)),
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(22.dp), verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "SAT",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.padding(top = 16.dp))
            if (scores != null) {
                Text("Math:" + scores.sat_math_avg_score)
                Text("Writing:" + scores.sat_writing_avg_score)
                Text("Reading:" + scores.sat_critical_reading_avg_score)
            }
        }
    }
}
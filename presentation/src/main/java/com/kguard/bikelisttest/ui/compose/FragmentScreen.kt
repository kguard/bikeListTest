package com.kguard.bikelisttest.ui.compose

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.kguard.bikelisttest.viewModel.MainViewModel
import com.kguard.domain.model.DomainBikeList
import com.kguard.domain.state.ResultState
import org.w3c.dom.Text

@Composable
fun FragmentScreen(modifier: Modifier = Modifier, mainViewModel: MainViewModel = viewModel()) {
//    mainViewModel.getBikeListStateFlow(1, 30)
//    mainViewModel.getBikeListFlow(1,5)
    mainViewModel.getBikeListWithResponseState(1, 5)
//    mainViewModel.getBikeList(1,5)

    //val bikeListLiveData by mainViewModel.bikeListLiveData.observeAsState()
    //val bikeListFlow by mainViewModel.bikeListFlow.observeAsState()
    val bikeListStateFlow by mainViewModel.bikeListStateFlow.collectAsState()
    Log.e("TAG", "FragmentScreen:bikeListStateFLow $bikeListStateFlow")
    val bikeListStateFlowWithResponse by mainViewModel.bikeListStateFlowWithResponse.collectAsState()
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .fillMaxSize()
            ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // RecyclerViewForBike(bikeList = bikeListStateFlow)
        when (bikeListStateFlowWithResponse) {
            is ResultState.Success -> RecyclerViewForBike(modifier = Modifier.fillMaxHeight(0.5f),color = Color.DarkGray,bikeList = (bikeListStateFlowWithResponse as ResultState.Success<List<DomainBikeList>>).data)
            is ResultState.Fail.Error -> Text(text = (bikeListStateFlowWithResponse as ResultState.Fail.Error).message)
            is ResultState.Fail.Exception -> Text(text = (bikeListStateFlowWithResponse as ResultState.Fail.Exception).message)
            is ResultState.Loading -> CircularProgressIndicator(
                color = Color.Blue,
                strokeWidth = 10.dp
            )
        }
        Divider(modifier = Modifier.padding(8.dp),color = Color.Magenta, thickness = 1.dp)
        when (bikeListStateFlowWithResponse) {
            is ResultState.Success -> RecyclerViewForBike(modifier = Modifier.fillMaxHeight(),color = Color.Cyan,bikeList = (bikeListStateFlowWithResponse as ResultState.Success<List<DomainBikeList>>).data)
            is ResultState.Fail.Error -> Text(text = (bikeListStateFlowWithResponse as ResultState.Fail.Error).message)
            is ResultState.Fail.Exception -> Text(text = (bikeListStateFlowWithResponse as ResultState.Fail.Exception).message)
            is ResultState.Loading -> CircularProgressIndicator(
                color = Color.Red,
                strokeWidth = 10.dp
            )
        }
    }


}

@Preview(showBackground = true)
@Composable
fun prevScreen() {
    FragmentScreen()
}
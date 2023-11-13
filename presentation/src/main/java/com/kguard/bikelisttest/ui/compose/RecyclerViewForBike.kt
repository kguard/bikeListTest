package com.kguard.bikelisttest.ui.compose

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kguard.bikelisttest.viewModel.MainViewModel
import com.kguard.domain.model.DomainBikeList

@Composable
fun RecyclerViewForBike(modifier: Modifier = Modifier,color: Color, bikeList: List<DomainBikeList>) {
    LazyColumn(modifier)
    {
        items(bikeList) {
            RecyclerViewItem(color = color,domainBikeList = it)
        }
    }
}

val listDomainTest = listOf<DomainBikeList>(DomainBikeList("0", "0", "0", "0", "0", "0", "0"),
    DomainBikeList("1", "1", "1", "1", "1", "1", "1"),
    DomainBikeList("2", "2", "2", "2", "2", "2", "2"),
    DomainBikeList("3", "3", "3", "3", "3", "3", "3"),
    DomainBikeList("4", "4", "4", "4", "4", "4", "4")
)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PrevRV()
{
    RecyclerViewForBike(color = Color.Black,bikeList = listDomainTest)
}

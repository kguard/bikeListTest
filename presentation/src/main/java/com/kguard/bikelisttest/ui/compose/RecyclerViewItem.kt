package com.kguard.bikelisttest.ui.compose

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import androidx.annotation.StringRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.RecyclerView
import com.kguard.bikelisttest.R
import com.kguard.domain.model.DomainBikeList

@Composable
@ReadOnlyComposable
private fun resources(): Resources {
    LocalConfiguration.current
    return LocalContext.current.resources
}

@Composable
@ReadOnlyComposable
private fun stringResource(@StringRes id: Int): String {
    val resources = resources()
    return resources.getString(id)
}

@Composable
fun RecyclerViewItem(modifier: Modifier = Modifier,color: Color,domainBikeList: DomainBikeList) {
    val Listpair = listOf(
        stringResource(R.string.rackTotCnt) to domainBikeList.rackToCnt,
        stringResource(R.string.stationName) to domainBikeList.stationName,
        stringResource(R.string.parkingBikeTotCnt) to domainBikeList.parkingBikeToCnt,
        stringResource(R.string.shared) to domainBikeList.shared,
        stringResource(R.string.stationLatitude) to domainBikeList.stationLatitude,
        stringResource(R.string.stationLongitude) to domainBikeList.stationLongitude,
        stringResource(R.string.stationId) to domainBikeList.stationId
    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .heightIn(max = 500.dp)
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .border(width = 1.dp, color = color, shape = RoundedCornerShape(7.dp)),
        userScrollEnabled = false
    ) {
        items(Listpair) {
            NameAndContents(name = it.first, content = it.second)
        }
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PrevItem() {
    RecyclerViewItem(color = Color.DarkGray, domainBikeList = DomainBikeList("0", "0", "0", "0", "0", "0", "0"))
}
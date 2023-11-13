package com.kguard.bikelisttest.ui.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NameAndContents(modifier: Modifier = Modifier, name: String,content: String){
    Row(modifier = modifier) {
        Text(text = name,modifier = Modifier.padding(8.dp),style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.ExtraBold), fontSize = 8.sp)
        Text(text = content,modifier = Modifier.padding(8.dp),style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.ExtraBold), fontSize = 8.sp)
    }

}
@Preview()
@Composable
fun PrevContent(){
    NameAndContents(name = " 실제 위치 표시 ", content ="어저고 저쩌고" )
}
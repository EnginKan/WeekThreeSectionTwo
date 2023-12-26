package com.yeditepe.weekthreesectiontwo.week13

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import com.yeditepe.weekthreesectiontwo.ui.theme.WeekThreeSectionTwoTheme

@ExperimentalMaterial3Api
@Composable
fun MathMainScreen(model: MathViewModel){
    var cevap = rememberSaveable{
            mutableStateOf(0)}
    var base= rememberSaveable{
        mutableStateOf("0")}
   var power= rememberSaveable{
        mutableStateOf("0")}
    Column(modifier = Modifier.fillMaxWidth()) {
        TextField(value ="" , onValueChange ={ base.value=it} )
        TextField(value ="" , onValueChange ={power.value=it } )
        Button(onClick = {
            model.calculate(base.value.toInt(),power.value.toInt())
        }) {

            Text(text = "Hesapla")
        }
        Text(text = "Result:${cevap.value}" )

    }
}
@ExperimentalMaterial3Api
@Preview
@Composable
fun MathMainScreenPreview(){
    val repo= MathRepository(LocalLifecycleOwner.current, LocalContext.current)
    val model= MathViewModel(repo)

    WeekThreeSectionTwoTheme {
        MathMainScreen(model = model)
    }
}
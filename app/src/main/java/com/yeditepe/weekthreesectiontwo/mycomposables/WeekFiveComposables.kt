package com.yeditepe.weekthreesectiontwo.mycomposables

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.yeditepe.weekthreesectiontwo.ui.theme.WeekThreeSectionTwoTheme
import java.math.BigDecimal

@Composable
fun MyButton(){
    var sayac= remember{ mutableStateOf(0)}
    var button_text= if(sayac.value==0) "Click Me" else "${sayac.value} times clicked"
    var isClicked= remember{mutableStateOf(false)}
    var color=if(isClicked.value) Color.Blue else Color.Red
    Button(colors= ButtonDefaults.buttonColors(color),
        onClick = {
                sayac.value++
                isClicked.value=!isClicked.value
         }) {
        Text(text = button_text)
    }

}

@Composable
fun CustomButton(
    color: Color,
    onPressed:()->Unit){
    Button(
        colors=ButtonDefaults.buttonColors(color),
        onClick = onPressed,
    ){
        Text(text = "Hesapla")
    }
}
@ExperimentalMaterial3Api
@Composable
fun TaxCard(){
    var text by rememberSaveable{mutableStateOf("")}
    var clicked by remember {
        mutableStateOf(false)
    }
    var button_color by remember {
        mutableStateOf(if (clicked) Color.Blue else Color.Red)
    }
    var result by rememberSaveable{ mutableStateOf("") }
    Card {
        TextField(value = text ,
            onValueChange ={text= it} )
        Text(text = result)
       /* Button(onClick = {
            result= vergiHesapla(text).toString()+" TL"
        }) {
            Text(text = "Hesapla")

        }*/
        CustomButton(color =button_color,
        onPressed = {
            result= vergiHesapla(text).toString()+" TL"
            clicked=!clicked

        })
    }

}

fun vergiHesapla(fiyat: String):BigDecimal{
    return fiyat.toBigDecimal()*BigDecimal(0.18);
}
@Preview
@ExperimentalMaterial3Api
@Composable
fun MyButtonPreview(){
   WeekThreeSectionTwoTheme {
       TaxCard()

   }
}
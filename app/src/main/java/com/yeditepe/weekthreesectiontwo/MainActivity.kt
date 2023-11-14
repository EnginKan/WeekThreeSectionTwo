package com.yeditepe.weekthreesectiontwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yeditepe.weekthreesectiontwo.ui.theme.WeekThreeSectionTwoTheme
import com.yeditepe.weekthreesectiontwo.weekseven.ScoreBoard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //MessageBox(message = "This is real part")
            WeekThreeSectionTwoTheme {
                ScoreBoard()
            }
        }
    }
}

data class Message(val msg: String,
                   val sender: String )
@Composable
fun MessageBox(message: Message){
  Row{
  Image(painter = painterResource(id =R.drawable.baseline_man_24 ) ,
      contentDescription ="",
       modifier= Modifier.size(24.dp))
   Column{
    Text(text=message.sender)
    Text(text = message.msg,
    color = Color.Cyan)
}}
}

@Preview
@Composable
fun MessageBoxPreview() {
    WeekThreeSectionTwoTheme {
        Surface {
            MessageBox(message = Message("Hello Android", "Engin"))
        }
    }
}



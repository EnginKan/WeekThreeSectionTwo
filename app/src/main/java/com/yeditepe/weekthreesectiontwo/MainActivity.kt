package com.yeditepe.weekthreesectiontwo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
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
                Surface(modifier = Modifier.fillMaxWidth()){
                    Text(text = "Main Activity")
                    Button(onClick = {
                        //Explicit Intent 1
                        /*Intent(applicationContext,SecondActivity::class.java).also{
                            startActivity(it)
                        }*/
                        //Explicit Intent 2nd Way
                        /*Intent(Intent.ACTION_MAIN).also {
                            it.`package`="com.google.android.youtube"
                            try{
                            startActivity(it)}
                            catch (e: ClassNotFoundException){
                                e.printStackTrace()
                            }

                        }*/
                        //Implicit Intent Example: Sending Email
                        Intent(Intent.ACTION_SEND).apply {
                            type="text/plain"
                            putExtra(Intent.EXTRA_EMAIL,"engin.kandiran@gmail.com")
                            putExtra(Intent.EXTRA_SUBJECT,"Eposta Konu")
                            putExtra(Intent. EXTRA_TEXT,"Content ")
                        }
                     }) {
                        Text(text = "Go to Second Activity")
                                            }

                }
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



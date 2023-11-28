package com.yeditepe.weekthreesectiontwo

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.yeditepe.weekthreesectiontwo.ui.theme.WeekThreeSectionTwoTheme

class SecondActivity :ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {

            WeekThreeSectionTwoTheme {
                Surface(modifier = Modifier.fillMaxWidth()){
                    Text(text = "Second Activity")
                    Button(onClick = {
                        val intent= Intent(applicationContext,MainActivity::class.java)
                        startActivity(intent)
                    }) {
                        Text(text = "Go to Main Activity")
                    }

                }
            }
        }
    }
}
package com.yeditepe.weekthreesectiontwo.mycomposables

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yeditepe.weekthreesectiontwo.R
import com.yeditepe.weekthreesectiontwo.ui.theme.WeekThreeSectionTwoTheme

data class Answer(var text: String, var image: Int)

@Composable
fun SurveyAnswer(answer: Answer, isSelected:Boolean=false){
    var selection = remember{mutableStateOf(isSelected)};
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(color = MaterialTheme.colorScheme.tertiary,
                shape = RoundedCornerShape(5.dp)),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ){

        Image(painter = painterResource(id = answer.image) ,
            contentDescription = "",
        modifier = Modifier.clip(CircleShape))
        Text(text=answer.text)
        RadioButton(selected = selection.value , onClick = {
            selection.value=!selection.value
        })

    }
}
@FirstPreview
@SecondPreview
@Composable
fun SurveyAnswerPreview(){

    WeekThreeSectionTwoTheme {
        Surface {
            var answer_list = listOf(
                Answer("This is an answer option 1", R.drawable.baseline_man_24),
                Answer("This is an answer option 2", R.drawable.baseline_man_24),
                Answer("This is an answer option 3", R.drawable.baseline_man_24),
                Answer("This is an answer option 4", R.drawable.baseline_man_24)
            )
            //val answer= Answer("This is an answer option ", R.drawable.baseline_man_24)
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(color = MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = "This is question text",
                    style = MaterialTheme.typography.bodyMedium

                )
                answer_list.forEach { answer ->
                    SurveyAnswer(answer,
                    isSelected = true)
                }
            }
        }
    }
}
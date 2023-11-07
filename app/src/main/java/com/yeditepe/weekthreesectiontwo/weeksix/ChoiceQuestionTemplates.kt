package com.yeditepe.weekthreesectiontwo.weeksix

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.excludeFromSystemGesture
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yeditepe.weekthreesectiontwo.R
import com.yeditepe.weekthreesectiontwo.ui.theme.WeekThreeSectionTwoTheme


data class Answer(var img_id: Int, var text:String)

@Composable
fun QuestionTemplate(text: String,options: List<Answer>){
    var selectedAnswer by remember{ mutableStateOf<Answer?>(null) }
    Column {

        Text(text = text)
        Spacer(modifier = Modifier.padding(5.dp))
        options.forEach {
            option->
            SingleChoice(selected = (selectedAnswer== option),
                answer = option,
            onPressed = {
                selectedAnswer= option
            })
        }
        Button(onClick = { /*TODO*/ },
            enabled = (selectedAnswer!=null)) {
            Text(text = "Next")
                    }

    }
}
@Composable
fun SingleChoice(selected:Boolean , answer: Answer, onPressed: ()->Unit){
    //var selected by remember{ mutableStateOf(false) }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier= Modifier
            .fillMaxWidth()
            .background(
                if (!selected) MaterialTheme.colorScheme.surface
                else MaterialTheme.colorScheme.tertiaryContainer
            ),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(painter = painterResource(id =answer.img_id ) ,
            contentDescription ="",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape))
        Text(text = answer.text,
        style=MaterialTheme.typography.bodyMedium
        )
        RadioButton(selected = selected,
            onClick = onPressed)
    }
}
@Preview
@Composable
fun SingleChoicePreview(){
    WeekThreeSectionTwoTheme {
        var options= mutableListOf<Answer>()
        for(i in 1..4){
         options.add(Answer(R.drawable.abdulkadir_ozbek,text="Option "+i))

    }
        QuestionTemplate(text = "This is question text", options = options)
}
}
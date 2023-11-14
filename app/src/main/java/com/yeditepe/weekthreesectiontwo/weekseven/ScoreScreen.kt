package com.yeditepe.weekthreesectiontwo.weekseven

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yeditepe.weekthreesectiontwo.R
import com.yeditepe.weekthreesectiontwo.ui.theme.WeekThreeSectionTwoTheme

data class ScoreCard(
    val teamAname:String,
    var teamAscore: Int=0,
    val teamBname: String,
    var teamBscore: Int=0
)
@Composable
fun TeamScore(teamname: String,
              teamscore: String="0",
                onPressed: ()->Unit){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.teamname,teamname),
        style=MaterialTheme.typography.bodyMedium)
        Box {
           Text(text = teamscore,
           style=MaterialTheme.typography.bodyLarge)
        }
        Button(onClick = onPressed) {
            Text(text = stringResource(id = R.string.increment_score))
               }
    }

}

@Composable
fun ScoreBoard(model: ScoreBoardViewModel= viewModel()){
    val scoreCard = model.scoreCard.collectAsState()
    Card(
        modifier = Modifier.fillMaxWidth()
    ){

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            TeamScore(teamname =scoreCard.value.teamAname,
            teamscore = scoreCard.value.teamAscore.toString(),
                onPressed = {model.updateScoreTable(true)
                    Log.d("PreviewScore",scoreCard.value.teamAscore.toString())
                }
            )
            Spacer(modifier = Modifier.padding(10.dp))
            TeamScore(teamname =scoreCard.value.teamBname,
                teamscore = scoreCard.value.teamBscore.toString(),
                onPressed = {model.updateScoreTable(false)
                    Log.d("PreviewScore",scoreCard.value.teamBscore.toString())
                }
            )
        }
    }
}

@Preview
@Composable
fun ScoreBoardPreview(){
    WeekThreeSectionTwoTheme {
        ScoreBoard()
    }


}
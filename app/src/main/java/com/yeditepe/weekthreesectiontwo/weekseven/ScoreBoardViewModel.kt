package com.yeditepe.weekthreesectiontwo.weekseven

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ScoreBoardViewModel(): ViewModel() {
    //real data
    private var _scoreCard=
        MutableStateFlow(ScoreCard("A", teamBname = "B"))



    //snaphot of real data
    val scoreCard: StateFlow<ScoreCard>
        get()=_scoreCard.asStateFlow()

    fun updateScoreTable(isTeamA: Boolean){
        _scoreCard.update{

            card ->
            if(isTeamA)
            card.copy(
            teamAscore = card.teamAscore++
            )
            else
                card.copy(
                    teamBscore = card.teamBscore++
                )

        }

    }
}
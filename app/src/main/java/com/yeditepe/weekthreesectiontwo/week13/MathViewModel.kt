package com.yeditepe.weekthreesectiontwo.week13

import androidx.lifecycle.ViewModel

class MathViewModel(val repository: MathRepository): ViewModel() {

    fun calculate(base: Int, power: Int): Int{

        return repository.calculate(base,power)
    }
}
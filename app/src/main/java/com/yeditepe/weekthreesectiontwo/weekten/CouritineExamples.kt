package com.yeditepe.weekthreesectiontwo.weekten

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.coroutines.async
import kotlin.system.measureTimeMillis

suspend fun functionOne(){
    println("Start of F1")
    delay(3000)
    println("End of F1")
}
suspend fun functionTwo(){
    println("Start of F2")
    delay(3000)
    println("End of F2")
}
suspend fun functionThree(): Int{
    println("Start of F3")
    delay(3000)
    println("End of F3")
    return 3
}
suspend fun functionFour(): Int{
    println("Start of F4")
    delay(3000)
    println("End of F4")
    return 4
}
fun main(){
   val elapse_time= measureTimeMillis {
        runBlocking {
            functionOne()
            functionTwo()
        }
    }
    println("Elapsed time:${elapse_time/1000}")
    println("Part 2 --------")
    runBlocking {
    val elapse_time2= measureTimeMillis {

        launch{
            functionOne()
            functionTwo()
        }

          }
        println("Elapsed time:${elapse_time2/1000}")
    }
    println("Part 3 :----------")
 runBlocking {measureTimeMillis {
     val one = async { functionThree() }
     val two = async { functionFour() }
     println("The answer is ${one.await() + two.await()}")
         }
    }

        }




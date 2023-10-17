package com.yeditepe.weekthreesectiontwo.functions

fun main(){
    val names_list = listOf("engin","ece","ahmet","erkan","ayse")
    val sayilar = listOf(1,2,3,5,4)
    val my_func: (Int,Int)->Int = {sayi1:Int ,sayi2: Int -> sayi1+sayi2}
    val multiplication= {sayi1:Int,sayi2: Int-> sayi1*sayi2}
    println(computation(5,12,my_func))
    println(computation(20,5,multiplication))
    //calling higher order function with function reference
    println(computation(10,6,::toplama))
    println(computation(50,3){int1: Int,int2: Int->int1*int2})

    val sentence= "cok mu cok guzel bir gun"

    println(textmanipulator(sentence,"cok", manipulator = ::findAndReplace))

    val filtered_names = names_list.filter{ it[0]=='e'}
    val ciftler = sayilar.asSequence().filter { it%2==0 }
    println(filtered_names)
    println(ciftler)
    println(ciftler.toList())
}
//Higher order function
fun computation(args1: Int, args2: Int, f: (Int,Int)->Int): Int{

    return f(args1,args2)
}

fun toplama(sayi1: Int, sayi2: Int)= sayi1+sayi2

fun textmanipulator(sentence: String,
                        old: String,
                        new: String= " ",
                        manipulator: (String, String,String)->String):String{

    return manipulator(sentence,old,new)
}
fun findAndReplace(sentence: String, old: String, new: String):String{
    return sentence.replace(old,new)
}
fun findAndDelete(sentence: String, old: String, new: String= " "):String{
    return sentence.replace(old,new)
}

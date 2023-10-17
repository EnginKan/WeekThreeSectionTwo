package com.yeditepe.weekthreesectiontwo.classesandobject

fun main(){
    val student1 = Student()

    println(student1.name)

    val student2= StudentV3()
    val student3= StudentV3(name="Engin")
    val student4= StudentV3(gpa = 2.0)
    val student5= StudentV3("Burak",4.0)
    val student6= StudentV4()
    println(StudentV4.university)
    StudentV4.defaultSummary()
    println(student6)

    val grad= GraduateStudent("cs","H.Bingol")
    println(grad)

}
package com.yeditepe.weekthreesectiontwo.classesandobject

class Student {
    var name: String ="name"
    var gpa: Double = -1.0
}

class StudentV1(name: String, gpa: Double){
    var name = name
    var gpa= gpa
}

class StudentV2(var name: String, var gpa: Double )

class StudentV3(var name: String ="name", var gpa: Double=-1.0)

open class StudentV4(var name: String ="name", var gpa: Double=-1.0){
    var department: String = "cs"
        get()=field.uppercase()
        set(value) {
            field=value.uppercase()
        }
    init {
        println("Student:$name GPA:$gpa Dep:$department")
    }

    constructor(department: String):this(){
        this.department= department
    }

    constructor(isim :String,gpa:Double, department: String):
            this(name=isim, gpa = gpa){
            this.department=department
    }

    companion object{
        val university = "Yeditepe"
        fun defaultSummary():Unit{
            println("Universtiy: $university")
        }
    }
}

//subclass

class GraduateStudent(department: String,
                      var advisor: String): StudentV4(department){

    override fun toString(): String {
        return "Name: $name \n Dep: $department \n Advisor: $advisor"
    }
                      }













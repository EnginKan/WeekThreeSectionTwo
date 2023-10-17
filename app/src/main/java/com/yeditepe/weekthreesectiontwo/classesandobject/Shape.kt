package com.yeditepe.weekthreesectiontwo.classesandobject

abstract class Shape {

    abstract val area: Double
    abstract val circumfrance: Double

    override fun toString(): String {
        return "Area: $area Circumfrance:$circumfrance"
    }
   }

class Circle(val radius: Double): Shape(),Computable{
    override val area: Double
        get() = Math.PI*radius*radius

    override val circumfrance: Double
        get() = 2*Math.PI*radius

    override fun compute(): Double {
        return area
    }
}

abstract class Concave : Shape()

interface Computable{
    abstract fun compute(): Double
}

data class Movie(val name: String, val director: String)
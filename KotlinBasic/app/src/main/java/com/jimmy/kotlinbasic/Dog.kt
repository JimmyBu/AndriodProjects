package com.jimmy.kotlinbasic

class Dog (val name: String, val breed: String, var age: Int) {

    init {
        bark(name)
    }

    fun bark(name: String){
        println("$name: Woof!")
    }
}
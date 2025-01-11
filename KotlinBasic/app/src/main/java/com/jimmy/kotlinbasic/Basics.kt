package com.jimmy.kotlinbasic

data class CoffeeDetails(
    val sugarCount: Int,
    val name: String,
    val size: String,
    val creamAmount: Int
)

/*
 */

fun main(){

    val constantNumber:Long = 9
    var mutableString = "Jimmy"

    println(constantNumber)
    println(mutableString)

    val pi = 3.1415926535f
    println(pi)

    var age : UShort = 35u
    println(age)

    val myTrue: Boolean = true
    val myFalse: Boolean = false

    println(myTrue || myFalse)
    println(myTrue && myFalse)
    println(!myTrue)

    val myChar = '\u00AE'
    println(myChar)

    var name = "Jmy"
    name = "Franklin IS here instead"
    println(name.lowercase() + " of Jimmy")


    var a = 35
    println("Please enter your age as a whole number")
    a = readln().toInt()

    if (a >= 18) {
        println("You can go into the club")
    }else{
        println("You are too young to go into the club")
    }

    var count = 0
    while (count < 10){
        count ++
    }

    var res = add(3,4)
    println(res)

    var Daisy = Dog("Daisy", "Dwarf poodle", 2)
    println("${Daisy.name} is a ${Daisy.breed} and it is ${Daisy.age} years old")
    println("A year passed")
    Daisy.age += 1
    println("Now ${Daisy.name} is ${Daisy.age} years old")


    val coffeeForJimmy = CoffeeDetails(0, "Jimmy", "xxl", 0)
    makeCoffee(coffeeForJimmy)

    // Immutable List - cannot add items after the initialization
    // val shoppingList = listOf("Processor", "RAM", "Graphics Card", "SSD")
    // Mutable List - you can add items later and modify
    var shoppingList = mutableListOf("Processor", "RAM", "Graphics Card RTX 3060", "SSD")
    // Adding items to list
    shoppingList.add("Cooling System")
    shoppingList.remove("Graphics Card RTX 3060")
    shoppingList.add("Graphics Card RTX 4090")

    println(shoppingList)
    shoppingList.set(3, "Water Cooling")

    val hasRam = shoppingList.contains("RAM") // return a boolean

    for(item in 0 until shoppingList.size){
       println("item ${shoppingList[item]} is at index ${item}" )
    }
}

fun makeCoffee(coffeeDetails: CoffeeDetails){
    println("Coffee with ${coffeeDetails.sugarCount} spoons of sugar for ${coffeeDetails.name}")
}

fun add(num1:Int, num2:Int):Int{
    return num1+num2
}


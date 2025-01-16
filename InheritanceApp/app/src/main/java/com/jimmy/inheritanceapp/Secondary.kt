package com.jimmy.inheritanceapp

// Derived Class of Base Class
// Inherits from base class
open class Secondary : BaseClass() {
    override fun role(){
        // super.role()
        println("Knight of the House of Base Class")
    }
}
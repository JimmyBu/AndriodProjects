package com.jimmy.inheritanceapp

class OffSpring : Secondary(), Archery, Singer {
    override fun archery() {
        super.archery()
        println("Archery skills enhanced by OffSpring")
    }

    override fun sing() {
        super.sing()
        println("Singing skills enhanced by OffSpring")
    }
}
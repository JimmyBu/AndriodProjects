package com.jimmy.bankaccountprogram

fun main(){

    val denisesBankAccount = BankAccount("Denis", 1300.08)

    denisesBankAccount.deposit(200.00)
    denisesBankAccount.withdraw(1200.00)
    denisesBankAccount.deposit(3000.00)
    denisesBankAccount.deposit(2000.00)
    denisesBankAccount.withdraw(3333.13)
    denisesBankAccount.displayTransactionHistory()
    println(denisesBankAccount.balance)

}
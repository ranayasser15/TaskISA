package com.example.agecalculator.Presenter

import com.example.agecalculator.Model.User
import java.util.Calendar

class CalculatorPresnter(private val view: View) : IPresenter {


    override fun calculateAge(name: String, age: String) {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val ageInYear = currentYear - (age.toInt())
        val ageInMonths = ageInYear * 12
        val ageInDays = ageInYear * 365
        view.getInfo(User(name, ageInYear, ageInMonths, ageInDays))
    }


    interface View {
        fun getInfo(user: User)
    }
}
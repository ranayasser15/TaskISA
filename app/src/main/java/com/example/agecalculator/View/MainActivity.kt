package com.example.agecalculator.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.agecalculator.Model.User
import com.example.agecalculator.Presenter.CalculatorPresnter
import com.example.agecalculator.Presenter.IPresenter
import com.example.agecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CalculatorPresnter.View {

    lateinit var binding: ActivityMainBinding

    lateinit var calculatorPresnter: IPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculatorPresnter = CalculatorPresnter(this)

        onClick()
    }

    private fun onClick() {
        binding.btnSubmit.setOnClickListener {
            val name = binding.etName.text.toString()
            val age = binding.etAge.text.trim().toString()
            validation(name, age)
        }
    }

    private fun validation(name: String, age: String) {
        if (name.isEmpty()) {
            binding.etName.error = "Enter Data"
        } else if (age.isEmpty()) {
            binding.etAge.error = "Enter Data"

        } else {
            calculatorPresnter.calculateAge(name, age)

        }
    }

    override fun getInfo(user: User) {
        binding.tvTitle.text =
            "Dear ${user.userName},\n You have been alive for ${user.userAgeInYears} years which is ${user.userAgeInMonths} months which is also ${user.userAgeInDays} days, Thats so long dude"
    }
}
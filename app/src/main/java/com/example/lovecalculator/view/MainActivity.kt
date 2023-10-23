package com.example.lovecalculator.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import com.example.lovecalculator.LoveModel
import com.example.lovecalculator.ResultActivity
import com.example.lovecalculator.RetrofitService
import com.example.lovecalculator.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity(), MainView {

    lateinit var binding: ActivityMainBinding
    val presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        presenter.attachView(this)
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                presenter.getData(etFirstName.text.toString(), etSecondName.text.toString())
            }
        }

    }

    override fun changeScreen(loveModel: LoveModel) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("key", loveModel)
        startActivity(intent)
    }
}


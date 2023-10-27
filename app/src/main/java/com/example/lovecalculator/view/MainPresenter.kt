package com.example.lovecalculator.view

import android.util.Log
import com.example.lovecalculator.LoveModel
import com.example.lovecalculator.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter {

    private val api = RetrofitService().api
    private val TAG = "ololo"
    private lateinit var view: MainView

    fun getData(firstName: String, secondName: String) {
        api.getPercentage(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    val model = response.body()
                    model?.let {
                        App.appDatabase.getLoveDao().insert(it)
                        view.changeScreen(it)
                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

    fun attachView(view: MainView) {
        this.view = view
    }

}
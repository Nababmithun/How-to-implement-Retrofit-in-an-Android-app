package com.example.howtoimplementretrofitinanandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.howtoimplementretrofitinanandroidapp.Model.Country
import com.example.howtoimplementretrofitinanandroidapp.Network.CountriesService
import kotlinx.android.synthetic.main.activity_main.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        CountriesService().getCountries().enqueue(object: Callback<List<Country>> {
            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                result.text = "Failure!"
            }

            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
//                result.text = "Received ${response.body()?.size} results"
                result.visibility = View.GONE
                displayCountries(response.body()?.subList(0, 20))
            }

        })
    }

    private fun displayCountries(result: List<Country>?) {
        result?.let {
            for (country in it) {
                val view = ImageView(this)
                Glide.with(this)
                    .load(country.flag)
                    .into(view)
                listLayout.addView(view)
            }
        }
    }
}
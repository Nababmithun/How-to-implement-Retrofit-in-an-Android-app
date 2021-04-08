package com.example.howtoimplementretrofitinanandroidapp.Network

import com.example.howtoimplementretrofitinanandroidapp.Model.Country
import retrofit2.Call
import retrofit2.http.GET

interface CountriesApi {

    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountries(): Call<List<Country>>
}
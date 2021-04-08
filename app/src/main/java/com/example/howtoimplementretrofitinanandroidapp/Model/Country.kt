package com.example.howtoimplementretrofitinanandroidapp.Model

import com.google.gson.annotations.SerializedName

class Country (

               @SerializedName("name")
               val countryName: String?,

               @SerializedName("flagPNG")
               val flag: String?


 )


package com.choota.myapplication.services.api

import com.choota.myapplication.helpers.Const
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Modifier

object ServiceGenerator {
    fun <S> createService(serviceClass: Class<S>): S {

        val gson = GsonBuilder()
            .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
            .setPrettyPrinting()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .client(LogInspector.client())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(serviceClass)
    }
}

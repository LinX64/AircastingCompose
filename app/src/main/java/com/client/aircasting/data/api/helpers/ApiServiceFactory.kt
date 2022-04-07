package com.client.aircasting.data.api.helpers

import android.util.Base64
import com.client.aircasting.BuildConfig
import com.client.aircasting.data.api.services.ApiService
import com.client.aircasting.util.Settings
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class ApiServiceFactory(private val mSettings: Settings) {
    fun get(interceptors: List<Interceptor>): ApiService {
        val logging = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logging.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logging.level = HttpLoggingInterceptor.Level.BASIC
        }

        val httpClientBuilder = OkHttpClient.Builder()
        httpClientBuilder.addInterceptor(logging)
        interceptors.forEach { interceptor -> httpClientBuilder.addInterceptor(interceptor) }
        val httpClient = httpClientBuilder
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .baseUrl(baseUrl())
            .build()

        return retrofit.create(ApiService::class.java)
    }

    fun get(username: String, password: String): ApiService {
        val credentialsEncoded = encodedCredentials(username, password)
        val authInterceptor = BasicAuthInterceptor(credentialsEncoded)
        return get(listOf(authInterceptor))
    }

    fun get(authToken: String): ApiService {
        val credentialsEncoded = encodedCredentials(authToken, "X")
        val authInterceptor = BasicAuthInterceptor(credentialsEncoded)
        return get(listOf(authInterceptor))
    }

    protected open fun baseUrl(): HttpUrl {
        val urlSuffix = "/"
        val baseUrl = mSettings.getBackendUrl() + ":" + mSettings.getBackendPort()

        return if (mSettings.getBackendUrl()?.last()?.toString() == urlSuffix) {
            baseUrl.toHttpUrl()
        } else {
            (baseUrl + urlSuffix).toHttpUrl()
        }
    }

    private fun encodedCredentials(username: String, password: String): String {
        val credentials = "${username}:${password}"
        val encodedCredentials = Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)
        return "Basic $encodedCredentials"
    }
}
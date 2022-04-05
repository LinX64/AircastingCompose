package com.client.aircasting.data.api

import android.util.Base64
import com.client.aircasting.BuildConfig
import com.client.aircasting.model.Movie
import com.client.aircasting.util.Settings
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import pl.llp.aircasting.networking.responses.UserResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface ApiService {

    @GET("movielist.json")
    suspend fun getMovies() : List<Movie>

    @GET("/api/user.json")
    fun login(): Call<UserResponse>

}

open class ApiServiceFactory(private val mSettings: Settings) {
    private val READ_TIMEOUT_SECONDS: Long = 60
    private val CONNECT_TIMEOUT_SECONDS: Long = 60

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
            .readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .baseUrl(baseUrl())
            .build()

        return retrofit.create(ApiService::class.java)
    }

    fun get(username: String, password: String): ApiService {
        val credentialsEncoded =
            encodedCredentials(
                username,
                password
            )
        val authInterceptor =
            AuthenticationInterceptor(
                credentialsEncoded
            )

        return get(
            listOf(authInterceptor)
        )
    }

    fun get(authToken: String): ApiService {
        val credentialsEncoded =
            encodedCredentials(
                authToken,
                "X"
            )
        val authInterceptor =
            AuthenticationInterceptor(
                credentialsEncoded
            )

        return get(
            listOf(authInterceptor)
        )
    }

    protected open fun baseUrl() : HttpUrl {
        val URL_SUFFIX = "/"
        val baseUrl = mSettings.getBackendUrl() + ":" + mSettings.getBackendPort()

        return if (mSettings.getBackendUrl()?.last()?.equals(URL_SUFFIX) == true) {
            baseUrl.toHttpUrl()
        } else {
            (baseUrl + URL_SUFFIX).toHttpUrl()
        }
    }

    private fun encodedCredentials(username: String, password: String): String {
        val credentials = "${username}:${password}"
        val encodedCredentials = Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)
        return "Basic $encodedCredentials"
    }

}

class AuthenticationInterceptor(private val authToken: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val builder = original.newBuilder()
            .header("Authorization", authToken)

        val request = builder.build()
        return chain.proceed(request)
    }
}
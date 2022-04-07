package com.client.aircasting.di

import com.client.aircasting.data.api.helpers.ApiServiceFactory
import com.client.aircasting.util.Settings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

open class WebServerFactory

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun providesApiServiceFactory(
        settings: Settings
    ): ApiServiceFactory = ApiServiceFactory(settings)

}



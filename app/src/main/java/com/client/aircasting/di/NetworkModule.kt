package com.client.aircasting.di

import android.content.Context
import com.client.aircasting.data.api.helpers.ApiServiceFactory
import com.client.aircasting.util.Settings
import com.client.aircasting.util.exceptions.ErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun providesApiServiceFactory(settings: Settings): ApiServiceFactory =
        ApiServiceFactory(settings)

    @Provides
    @Singleton
    fun providesErrorHandler(@ApplicationContext appContext: Context): ErrorHandler =
        ErrorHandler(appContext)

}



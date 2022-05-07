package com.client.aircasting.di.modules

import com.client.aircasting.data.api.helpers.ApiServiceFactory
import com.client.aircasting.util.Settings
import com.client.aircasting.util.exceptions.ErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

open class WebServerFactory

@Module
@InstallIn(SingletonComponent::class)
open class ApiModule {
    @Provides
    @Singleton
    open fun providesMockWebServerFactory(): WebServerFactory = WebServerFactory()

    @Provides
    @Singleton
    open fun providesApiServiceFactory(
        settings: Settings,
        webServerFactory: WebServerFactory
    ): ApiServiceFactory = ApiServiceFactory(settings)
}

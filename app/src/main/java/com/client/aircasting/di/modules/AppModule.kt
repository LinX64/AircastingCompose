package com.client.aircasting.di.modules

import android.content.Context
import com.client.aircasting.util.exceptions.ErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesErrorHandler(@ApplicationContext appContext: Context): ErrorHandler =
        ErrorHandler(appContext)
}

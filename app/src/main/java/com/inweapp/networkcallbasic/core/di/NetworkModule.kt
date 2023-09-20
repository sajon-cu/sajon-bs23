package com.inweapp.networkcallbasic.core.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.inweapp.networkcallbasic.core.data.source.api.RepositoryDataSource
import com.inweapp.networkcallbasic.core.data.source.remote.repositories.RepositoryRemoteDataSource
import com.inweapp.networkcallbasic.core.data.source.remote.repositories.RepositoryService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by sajon on 9/20/23
 * Copyright (c) 2023 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideGson() =
        GsonBuilder().create()

    @Provides
    @Singleton
    fun provideLoginInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(50, TimeUnit.SECONDS)
            .writeTimeout(50, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideAccountService(retrofit: Retrofit): RepositoryService {
        return retrofit.create(RepositoryService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepositoryRemoteDataSource(service: RepositoryService): RepositoryDataSource =
        RepositoryRemoteDataSource(service)
}
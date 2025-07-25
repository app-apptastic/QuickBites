package com.apptastic.quickbites.di

import android.content.Context
import com.apptastic.quickbites.BuildConfig
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    val BASE_URL = BuildConfig.BASE_URL

    @Provides // This tells Hilt: "Here's how to provide a Moshi instance.", without this Hilt won't know how to create a Moshi instance when it's needed.
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun providesOkHttpClient(@ApplicationContext context: Context): OkHttpClient = OkHttpClient.Builder()
        .apply {
            if(BuildConfig.DEBUG) {
                val logger = HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
                addInterceptor(logger)
                addInterceptor(ChuckerInterceptor.Builder(context).build())
            }
        }
        .build()

    @Provides
    @Singleton
    fun providesRetrofitInstance(moshi: Moshi, client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    @Singleton
    fun providesQuickBitesApiService(retrofit: Retrofit): QuickBitesApiService {
        return retrofit.create(QuickBitesApiService::class.java)
    }
}
package com.mrkevin574.starwars.di

import com.mrkevin574.starwars.data.repository.StarWarsProvider
import com.mrkevin574.starwars.util.BASE_URL_STAR_WARS_API
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL_STAR_WARS_API)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @Singleton
    @Provides
    fun provideStarWarsProvider(retrofit: Retrofit) : StarWarsProvider
    {
        return retrofit.create(StarWarsProvider::class.java)
    }


}
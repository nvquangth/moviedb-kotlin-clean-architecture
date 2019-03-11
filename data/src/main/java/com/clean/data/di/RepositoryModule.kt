package com.clean.data.di

import android.content.Context
import androidx.room.Room
import com.clean.data.Constants
import com.clean.data.MovieRepositoryImpl
import com.clean.data.local.db.AppDatabase
import com.clean.data.local.pref.PrefHelper
import com.example.domain.repository.MovieRepository
import com.google.gson.Gson
import org.koin.dsl.module.module
import org.koin.experimental.builder.create
import org.koin.experimental.builder.singleBy

val repositoryModule = module {
    single { createDatabaseName() }
    single { createAppDatabase(get(), get()) }
    single { createMovieDao(get()) }
    single { create<PrefHelper>() }
    single { Gson() }
    singleBy<MovieRepository, MovieRepositoryImpl>()
}

fun createDatabaseName() = Constants.DATABASE_NAME

fun createAppDatabase(dbName: String, context: Context) =
    Room.databaseBuilder(context, AppDatabase::class.java, dbName).build()

fun createMovieDao(appDatabase: AppDatabase) = appDatabase.movieDao()
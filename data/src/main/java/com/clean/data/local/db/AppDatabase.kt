package com.clean.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.clean.data.local.db.dao.MovieDao
import com.clean.data.model.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
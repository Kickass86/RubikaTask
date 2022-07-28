package com.fapna.rubikatask.di

import android.content.Context
import androidx.room.Room
import com.fapna.rubikatask.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val DATABASE_NAME = "robino-db"

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
        .createFromAsset("database/myapp.db")
        .build()

    @Singleton
    @Provides
    fun providePostDao(db: AppDatabase) = db.postDao()
}
package com.fapna.rubikatask.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fapna.rubikatask.model.CommentEntity
import com.fapna.rubikatask.model.Converters
import com.fapna.rubikatask.model.PostEntity

@Database(entities = [PostEntity::class, CommentEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao
    abstract fun commentDao(): CommentDao

}
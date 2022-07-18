package com.fapna.rubikatask.db

import androidx.room.*
import com.fapna.rubikatask.model.CommentEntity

@Dao
interface CommentDao {
    @Query("SELECT * FROM comment where post_id = :id")
    fun getComments(id: Int): List<CommentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(comments: CommentEntity)
}
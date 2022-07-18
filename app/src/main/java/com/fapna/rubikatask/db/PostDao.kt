package com.fapna.rubikatask.db

import androidx.room.*
import com.fapna.rubikatask.model.PostEntity

@Dao
interface PostDao {
    @Query("SELECT * FROM post ")
    fun getPosts(): List<PostEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(posts: List<PostEntity>)

    @Query("UPDATE post SET like_count = like_count + 1 WHERE id = :id")
    fun incrementLikes(id: Int)

    @Query("UPDATE post SET like_count = like_count - 1 WHERE id = :id")
    fun decrementLikes(id: Int)
}
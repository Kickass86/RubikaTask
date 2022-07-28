package com.fapna.rubikatask.db

import androidx.room.*
import com.fapna.rubikatask.model.PostEntity

@Dao
interface PostDao {
    @Query("SELECT * FROM post ")
    suspend fun getPosts(): List<PostEntity>

    @Query("SELECT * FROM post WHERE id = :id")
    suspend fun getPost(id: Int): PostEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<PostEntity>)

    @Query("UPDATE post SET is_liked = 1, like_count = like_count + 1 WHERE id = :id")
    suspend fun likePost(id: Int)

    @Query("UPDATE post SET is_liked = 0, like_count = like_count - 1 WHERE id = :id")
    suspend fun unlikePost(id: Int)
}
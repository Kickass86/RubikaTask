package com.fapna.rubikatask.data

import com.fapna.rubikatask.db.AppDatabase
import com.fapna.rubikatask.model.PostEntity
import javax.inject.Inject

class Repository @Inject constructor(
    private val db: AppDatabase
) {
    suspend fun getPosts(): List<PostEntity> = db.postDao().getPosts()

    suspend fun getPost(id: Int): PostEntity = db.postDao().getPost(id)

    suspend fun likePost(id: Int) = db.postDao().likePost(id)

    suspend fun unlikePost(id: Int) = db.postDao().unlikePost(id)

}
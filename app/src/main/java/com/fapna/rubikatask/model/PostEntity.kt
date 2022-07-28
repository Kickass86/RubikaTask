package com.fapna.rubikatask.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "post")
data class PostEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val caption: String,
    val name: String,
    val time: String,
    val picture: String,
    @ColumnInfo(name = "is_liked") var isLiked: Boolean = false,
    @ColumnInfo(name = "view_count") val viewCount: Int,
    @ColumnInfo(name = "like_count") var likeCount: Int

)

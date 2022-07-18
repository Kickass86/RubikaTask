package com.fapna.rubikatask.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "post")
data class PostEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val content: String,
    val name: String,
    val time: Date,
    val picture: String,
    val viewCount: Int,
    val caption: String,
    @ColumnInfo(name = "like_count") val likeCount: Int

)

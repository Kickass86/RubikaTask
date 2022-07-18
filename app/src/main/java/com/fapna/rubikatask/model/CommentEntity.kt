package com.fapna.rubikatask.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import java.util.*


@Entity(
    tableName = "comment",
    foreignKeys = [ForeignKey(entity = PostEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("id"),
        onDelete = ForeignKey.NO_ACTION)]
)
data class CommentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val content: String,
    val time: Date,
    val name: String,
    @ColumnInfo(name = "post_id") val postId: Long
)

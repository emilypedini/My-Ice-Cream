package com.example.myicecream.data.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "likes",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = PostEntity::class,
            parentColumns = ["idPost"],
            childColumns = ["postId"],
            onDelete =  ForeignKey.CASCADE
        )
    ],
    indices = [
        //impedisce di mettere tra i preferiti lo stesso post più volte
        Index(value = ["userId", "postId"], unique = true)
    ]
)
data class LikeEntity(
    @PrimaryKey(autoGenerate = true)
    val likeId: Int = 0,

    val userId: Int,
    val postId: Int
)

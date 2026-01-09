package com.example.myicecream.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LikeDAO {

    @Insert
    suspend fun addLike(like: LikeEntity)

    @Query("DELETE FROM likes WHERE userId = :userId AND postId = :postId")
    suspend fun removeLike(userId: Int, postId: Int)

    @Query("SELECT EXISTS(SELECT 1 FROM likes WHERE userId = :userId AND postId = :postId)")
    suspend fun isPostLiked(userId: Int, postId: Int): Boolean

}
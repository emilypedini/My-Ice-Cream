package com.example.myicecream.data.repositories

import com.example.myicecream.data.database.LikeDAO
import com.example.myicecream.data.database.LikeEntity
import com.example.myicecream.data.database.PostDAO
import com.example.myicecream.data.database.UserDAO

class LikeRepository(private val likeDAO: LikeDAO,
    private val notificationRepository: NotificationRepository,
    private val postDAO: PostDAO,
    private val userDAO: UserDAO) {

    suspend fun likePost(userId: Int, postId: Int) {
        likeDAO.addLike(LikeEntity(userId = userId, postId = postId))

        val postOwnerId = postDAO.getPostOwner(postId)

        if (postOwnerId != userId) {

            val likerName = userDAO.getName(userId)

            notificationRepository.notifyUser(
                userId = postOwnerId,
                title = "Nuovo like ❤️",
                message = "$likerName ha messo mi piace a un tuo post"
            )
        }
    }
}
package com.example.myicecream.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myicecream.data.database.LikeDAO
import com.example.myicecream.data.database.PostWithUser
import com.example.myicecream.data.repositories.LikeRepository
import com.example.myicecream.data.repositories.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel (
    private val postRepository: PostRepository,
    private val likeRepository: LikeRepository,
    private val likeDAO: LikeDAO,
    private val loggedUserId: Int
): ViewModel() {

    private val _posts = MutableStateFlow<List<PostWithUser>>(emptyList())
    val posts = _posts.asStateFlow()

    fun loadPosts() {
        viewModelScope.launch {
            _posts.value = postRepository.getAllPosts()
        }
    }

    suspend fun isPostLiked(postId: Int):Boolean {
        return likeDAO.isPostLiked(loggedUserId, postId)
    }

    fun toggleLike(postId: Int, isLiked: Boolean) {
        viewModelScope.launch {
            if(isLiked) {
                likeDAO.removeLike(loggedUserId, postId)
            } else {
                likeRepository.likePost(loggedUserId, postId)
            }
        }
    }
}
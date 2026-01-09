package com.example.myicecream.ui.screen.notifications

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myicecream.data.database.NotificationEntity
import com.example.myicecream.data.repositories.NotificationRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NotificationsViewModel(private val notificationRepository: NotificationRepository,
    private val userId: Int): ViewModel() {

    private val _expandedNotStates = mutableMapOf<Int, Boolean>()
    val expandedNotStates: Map<Int, Boolean> = _expandedNotStates

    val notifications = notificationRepository.getNotifications(userId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())


    fun onNotificationClick(notification: NotificationEntity) {
        val current = _expandedNotStates[notification.idNot] ?: false
        val newState = !current
        _expandedNotStates[notification.idNot] = newState

        if(!notification.isRead && newState) {
            viewModelScope.launch {
                notificationRepository.markNotiAsRead(notification.idNot)
            }
        }
    }

    fun deleteNotification(notification: NotificationEntity) {
        viewModelScope.launch {
            notificationRepository.deleteNotification(notification.idNot)
        }
    }
}
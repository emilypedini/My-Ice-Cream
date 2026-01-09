package com.example.myicecream.ui.screen.notifications

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myicecream.data.database.NotificationEntity

@Composable
fun NotificationItem(
    notification: NotificationEntity,
    isExpanded: Boolean,
    onClick: () -> Unit) {

    Column(modifier = Modifier.fillMaxWidth().clickable {
        onClick()
    }.padding(16.dp)) {
        Text( text = notification.title,
            fontWeight = if (!notification.isRead) FontWeight.Bold else FontWeight.Normal,
            fontSize = 18.sp)

        AnimatedVisibility(visible = isExpanded ) {
            Text( text = notification.message,
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        Divider(modifier = Modifier.padding(top = 12.dp))
    }
}
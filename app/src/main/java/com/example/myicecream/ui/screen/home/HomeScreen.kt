package com.example.myicecream.ui.screen.home


import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myicecream.ui.screen.notifications.NotificationsViewModel
import com.example.myicecream.ui.screen.posts.PostItem
import androidx.compose.foundation.lazy.items

@Composable
fun HomeScreen( navController: NavController,
                notificationsViewModel: NotificationsViewModel,
                homeViewModel: HomeViewModel) {

    val unreadCount by notificationsViewModel.unreadNotificationCount.collectAsState()
    val posts by homeViewModel.posts.collectAsState()

    LaunchedEffect(Unit) {
        homeViewModel.loadPosts()
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Nuvole di Gelato",
                modifier = Modifier.align(Alignment.TopCenter),
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.primary
            )

            IconButton(
                onClick = { navController.navigate("notifications") }
            ) {
                Icon(Icons.Default.Send, contentDescription = null)
            }
        }
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(posts, key = { it.postId }) {
            post -> PostItem(
                post = post,
                homeViewModel = homeViewModel
            )
        }
    }
}

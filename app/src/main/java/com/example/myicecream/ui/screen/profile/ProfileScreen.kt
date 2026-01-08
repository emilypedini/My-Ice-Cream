package com.example.myicecream.ui.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.MaterialTheme

@Composable
fun ProfileScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Profilo",
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colorScheme.onBackground
            )
            IconButton(onClick = { navController.navigate("settings") }) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Impostazioni",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        }

        Spacer(modifier = Modifier.height(1.dp))

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                "Profilo utente",
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

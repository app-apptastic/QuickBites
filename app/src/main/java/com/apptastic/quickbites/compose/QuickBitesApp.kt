package com.apptastic.quickbites.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.apptastic.quickbites.MainApplication
import com.apptastic.quickbites.compose.components.Header1
import kotlinx.coroutines.flow.collectLatest

@Composable
fun QuickBitesApp() {
    val context = LocalContext.current
    val app = context.applicationContext as MainApplication

    val networkManager = app.networkManager
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) { // Use Unit as key to run once when the composable enters composition
        networkManager.networkEventsFlow.collectLatest { message ->
            networkManager.processSnackBarEvent(coroutineScope, message)
        }
    }

    Scaffold(
        bottomBar = {  },
        containerColor = MaterialTheme.colorScheme.background,
        snackbarHost = { SnackbarHost(networkManager.snackBarHostState) }
    ) { paddingValues ->
        Header1(
            text = "Welcome to Quick Bites!",
            modifier = Modifier.padding(paddingValues)
        )
    }
}
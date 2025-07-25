package com.apptastic.quickbites.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.apptastic.quickbites.MainApplication
import com.apptastic.quickbites.navigation.QuickBitesDestinations
import kotlinx.coroutines.flow.collectLatest

@Composable
fun QuickBitesApp() {
    val navController = rememberNavController()
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
        QuickBitesNavigation(navController, paddingValues)
    }
}

@Composable
fun QuickBitesNavigation(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier.padding(paddingValues)
    ) {
        // onBoarding/Auth
        composable(QuickBitesDestinations.Welcome.route) {  }
    }
}
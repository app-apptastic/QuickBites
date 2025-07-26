package com.apptastic.quickbites.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.apptastic.quickbites.MainApplication
import com.apptastic.quickbites.R
import com.apptastic.quickbites.navigation.QuickBitesDestinations
import com.apptastic.quickbites.screens.address.AddressScreen
import com.apptastic.quickbites.screens.auth.LoginScreen
import com.apptastic.quickbites.screens.auth.LogoutScreen
import com.apptastic.quickbites.screens.auth.SignUpScreen
import com.apptastic.quickbites.screens.bestseller.BestSellerScreen
import com.apptastic.quickbites.screens.contactus.ContactUsScreen
import com.apptastic.quickbites.screens.help.HelpScreen
import com.apptastic.quickbites.screens.home.HomeScreen
import com.apptastic.quickbites.screens.orders.OrderScreen
import com.apptastic.quickbites.screens.payment.PaymentScreen
import com.apptastic.quickbites.screens.profile.ProfileScreen
import com.apptastic.quickbites.screens.recommendations.RecommendationsScreen
import com.apptastic.quickbites.screens.settings.SettingsScreen
import com.apptastic.quickbites.screens.welcome.WelcomeScreen
import com.apptastic.quickbites.utils.AppColor
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
        bottomBar = { BottomNavigationBar(navController) },
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
        startDestination = QuickBitesDestinations.Welcome.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        // onBoarding/Auth
        composable(QuickBitesDestinations.Welcome.route) { WelcomeScreen() }
        composable(QuickBitesDestinations.SignUp.route) { SignUpScreen() }
        composable(QuickBitesDestinations.Login.route) { LoginScreen() }

        // Bottom Navigation Destinations
        composable(QuickBitesDestinations.Home.route) { HomeScreen() }
        composable(QuickBitesDestinations.MyOrders.route) { OrderScreen() }
        composable(QuickBitesDestinations.BestSeller.route) { BestSellerScreen() }
        composable(QuickBitesDestinations.Recommendations.route) { RecommendationsScreen() }
        composable(QuickBitesDestinations.ContactUs.route) { ContactUsScreen() }

        // Hamburger Menu Destinations
        composable(QuickBitesDestinations.MyProfile.route) { ProfileScreen() }
        composable(QuickBitesDestinations.DeliveryAddress.route) { AddressScreen() }
        composable(QuickBitesDestinations.PaymentMethods.route) { PaymentScreen() }
        composable(QuickBitesDestinations.HelpFaq.route) { HelpScreen() }
        composable(QuickBitesDestinations.Settings.route) { SettingsScreen() }
        composable(QuickBitesDestinations.Logout.route) { LogoutScreen() }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val screens = listOf(
        QuickBitesDestinations.Home to R.drawable.home_icon,
        QuickBitesDestinations.MyOrders to R.drawable.my_orders_icon,
        QuickBitesDestinations.BestSeller to R.drawable.favourites_icon,
        QuickBitesDestinations.Recommendations to R.drawable.recommendations_icon,
        QuickBitesDestinations.ContactUs to R.drawable.contact_us_icon
    )
    BottomAppBar(
        containerColor = AppColor.colorE95322,
        windowInsets = BottomAppBarDefaults.windowInsets,
        contentPadding = BottomAppBarDefaults.ContentPadding,
        modifier = Modifier.navigationBarsPadding().wrapContentHeight()
    ) {
        val navBackStackEntry = navController.currentBackStackEntryAsState() // gives the current screen in the navigation
        val currentRoute = navBackStackEntry.value?.destination?.route // extracts the route name of the current screen

        screens.forEach { (screen, icon) ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                icon = {
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = screen.route, // Adjust padding as needed
                    )
                },
                onClick = {
                    if(screen.route != currentRoute)
                    navController.navigate(screen.route) {
                        launchSingleTop = true // Avoids multiple copies of the same destination
                        restoreState = true // Restores the state of the destination when navigating back
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = AppColor.colorF5F5F5,
                    indicatorColor = AppColor.colorE95322
                ),
                modifier = Modifier // Set background color for the item
            )
        }
    }
}
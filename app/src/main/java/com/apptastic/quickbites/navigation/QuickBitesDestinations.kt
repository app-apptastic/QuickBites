package com.apptastic.quickbites.navigation

/**
 * A sealed class to define all the navigation destinations (routes) in the app.
 * Each object/data class represents a unique screen or navigation path.
 *
 * @param route The base route string for the destination. For routes with arguments,
 * this will include placeholders like "{argName}".
 */
sealed class QuickBitesDestinations(val route: String) {
    data object Welcome : QuickBitesDestinations("WELCOME_SCREEN")
    data object Login : QuickBitesDestinations("LOGIN_SCREEN")
    data object SignUp : QuickBitesDestinations("SIGN_UP_SCREEN")

    // Hamburger Menu Destinations
    data object MyProfile : QuickBitesDestinations("PROFILE_SCREEN")
    data object DeliveryAddress : QuickBitesDestinations("DELIVERY_ADDRESS_SCREEN")
    data object PaymentMethods : QuickBitesDestinations("PAYMENT_METHODS_SCREEN")
    data object HelpFaq : QuickBitesDestinations("HELP_FAQ_SCREEN")
    data object Settings : QuickBitesDestinations("SETTINGS_SCREEN")
    data object Logout : QuickBitesDestinations("LOGOUT_SCREEN")

    // Bottom Navigation Destinations
    data object Home : QuickBitesDestinations("HOME_SCREEN")
    data object MyOrders : QuickBitesDestinations("MY_ORDERS_SCREEN")
    data object BestSeller : QuickBitesDestinations("BEST_SELLER_SCREEN")
    data object Recommendations : QuickBitesDestinations("RECOMMENDATIONS_SCREEN")
    data object ContactUs : QuickBitesDestinations("CONTACT_US_SCREEN")
}
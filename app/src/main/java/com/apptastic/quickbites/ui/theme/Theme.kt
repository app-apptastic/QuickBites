package com.apptastic.quickbites.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.apptastic.quickbites.R

private val DarkColorScheme = darkColorScheme(
    primary = DarkSchemeBottomNavBackground,
    secondary = DarkSchemeCardBackground,
    onSecondary = DarkSchemeFontColor,
    background = DarkSchemeBackground,
)

private val LightColorScheme = lightColorScheme(
    primary = LightSchemeBottomNavBackground,
    secondary = LightSchemeCardBackground,
    onSecondary = LightSchemeFontColor,
    background = LightSchemeBackground

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

val jakartaSansFont = FontFamily(
    Font(R.font.plusjakartasans_bold, AppFontWeight.Bold),
    Font(R.font.plusjakartasans_bolditalic, AppFontWeight.Bold),
    Font(R.font.plusjakartasans_extrabold, AppFontWeight.ExtraBold),
    Font(R.font.plusjakartasans_extrabolditalic, AppFontWeight.ExtraBold),
    Font(R.font.plusjakartasans_extralight, AppFontWeight.ExtraLight),
    Font(R.font.plusjakartasans_extralightitalic, AppFontWeight.ExtraLight),
    Font(R.font.plusjakartasans_italic, AppFontWeight.Light),
    Font(R.font.plusjakartasans_light, AppFontWeight.Light),
    Font(R.font.plusjakartasans_lightitalic, AppFontWeight.Light),
    Font(R.font.plusjakartasans_medium, AppFontWeight.Medium),
    Font(R.font.plusjakartasans_mediumitalic, AppFontWeight.Medium),
    Font(R.font.plusjakartasans_regular, AppFontWeight.Medium),
    Font(R.font.plusjakartasans_semibold, AppFontWeight.SemiBold),
    Font(R.font.plusjakartasans_semibolditalic, AppFontWeight.SemiBold),
)

val winkySansFont = FontFamily(
    Font(R.font.winkysans_black, AppFontWeight.Medium),
    Font(R.font.winkysans_blackitalic, AppFontWeight.Medium),
    Font(R.font.winkysans_bold, AppFontWeight.Bold),
    Font(R.font.winkysans_bolditalic, AppFontWeight.Bold),
    Font(R.font.winkysans_extrabold, AppFontWeight.ExtraBold),
    Font(R.font.winkysans_extrabolditalic, AppFontWeight.ExtraBold),
    Font(R.font.winkysans_italic, AppFontWeight.Medium),
    Font(R.font.winkysans_light, AppFontWeight.Light),
    Font(R.font.winkysans_lightitalic, AppFontWeight.Light),
    Font(R.font.winkysans_medium, AppFontWeight.Medium),
    Font(R.font.winkysans_mediumitalic, AppFontWeight.Medium),
    Font(R.font.winkysans_regular, AppFontWeight.Medium),
    Font(R.font.winkysans_semibold, AppFontWeight.SemiBold),
    Font(R.font.winkysans_semibolditalic, AppFontWeight.SemiBold),
)

val jakartaSansTypography = Typography(
    displayLarge = TextStyle(fontFamily = jakartaSansFont, fontWeight = FontWeight.Bold, fontSize = 32.sp),
    displayMedium = TextStyle(fontFamily = jakartaSansFont, fontWeight = FontWeight.Medium, fontSize = 28.sp),
    displaySmall = TextStyle(fontFamily = jakartaSansFont, fontWeight = FontWeight.Normal, fontSize = 24.sp),

    headlineLarge = TextStyle(fontFamily = jakartaSansFont, fontWeight = FontWeight.Bold, fontSize = 22.sp),
    headlineMedium = TextStyle(fontFamily = jakartaSansFont, fontWeight = FontWeight.Medium, fontSize = 20.sp),
    headlineSmall = TextStyle(fontFamily = jakartaSansFont, fontWeight = FontWeight.Normal, fontSize = 18.sp),

    titleLarge = TextStyle(fontFamily = jakartaSansFont, fontWeight = FontWeight.Bold, fontSize = 16.sp),
    titleMedium = TextStyle(fontFamily = jakartaSansFont, fontWeight = FontWeight.Medium, fontSize = 14.sp),
    titleSmall = TextStyle(fontFamily = jakartaSansFont, fontWeight = FontWeight.Normal, fontSize = 12.sp),

    bodyLarge = TextStyle(fontFamily = jakartaSansFont, fontWeight = FontWeight.Normal, fontSize = 16.sp),
    bodyMedium = TextStyle(fontFamily = jakartaSansFont, fontWeight = FontWeight.Normal, fontSize = 14.sp),
    bodySmall = TextStyle(fontFamily = jakartaSansFont, fontWeight = FontWeight.Normal, fontSize = 12.sp),

    labelLarge = TextStyle(fontFamily = jakartaSansFont, fontWeight = FontWeight.Medium, fontSize = 14.sp),
    labelMedium = TextStyle(fontFamily = jakartaSansFont, fontWeight = FontWeight.Medium, fontSize = 12.sp),
    labelSmall = TextStyle(fontFamily = jakartaSansFont, fontWeight = FontWeight.Medium, fontSize = 10.sp)
)

val winkySansTypography = Typography(
    displayLarge = TextStyle(fontFamily = winkySansFont, fontWeight = FontWeight.Bold, fontSize = 32.sp),
    displayMedium = TextStyle(fontFamily = winkySansFont, fontWeight = FontWeight.Medium, fontSize = 28.sp),
    displaySmall = TextStyle(fontFamily = winkySansFont, fontWeight = FontWeight.Normal, fontSize = 24.sp),

    headlineLarge = TextStyle(fontFamily = winkySansFont, fontWeight = FontWeight.Bold, fontSize = 22.sp),
    headlineMedium = TextStyle(fontFamily = winkySansFont, fontWeight = FontWeight.Medium, fontSize = 20.sp),
    headlineSmall = TextStyle(fontFamily = winkySansFont, fontWeight = FontWeight.Normal, fontSize = 18.sp),

    titleLarge = TextStyle(fontFamily = winkySansFont, fontWeight = FontWeight.Bold, fontSize = 16.sp),
    titleMedium = TextStyle(fontFamily = winkySansFont, fontWeight = FontWeight.Medium, fontSize = 14.sp),
    titleSmall = TextStyle(fontFamily = winkySansFont, fontWeight = FontWeight.Normal, fontSize = 12.sp),

    bodyLarge = TextStyle(fontFamily = winkySansFont, fontWeight = FontWeight.Normal, fontSize = 16.sp),
    bodyMedium = TextStyle(fontFamily = winkySansFont, fontWeight = FontWeight.Normal, fontSize = 14.sp),
    bodySmall = TextStyle(fontFamily = winkySansFont, fontWeight = FontWeight.Normal, fontSize = 12.sp),

    labelLarge = TextStyle(fontFamily = winkySansFont, fontWeight = FontWeight.Medium, fontSize = 14.sp),
    labelMedium = TextStyle(fontFamily = winkySansFont, fontWeight = FontWeight.Medium, fontSize = 12.sp),
    labelSmall = TextStyle(fontFamily = winkySansFont, fontWeight = FontWeight.Medium, fontSize = 10.sp)
)

@Composable
fun QuickBitesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    /**
     * below commented code applies dynamic colors based on user selected, so few colors cant be overridden
     * so if we want our app to have our own colors comment and have below code for colorScheme
     */
//    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme

//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
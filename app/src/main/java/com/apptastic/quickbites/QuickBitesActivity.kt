package com.apptastic.quickbites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.apptastic.quickbites.compose.QuickBitesApp
import com.apptastic.quickbites.ui.theme.QuickBitesTheme

class QuickBitesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuickBitesTheme {
                QuickBitesApp()
            }
        }
    }
}

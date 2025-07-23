package com.apptastic.quickbites.compose.components

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ButtonLarge(
    text: String,
    isEnabled: Boolean = true,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)?
) {
    Button(
        modifier = modifier,
        onClick = { if (isEnabled) onClick?.invoke() },
        enabled = isEnabled
    ) {

    }
}

@Composable
fun ButtonSmall() {

}
package com.apptastic.quickbites.compose.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import com.apptastic.quickbites.utils.Dimen

/**
 * when using, specify the typography to use
 *
 * Header1(text = "Hello World", textStyle = jakartaSansTypography.displayLarge) // Uses jakartaSansFont
 * Header1(text = "Hello World", textStyle = winkySansTypography.displayLarge) // Uses winkySansFont
 */

@Composable
fun Header1(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSecondary,
    textAlign: TextAlign = TextAlign.Start,
    lineHeight: TextUnit = TextUnit.Unspecified,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium // Default to current theme
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        color = color,
        textAlign = textAlign,
        lineHeight = lineHeight
    )
}

@Composable
fun Header2(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSecondary,
    textAlign: TextAlign = TextAlign.Start,
    lineHeight: TextUnit = Dimen.text_28,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        color = color,
        textAlign = textAlign,
        lineHeight = lineHeight
    )
}

@Composable
fun Header3(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSecondary,
    textAlign: TextAlign = TextAlign.Start,
    lineHeight: TextUnit = Dimen.text_17,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        color = color,
        textAlign = textAlign,
        lineHeight = lineHeight
    )
}

@Composable
fun SubHeading1(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSecondary,
    textAlign: TextAlign = TextAlign.Start,
    lineHeight: TextUnit = TextUnit.Unspecified,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        color = color,
        textAlign = textAlign,
        lineHeight = lineHeight
    )
}

@Composable
fun SubHeading2(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSecondary,
    textAlign: TextAlign = TextAlign.Start,
    lineHeight: TextUnit = Dimen.text_24,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        color = color,
        textAlign = textAlign,
        lineHeight = lineHeight
    )
}

@Composable
fun SubHeading2(
    modifier: Modifier = Modifier,
    text: AnnotatedString,
    color: Color = MaterialTheme.colorScheme.onSecondary,
    textAlign: TextAlign = TextAlign.Start,
    lineHeight: TextUnit = Dimen.text_24,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        color = color,
        textAlign = textAlign,
        lineHeight = lineHeight
    )
}

@Composable
fun SubHeading3(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSecondary,
    textAlign: TextAlign = TextAlign.Start,
    lineHeight: TextUnit = TextUnit.Unspecified,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        color = color,
        textAlign = textAlign,
        lineHeight = lineHeight
    )
}

@Composable
fun SubHeading4(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSecondary,
    textAlign: TextAlign = TextAlign.Start,
    lineHeight: TextUnit = TextUnit.Unspecified,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        color = color,
        textAlign = textAlign,
        lineHeight = lineHeight
    )
}

@Composable
fun Body1(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSecondary,
    textAlign: TextAlign = TextAlign.Start,
    lineHeight: TextUnit = Dimen.text_17,
    textDecoration: TextDecoration? = null,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        color = color,
        textAlign = textAlign,
        lineHeight = lineHeight,
        textDecoration = textDecoration
    )
}

@Composable
fun Body1(
    modifier: Modifier = Modifier,
    text: AnnotatedString,
    color: Color = MaterialTheme.colorScheme.onSecondary,
    textAlign: TextAlign = TextAlign.Start,
    lineHeight: TextUnit = Dimen.text_17,
    textDecoration: TextDecoration? = null,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        color = color,
        textAlign = textAlign,
        lineHeight = lineHeight,
        textDecoration = textDecoration
    )
}

@Composable
fun Body2(
    modifier: Modifier = Modifier,
    text: String,
    color: Color =  MaterialTheme.colorScheme.onSecondary,
    textAlign: TextAlign = TextAlign.Start,
    lineHeight: TextUnit = Dimen.text_15,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        color = color,
        textAlign = textAlign,
        lineHeight = lineHeight
    )
}

@Composable
fun Body2(
    modifier: Modifier = Modifier,
    text: AnnotatedString,
    color: Color = MaterialTheme.colorScheme.onSecondary,
    textAlign: TextAlign = TextAlign.Start,
    lineHeight: TextUnit = Dimen.text_15,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        color = color,
        textAlign = textAlign,
        lineHeight = lineHeight
    )
}

@Composable
fun Body3(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSecondary,
    textAlign: TextAlign = TextAlign.Start,
    lineHeight: TextUnit = Dimen.text_15,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        color = color,
        textAlign = textAlign,
        lineHeight = lineHeight
    )
}

@Composable
fun Body4(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSecondary,
    textAlign: TextAlign = TextAlign.Start,
    lineHeight: TextUnit = Dimen.text_19,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        color = color,
        textAlign = textAlign,
        lineHeight = lineHeight
    )
}

@Composable
fun Body5(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSecondary,
    textAlign: TextAlign = TextAlign.Start,
    lineHeight: TextUnit = Dimen.text_19,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        color = color,
        textAlign = textAlign,
        lineHeight = lineHeight
    )
}

@Composable
fun LabelSmall(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSecondary,
    textAlign: TextAlign = TextAlign.Start,
    lineHeight: TextUnit = Dimen.text_15,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        color = color,
        textAlign = textAlign,
        lineHeight = lineHeight
    )
}
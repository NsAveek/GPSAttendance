package aveek.isotopsoftware.gpsattendance.android.presentation.components.text

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import aveek.isotopsoftware.gpsattendance.common.GPSAttendanceThemeTypography


@Composable
fun TextFields(
    modifier: Modifier,
    value: String,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    style: GPSAttendanceThemeTypography?,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    supportingTextRequired: Boolean,
    keyboardOptions: KeyboardOptions,
    onValueChanged: (String) -> Unit,
    visualTransformation: VisualTransformation,
) {

    TextField(
        value = value,
        label = label,
        placeholder = placeholder,
        onValueChange = {
            onValueChanged(it)
        },
        leadingIcon = leadingIcon,
        keyboardOptions = keyboardOptions,
        supportingText = if (supportingTextRequired) {
            { Text("*required") }
        } else {
            { Text("") }
        },
        modifier = modifier,
        visualTransformation = visualTransformation
    )
}
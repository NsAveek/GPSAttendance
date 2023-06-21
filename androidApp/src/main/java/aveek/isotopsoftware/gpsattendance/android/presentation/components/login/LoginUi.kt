package aveek.isotopsoftware.gpsattendance.android.presentation.components.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import aveek.isotopsoftware.gpsattendance.android.R
import aveek.isotopsoftware.gpsattendance.common.DimensionTokens

@Composable
fun LoginScreen(modifier: Modifier,
                onForgotPasswordClick :()-> Unit,
                onRegistrationTabClick : ()-> Unit,
                onLoginClick : ()-> Unit
                ) {
    Text(
        text = "Hi, There",
        style = MaterialTheme.typography.displayMedium,
        modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_small))
    )

    Spacer(modifier = modifier.size(DimensionTokens.dimension32.dp))


    TextField(
        value = "Enter your email",
        label = { Text("Email") },
        onValueChange = {},
        modifier = Modifier.clip(MaterialTheme.shapes.medium)
    )

    Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))

    TextField(
        value = "*******",
        label = { Text("Password") },
        onValueChange = {},
        modifier = Modifier.clip(MaterialTheme.shapes.medium),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )

    Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))
    
    Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = false, onCheckedChange = {

        })
        Text(text = "Remember for 30 days")

        Text(text = "Forgot Password", Modifier.clickable { onForgotPasswordClick.invoke() })
    }

    Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))

    Row() {
        Button(onClick = {onLoginClick.invoke()},modifier = Modifier.weight(1f), shape = RoundedCornerShape(10.dp)) {
            Text(text = "Sign In")
        }
        Button(onClick = {onRegistrationTabClick.invoke()},modifier = Modifier.weight(1f), shape = RoundedCornerShape(10.dp)) {
            Text(text = "Register")
        }
    }

    Spacer(modifier = modifier.size(DimensionTokens.dimension64.dp))
    Text(text = "Powered by Isotop Software Inc.")
}

@Composable
fun RegistrationScreen(modifier: Modifier,
                onRegistrationTabClick : ()-> Unit,
                onLoginClick : ()-> Unit
) {
    Text(
        text = "Hi, There",
        style = MaterialTheme.typography.displayMedium,
        modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_small))
    )

    Spacer(modifier = modifier.size(DimensionTokens.dimension32.dp))


    TextField(
        value = "Enter your email",
        label = { Text("Email") },
        onValueChange = {},
        modifier = Modifier.clip(MaterialTheme.shapes.medium)
    )

    Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))

    TextField(
        value = "*******",
        label = { Text("Password") },
        onValueChange = {},
        modifier = Modifier.clip(MaterialTheme.shapes.medium),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )

    Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))

    TextField(
        value = "*******",
        label = { Text("Repeat Password") },
        onValueChange = {},
        modifier = Modifier.clip(MaterialTheme.shapes.medium),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )

    Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))

    Row() {
        Button(onClick = {onLoginClick.invoke()},modifier = Modifier.weight(1f), shape = RoundedCornerShape(10.dp)) {
            Text(text = "Sign In")
        }
        Button(onClick = {onRegistrationTabClick.invoke()},modifier = Modifier.weight(1f), shape = RoundedCornerShape(10.dp)) {
            Text(text = "Register")
        }
    }
    
    
}
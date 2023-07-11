package aveek.isotopsoftware.gpsattendance.android.presentation.components.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import aveek.isotopsoftware.gpsattendance.android.R
import aveek.isotopsoftware.gpsattendance.common.DimensionTokens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onForgotPasswordClick: () -> Unit,
    onRegistrationTabClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    Box(modifier = Modifier
        .padding(40.dp)
        .fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                Text(
                    text = "Hi, There",
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_small))
                )
            }
            Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = "Enter your email",
                    label = { Text("Email") },
                    onValueChange = {},
                    leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email") },
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.medium)
                        .fillMaxWidth()
                )

                Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))

                TextField(
                    value = "*******",
                    label = { Text("Password") },
                    onValueChange = {

                    },
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.medium)
                        .fillMaxWidth(),
                    leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Password") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))

                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false){
                        Checkbox(checked = false, onCheckedChange = {

                        })
                    }
                    Spacer(modifier = modifier.size(DimensionTokens.dimension8.dp))

                    Text(text = "Remember for 30 days")
                }
                Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))

                Column(modifier = Modifier.fillMaxWidth() ,horizontalAlignment = Alignment.End) {
                    Text(text = "Forgot Password?",color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold, modifier = Modifier.clickable { onForgotPasswordClick.invoke() })
                }

                Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))

                Row() {
                    Button(
                        onClick = { onLoginClick.invoke() },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(text = "Sign In")
                    }
                }

                Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))

                Row(modifier =Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Text(text = "New User?")
                    Spacer(modifier = modifier.size(DimensionTokens.dimension2.dp))
                    Text(text = "Register Here", fontWeight = FontWeight.Bold,color = MaterialTheme.colorScheme.primary,modifier = Modifier.clickable {
                        onRegistrationTabClick.invoke()
                    })
                }
            }
        }

        Text(text = "Powered by Isotop Software Inc.",modifier = Modifier.align(Alignment.BottomCenter))
    }
}

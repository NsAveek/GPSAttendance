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
import androidx.compose.material3.Button
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
fun RegistrationScreen(
    modifier: Modifier,
    onRegistrationTabClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    Box(
        modifier = Modifier
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
                    modifier = Modifier.clip(MaterialTheme.shapes.medium).fillMaxWidth()
                )

                Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))

                TextField(
                    value = "*******",
                    label = { Text("Password") },
                    onValueChange = {},
                    modifier = Modifier.clip(MaterialTheme.shapes.medium).fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))

                TextField(
                    value = "*******",
                    label = { Text("Repeat Password") },
                    onValueChange = {},
                    modifier = Modifier.clip(MaterialTheme.shapes.medium).fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))

                Row() {
                    Button(
                        onClick = { onRegistrationTabClick.invoke() },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(text = "Register")
                    }
                }
                Spacer(modifier = modifier.size(DimensionTokens.dimension32.dp))

                Text(text = "Already Have an Account?")
                Spacer(modifier = modifier.size(DimensionTokens.dimension8.dp))

                Text(text = "Sign In Here", Modifier.clickable {
                    onLoginClick.invoke()
                })
            }
        }
        Text(
            text = "Powered by Isotop Software Inc.",
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}
package aveek.isotopsoftware.gpsattendance.android.presentation.components.login

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Email
import androidx.compose.material.icons.twotone.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import aveek.isotopsoftware.gpsattendance.android.R
import aveek.isotopsoftware.gpsattendance.android.presentation.components.compose.CustomTopAppBar
import aveek.isotopsoftware.gpsattendance.android.presentation.components.text.TextFields
import aveek.isotopsoftware.gpsattendance.common.DimensionTokens
import aveek.isotopsoftware.gpsattendance.data.model.AuthCredentials
import aveek.isotopsoftware.gpsattendance.domain.actions.AuthEvents
import aveek.isotopsoftware.gpsattendance.viewmodel.AuthenticationViewModel
import org.koin.androidx.compose.getViewModel

@Preview
@Composable
fun PreviewLoginScreen(){
    LoginScreen(contentPadding = PaddingValues(24.dp), viewModel = getViewModel(), onRegistrationTabClick = {})
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
    viewModel: AuthenticationViewModel,
    onRegistrationTabClick : ()-> Unit
) {
    Scaffold(
        topBar = {
            CustomTopAppBar(title =  "GPS ATTENDANCE", centerAligned = true)
        }
    ) {
        Box(
            modifier = Modifier
                .padding(contentPadding)
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
                    var emailText by remember {
                        mutableStateOf("kminchelle")
                    }
                    var passwordText by remember {
                        mutableStateOf("0lelplR")
                    }

                    TextFields(
                        value = emailText,
                        placeholder = { Text("Please type you registered email") },
                        label = { Text("Email") },
                        leadingIcon = { Icon(Icons.TwoTone.Email, contentDescription = "Email") },
                        keyboardOptions =KeyboardOptions( keyboardType = KeyboardType.Email, imeAction = ImeAction.Next ),
                        supportingTextRequired = true,
                        modifier = Modifier
                            .clip(MaterialTheme.shapes.medium)
                            .fillMaxWidth(),
                        onValueChanged = {
                            emailText = it
                        },
                        style = null,
                        visualTransformation = VisualTransformation.None
                    )

                    Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))

                    TextFields(
                        value = passwordText,
                        placeholder = { Text("Please type your password") },
                        label = { Text("Password") },
                        leadingIcon = { Icon(Icons.TwoTone.Lock, contentDescription = "Password") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Send),
                        supportingTextRequired = true,
                        modifier = Modifier
                            .clip(MaterialTheme.shapes.medium)
                            .fillMaxWidth(),
                        onValueChanged = {
                            passwordText = it
                        },
                        style = null,
                        visualTransformation = PasswordVisualTransformation(),
                    )

                    Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
                            Checkbox(checked = false, onCheckedChange = {

                            })
                        }
                        Spacer(modifier = modifier.size(DimensionTokens.dimension8.dp))

                        Text(text = "Remember for 30 days")
                    }
                    Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))

                    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
                        Text(
                            text = "Forgot Password?",
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.clickable {
                                viewModel.action(events = AuthEvents.forgotPasswordEvent)
                            })
                    }

                    Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))

                    Row {
                        Button(
                            onClick = {
                                viewModel.action(AuthEvents.loginEvent(AuthCredentials(emailText,passwordText)))
                                      },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "Sign In")
                        }
                    }

                    Spacer(modifier = modifier.size(DimensionTokens.dimension16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "New User?")
                        Spacer(modifier = modifier.size(DimensionTokens.dimension2.dp))
                        Text(
                            text = "Register Here",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.clickable {
                                onRegistrationTabClick.invoke()
                            })
                    }
                }
            }

            Text(
                text = "Powered by Isotop Software Inc.",
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}

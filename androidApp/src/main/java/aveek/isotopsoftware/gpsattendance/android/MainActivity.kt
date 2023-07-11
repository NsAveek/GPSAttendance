package aveek.isotopsoftware.gpsattendance.android

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import aveek.isotopsoftware.gpsattendance.android.presentation.components.login.LoginScreen
import aveek.isotopsoftware.gpsattendance.android.presentation.components.login.RegistrationScreen
import aveek.isotopsoftware.gpsattendance.android.presentation.theme.GPSAttendanceTheme
import aveek.isotopsoftware.gpsattendance.android.presentation.util.Screens

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GPSAttendanceTheme {
                Scaffold(
                    topBar = { TopAppBar(modifier = Modifier) }
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.LoginScreen.route
                    ) {
                        composable(Screens.LoginScreen.route) {
                            LoginScreen(
                                onLoginClick = {
                                    Toast.makeText(this@MainActivity,"Login Clicked", Toast.LENGTH_LONG).show()
                                },
                                onRegistrationTabClick = {
                                    navController.navigate(Screens.RegistrationScreen.route) {
                                        launchSingleTop = true
                                    }
                                },
                                onForgotPasswordClick = {},

                                )
                        }
                        composable(Screens.RegistrationScreen.route) {
                            RegistrationScreen(
                                modifier = Modifier,
                                onRegistrationTabClick = { },
                                onLoginClick = {
                                    navController.navigate(Screens.LoginScreen.route) {
                                        launchSingleTop = true
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopAppBar(modifier: Modifier) {
        CenterAlignedTopAppBar(
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "GPS Attendance",
                        style = MaterialTheme.typography.displayLarge
                    )
                }
            },
            modifier = modifier
        )
    }


}

@Composable
fun CoreScreen(insets: PaddingValues, theme: Boolean, modifier: Modifier) {
    Column(
        modifier = Modifier
            .padding(40.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        val interactionSource = remember { MutableInteractionSource() }
        val isRegistrationPressed by interactionSource.collectIsPressedAsState()

        LoginScreen(modifier,
            onForgotPasswordClick = {},
            onLoginClick = {},
            onRegistrationTabClick = {
            }
        )
    }

}


@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    GPSAttendanceTheme(darkTheme = true) {
        CoreScreen(PaddingValues(5.dp), false, modifier = Modifier)
//        GreetingView("Hello, Android!")
    }
}

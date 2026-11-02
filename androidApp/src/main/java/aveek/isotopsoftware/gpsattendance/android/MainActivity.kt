package aveek.isotopsoftware.gpsattendance.android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import aveek.isotopsoftware.gpsattendance.android.presentation.components.compose.CustomTopAppBar
import aveek.isotopsoftware.gpsattendance.android.presentation.components.login.LoginScreen
import aveek.isotopsoftware.gpsattendance.android.presentation.components.login.RegistrationScreen
import aveek.isotopsoftware.gpsattendance.android.presentation.components.profile.ProfileScreen
import aveek.isotopsoftware.gpsattendance.android.presentation.theme.GPSAttendanceTheme
import aveek.isotopsoftware.gpsattendance.android.presentation.util.Screens
import aveek.isotopsoftware.gpsattendance.common.DimensionTokens
import aveek.isotopsoftware.gpsattendance.data.model.AuthCredentials
import aveek.isotopsoftware.gpsattendance.domain.actions.AuthEvents
import aveek.isotopsoftware.gpsattendance.domain.states.AuthenticationState
import aveek.isotopsoftware.gpsattendance.viewmodel.AuthenticationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

@ExperimentalFoundationApi
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    private val viewModel: AuthenticationViewModel by viewModel()
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val data = viewModel.check()
            GPSAttendanceTheme {
                MainContent()
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    private fun MainContent() {
        Scaffold(
            content = {
                val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
                val topBarState = rememberSaveable { (mutableStateOf(true)) }
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                when (navBackStackEntry?.destination?.route) {
                    Screens.LoginScreen.route -> {

                    }

                    Screens.RegistrationScreen.route -> {

                    }

                    Screens.ProfileScreen.route -> {
                        bottomBarState.value = true
                        topBarState.value = false
                    }
                }

                NavHost(
                    navController = navController,
                    startDestination = Screens.LoginScreen.route
                ) {
                    composable(Screens.LoginScreen.route) {
                        LoginScreen(
                            contentPadding = PaddingValues(DimensionTokens.dimension40.dp),
                            viewModel = viewModel,
                            onRegistrationTabClick = {
                                navController.navigate(Screens.RegistrationScreen.route) {
                                    launchSingleTop = true
                                }
                            }
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
                    composable(Screens.ProfileScreen.route) {
                        ProfileScreen(
                            onBackButtonClick = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopAppBar(modifier: Modifier) {
        CustomTopAppBar(title =  "GPS Attendance", centerAligned = true)
    }

    @Composable
    fun CoreScreen(insets: PaddingValues, theme: Boolean, modifier: Modifier) {
        Column(
            modifier = Modifier
                .padding(insets)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            val interactionSource = remember { MutableInteractionSource() }
            val isRegistrationPressed by interactionSource.collectIsPressedAsState()

            LoginScreen(insets,modifier, viewModel, onRegistrationTabClick = {})
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
            MainContent()
//            CoreScreen(PaddingValues(DimensionTokens.dimension4.dp), false, modifier = Modifier)
        }
    }
}

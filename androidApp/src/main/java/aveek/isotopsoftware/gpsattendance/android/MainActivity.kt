package aveek.isotopsoftware.gpsattendance.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import aveek.isotopsoftware.gpsattendance.android.presentation.components.login.LoginScreen
import aveek.isotopsoftware.gpsattendance.android.presentation.components.login.RegistrationScreen
import aveek.isotopsoftware.gpsattendance.android.presentation.theme.GPSAttendanceTheme
import aveek.isotopsoftware.gpsattendance.common.DimensionTokens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GPSAttendanceTheme {
                Scaffold(
                   topBar = { TopAppBar(modifier  = Modifier) } 
                ) {
                    CoreScreen(it,true, modifier = Modifier)
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
fun CoreScreen(insets: PaddingValues,theme: Boolean, modifier: Modifier) {
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
    GPSAttendanceTheme (darkTheme = true){
        CoreScreen(PaddingValues(5.dp),false, modifier = Modifier)
//        GreetingView("Hello, Android!")
    }
}

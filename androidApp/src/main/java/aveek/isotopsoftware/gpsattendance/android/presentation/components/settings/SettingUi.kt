package aveek.isotopsoftware.gpsattendance.android.presentation.components.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import aveek.isotopsoftware.gpsattendance.common.DimensionTokens

@Composable
fun SettingsUi(paddingValues : PaddingValues){
    Box(modifier = Modifier
        .padding(paddingValues)
        .fillMaxSize()) {
        val contentPadding = DimensionTokens.dimension40.dp
        Text(
            text = "Powered by Isotop Software Inc.",
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = contentPadding)
        )
    }
}
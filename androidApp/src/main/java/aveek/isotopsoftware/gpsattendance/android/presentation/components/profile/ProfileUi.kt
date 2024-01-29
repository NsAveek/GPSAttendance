package aveek.isotopsoftware.gpsattendance.android.presentation.components.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import aveek.isotopsoftware.gpsattendance.android.presentation.components.compose.CustomTopAppBar
import aveek.isotopsoftware.gpsattendance.common.DimensionTokens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen( onBackButtonClick: () -> Unit) {
    Scaffold(
        topBar = {
            CustomTopAppBar(title =  "Profile", centerAligned = false, navigationIcon = {
                IconButton(onClick = {
                    onBackButtonClick.invoke()
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
            })
    }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            val contentPadding = DimensionTokens.dimension16.dp
            Column(
                modifier = Modifier
                    .padding(start = contentPadding, end = contentPadding)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(modifier = Modifier) {
                        Image(
                            imageVector = Icons.Default.Person,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(DimensionTokens.dimension72.dp)
                                .clip(CircleShape)
                                .border(DimensionTokens.dimension2.dp, Color.Gray, CircleShape),
                            contentDescription = ""
                        )

                        val iconSize = 24.dp
                        val offsetInPx = LocalDensity.current.run { (iconSize / 2).roundToPx() }

                        IconButton(onClick = {},
                            modifier = Modifier
                                .offset {
                                    IntOffset(-offsetInPx, offsetInPx - 20)
                                }
                                .clip(CircleShape)
                                .background(Color.Transparent)
                                .size(20.dp)
                                .align(Alignment.BottomEnd)) {

                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }

                    }
                    Spacer(modifier = Modifier.size(DimensionTokens.dimension8.dp))
                    Text(text = "Hello, There!", style = MaterialTheme.typography.displayMedium)
                }

                Spacer(modifier = Modifier.size(DimensionTokens.dimension32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Personal Data")
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
                }
                Spacer(modifier = Modifier.size(DimensionTokens.dimension16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Settings")
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
                }
                Spacer(modifier = Modifier.size(DimensionTokens.dimension16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "FAQ")
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
                }

                Spacer(modifier = Modifier.size(DimensionTokens.dimension32.dp))
                Divider(color = MaterialTheme.colorScheme.primary, thickness = 1.dp)
                Spacer(modifier = Modifier.size(DimensionTokens.dimension32.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Dashboard")
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
                }
                Spacer(modifier = Modifier.size(DimensionTokens.dimension16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "About")
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
                }
            }

            Text(
                text = "Powered by Isotop Software Inc.", modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = contentPadding)
            )
        }
    }
}
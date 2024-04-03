package aveek.isotopsoftware.gpsattendance.android.domain.states

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import aveek.isotopsoftware.gpsattendance.domain.model.remote.Account

data class AuthenticationStates(
    val data : Account,
    val loading : MutableState<Boolean> = mutableStateOf(true),
    val success : Boolean = false,
    val error : Boolean = false
)

package com.apptastic.quickbites.utils

import androidx.compose.material3.SnackbarHostState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class NetworkEventMessage(
    val message: String,
    val actionLabel: String? = null,
    val dismissAction: Boolean = true,
    val onAction: (() -> Unit)? = null
)

class NetworkManager @Inject constructor() {

    val snackBarHostState = SnackbarHostState()
    // shared flow to emit network events
    private val networkEventsSharedFlow = MutableSharedFlow<NetworkEventMessage>()
    val networkEventsFlow = networkEventsSharedFlow.asSharedFlow()

    // Function to show a snackbar message from anywhere in the app
    suspend fun showSnackBar(message: NetworkEventMessage) {
        networkEventsSharedFlow.emit(message)
    }

    fun processSnackBarEvent(scope: CoroutineScope, message: NetworkEventMessage) {
        scope.launch {
            snackBarHostState.showSnackbar(
                message = message.message,
                actionLabel = message.actionLabel,
                withDismissAction = message.dismissAction,
                duration = if (message.actionLabel != null) {
                    androidx.compose.material3.SnackbarDuration.Indefinite
                } else {
                    androidx.compose.material3.SnackbarDuration.Short
                }
            ).also {
                message.onAction?.invoke()
            }
        }
    }

}
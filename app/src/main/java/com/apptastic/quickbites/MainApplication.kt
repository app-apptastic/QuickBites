package com.apptastic.quickbites

import android.app.Application
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.apptastic.quickbites.utils.ConnectivityObserver
import com.apptastic.quickbites.utils.NetworkEventMessage
import com.apptastic.quickbites.utils.NetworkManager
import com.apptastic.quickbites.utils.NetworkStatus
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.launch

@HiltAndroidApp
class MainApplication: Application() {

    lateinit var connectivityObserver: ConnectivityObserver
        private set // Only settable within this class

    // Make NetworkManager available globally
    lateinit var networkManager: NetworkManager
        private set

    override fun onCreate() {
        super.onCreate()
        // Initialize the connectivity observer
        connectivityObserver = ConnectivityObserver(this)
        // Register the observer with the lifecycle of the application, check below
        ProcessLifecycleOwner.get().lifecycle.addObserver(connectivityObserver)

        networkManager = NetworkManager()
        // Now, centralize the network status to Snackbar logic here
        ProcessLifecycleOwner.get().lifecycleScope.launch {
            ProcessLifecycleOwner.get().lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                Log.d("MyApplication inside", "Snackbar 'Back Online' requested.")

                // Observe connectivity changes
                connectivityObserver.networkStatus.collect { status ->
                    when (status) {
                        NetworkStatus.Connected -> {
                            networkManager.showSnackBar(
                                NetworkEventMessage(
                                    message = "Back Online",
                                    onAction = { /* Handle dismiss action if needed */ }
                                )
                            )
                            Log.d("MyApplication", "Snackbar 'Back Online' requested.")
                        }

                        NetworkStatus.Disconnected -> {
                            networkManager.showSnackBar(
                                NetworkEventMessage(
                                    message = "No Internet Connection",
                                    actionLabel = "Retry",
                                    dismissAction = true,
                                    onAction = { /* Handle dismiss action if needed */ }
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

/*
PROCESSLIFECYCLEOWNER
 * The ProcessLifecycleOwner is a singleton that provides lifecycle events for the entire application process.
 * It allows you to observe lifecycle changes across all components in the application, not just individual activities or fragments.
 * This is particularly useful for global state management or resources that need to be shared across the entire app.
* */
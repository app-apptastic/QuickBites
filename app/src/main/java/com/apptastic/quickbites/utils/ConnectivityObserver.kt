package com.apptastic.quickbites.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET
import android.net.NetworkRequest
import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

sealed class NetworkStatus {
    object Connected : NetworkStatus()
    object Disconnected : NetworkStatus()
}

class ConnectivityObserver(context: Context) : DefaultLifecycleObserver {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private val mutableNetworkStatus = MutableStateFlow<NetworkStatus>(NetworkStatus.Disconnected)
    val networkStatus: StateFlow<NetworkStatus> = mutableNetworkStatus.asStateFlow()

    val networkCallback = object : ConnectivityManager.NetworkCallback() {
        // Called when a network is connected.
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            Log.d("ConnectivityObserver", "onAvailable: $network")
            // ensure that network has capability of internet before updating status
            val capability = connectivityManager.getNetworkCapabilities(network)
            if (capability?.hasCapability(NET_CAPABILITY_INTERNET) == true) {
                mutableNetworkStatus.value = NetworkStatus.Connected
            }
        }

        // Called when the network is lost.
        override fun onLost(network: Network) {
            super.onLost(network)
            Log.d("ConnectivityObserver", "onLost: $network")
            // Re-check if any network is available
            val activeNetwork = connectivityManager.activeNetwork
            val capability = activeNetwork?.let { connectivityManager.getNetworkCapabilities(it) }
            if (activeNetwork == null || capability?.hasCapability(NET_CAPABILITY_INTERNET) != true) {
                mutableNetworkStatus.value = NetworkStatus.Disconnected
            }
        }

        // Called when network capabilities change, dynamic network changes
        override fun onCapabilitiesChanged(
            network: Network,
            networkCapabilities: NetworkCapabilities
        ) {
            super.onCapabilitiesChanged(network, networkCapabilities)
            Log.d("ConnectivityObserver", "Network capabilities changed for: $network")
            if (networkCapabilities.hasCapability(NET_CAPABILITY_INTERNET) && networkCapabilities.hasCapability(
                    NetworkCapabilities.NET_CAPABILITY_VALIDATED)
            ) {
                mutableNetworkStatus.value = NetworkStatus.Connected
            } else {
                // If current active network loses internet, set status to disconnected
                val activeNetwork = connectivityManager.activeNetwork
                if(activeNetwork == network) {
                    mutableNetworkStatus.value = NetworkStatus.Disconnected
                }
            }
        }

        override fun onUnavailable() {
            super.onUnavailable()
            Log.d("ConnectivityObserver", "Network unavailable (from requestNetwork timeout or no network matching criteria)")
            mutableNetworkStatus.value = NetworkStatus.Disconnected
        }
    }

    private val networkRequest = NetworkRequest.Builder()
        .addCapability(NET_CAPABILITY_INTERNET)
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .addTransportType(NetworkCapabilities.TRANSPORT_ETHERNET)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .build()

    init {
        connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
    }

    // unregister callback
    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }
}


/*
STEPS FOR CONNECTIVITY OBSERVER:
1. Create a ConnectivityObserver class that implements LifecycleObserver.
2. Use the ConnectivityManager to register a NetworkCallback.
3. Override onAvailable and onLost methods to handle network changes.
4. Register the observer in your Activity or Fragment lifecycle.
5. Unregister the observer in onDestroy to avoid memory leaks.
6. Use LiveData or StateFlow to expose connectivity status to the UI.
7. create a NetworkRequest to specify the type of network you want to observe (e.g., internet).
8 To register and network callback, use connectivityManager.registerNetworkCallback(request, networkCallback).
    have to pass a network request and network callback to the registerNetworkCallback method.
* */
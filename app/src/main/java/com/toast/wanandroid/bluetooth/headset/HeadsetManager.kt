package com.toast.wanandroid.bluetooth.headset

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothHeadset
import android.bluetooth.BluetoothProfile
import android.content.Context
import android.util.Log

class HeadsetManager {

    private val TAG: String = this.javaClass.simpleName

    var bluetoothHeadset: BluetoothHeadset? = null
    // Get the default adapter
    val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

    private val profileListener = object: BluetoothProfile.ServiceListener {
        /**
         * Called to notify the client that this proxy object has been
         * disconnected from the service.
         *
         * @param profile - One of [.HEADSET] or [.A2DP]
         */
        override fun onServiceDisconnected(profile: Int) {
            Log.e(TAG, "onServiceDisconnected")
            if (profile == BluetoothProfile.HEADSET) {
                bluetoothHeadset = null
            }
        }

        /**
         * Called to notify the client when the proxy object has been
         * connected to the service.
         *
         * @param profile - One of [.HEADSET] or [.A2DP]
         * @param proxy - One of [BluetoothHeadset] or [BluetoothA2dp]
         */
        override fun onServiceConnected(profile: Int, proxy: BluetoothProfile?) {
            Log.e(TAG, "onServiceConnected")
            if (profile == BluetoothProfile.HEADSET) {
                bluetoothHeadset = proxy as BluetoothHeadset
            }
        }

    }

    /**
     *  Establish connection to the proxy
     */
    fun connectionProxy(context: Context) {
        bluetoothAdapter?.getProfileProxy(context, profileListener, BluetoothProfile.HEADSET)
    }

    /**
     *  Close proxy connection after use
     */
    fun closeProxyConnection() {
        bluetoothAdapter?.closeProfileProxy(BluetoothProfile.HEADSET, bluetoothHeadset)
    }
}
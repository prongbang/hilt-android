package com.prongbang.hilt.android.core.network

import android.content.Context
import android.net.ConnectivityManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface NetworkConnection {
	fun isConnected(): Boolean
}

class LiveNetworkConnection @Inject constructor(
		@ApplicationContext private val context: Context
) : NetworkConnection {

	@Suppress("DEPRECATION")
	override fun isConnected(): Boolean {
		val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
		return cm?.activeNetworkInfo != null && cm.activeNetworkInfo?.isConnected ?: false
	}
}
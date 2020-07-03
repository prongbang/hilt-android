package com.prongbang.hilt.android.main.data

import com.prongbang.hilt.android.core.network.NetworkConnection
import com.prongbang.hilt.android.main.LocalMain
import com.prongbang.hilt.android.main.RemoteMain
import javax.inject.Inject

interface MainRepository {
	suspend fun cowSay(): String
}

class DefaultMainRepository @Inject constructor(
		private val networkConnection: NetworkConnection,
		@RemoteMain private val mainRemoteDataSource: MainDataSource,
		@LocalMain private val mainLocalDataSource: MainDataSource
) : MainRepository {

	override suspend fun cowSay(): String {
		return if (networkConnection.isConnected()) {
			mainRemoteDataSource.cowSay()
		} else {
			mainLocalDataSource.cowSay()
		}
	}
}
package com.prongbang.hilt.android.main.data.remote

import com.prongbang.hilt.android.main.data.MainDataSource
import javax.inject.Inject

class MainRemoteDataSource @Inject constructor(
		private val mainApi: MainApi
) : MainDataSource {
	override suspend fun cowSay(): String = mainApi.cowSay()
}
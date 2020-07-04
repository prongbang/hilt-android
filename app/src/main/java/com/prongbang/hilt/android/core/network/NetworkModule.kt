package com.prongbang.hilt.android.core.network

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class NetworkModule {

	@Singleton
	@Binds
	abstract fun bindLiveNetworkConnection(
			liveNetworkConnection: LiveNetworkConnection): NetworkConnection
}
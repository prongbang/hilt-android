package com.prongbang.hilt.android.main

import com.prongbang.hilt.android.core.UseCase
import com.prongbang.hilt.android.main.data.DefaultMainRepository
import com.prongbang.hilt.android.main.data.MainDataSource
import com.prongbang.hilt.android.main.data.MainRepository
import com.prongbang.hilt.android.main.data.local.MainLocalDataSource
import com.prongbang.hilt.android.main.data.remote.MainApi
import com.prongbang.hilt.android.main.data.remote.MainRemoteDataSource
import com.prongbang.hilt.android.main.data.remote.RestMainApi
import com.prongbang.hilt.android.main.domain.CowSayUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Qualifier

@Qualifier
annotation class RemoteMain

@Qualifier
annotation class LocalMain

@InstallIn(ApplicationComponent::class)
@Module
abstract class MainModule {

	@Binds
	abstract fun bindRestApi(api: RestMainApi): MainApi

	@RemoteMain
	@Binds
	abstract fun bindMainRemoteDataSource(dataSource: MainRemoteDataSource): MainDataSource

	@LocalMain
	@Binds
	abstract fun bindMainLocalDataSource(dataSource: MainLocalDataSource): MainDataSource

	@Binds
	abstract fun bindMainRepository(repository: DefaultMainRepository): MainRepository

	@Binds
	abstract fun bindCowSayUseCase(useCase: CowSayUseCase): UseCase<Unit, String>
}
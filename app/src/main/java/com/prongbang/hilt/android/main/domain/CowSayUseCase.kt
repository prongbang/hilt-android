package com.prongbang.hilt.android.main.domain

import com.prongbang.hilt.android.core.UseCase
import com.prongbang.hilt.android.main.data.MainRepository
import javax.inject.Inject

class CowSayUseCase @Inject constructor(
		private val mainRepository: MainRepository
) : UseCase<Unit, String> {

	override suspend fun execute(params: Unit): String = mainRepository.cowSay()
}
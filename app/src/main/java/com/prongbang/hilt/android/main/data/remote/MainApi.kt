package com.prongbang.hilt.android.main.data.remote

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.prongbang.hilt.android.main.domain.CowSay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface MainApi {
	suspend fun cowSay(): String
}

class RestMainApi @Inject constructor() : MainApi {

	override suspend fun cowSay(): String {
		return withContext(Dispatchers.IO) {
			val (_, _, result) = "http://cowsay.morecode.org/say?message=&format=json"
					.httpGet()
					.responseObject(CowSay.Deserializer())
			when (result) {
				is Result.Failure -> "${result.getException().exception.message}"
				is Result.Success -> result.get().cow
				else -> ""
			}
		}
	}
}
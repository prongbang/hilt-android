package com.prongbang.hilt.android.main.domain

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class CowSay(
		val cow: String = "",
		val message: String = "",
		val type: String = ""
) {
	class Deserializer : ResponseDeserializable<CowSay> {
		override fun deserialize(body: String): CowSay? {
			return Gson().fromJson(body, CowSay::class.java)
		}
	}
}
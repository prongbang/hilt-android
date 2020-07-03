package com.prongbang.hilt.android.main.data

interface MainDataSource {
	suspend fun cowSay(): String
}
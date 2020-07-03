package com.prongbang.hilt.android.core

interface UseCase<Param, Result> {
	suspend fun execute(params: Param): Result
}
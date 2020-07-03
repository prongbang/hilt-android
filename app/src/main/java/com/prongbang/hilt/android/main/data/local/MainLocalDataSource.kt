package com.prongbang.hilt.android.main.data.local

import com.prongbang.hilt.android.main.data.MainDataSource
import javax.inject.Inject

class MainLocalDataSource @Inject constructor() : MainDataSource {
	override suspend fun cowSay(): String {
		return """
  ___
< moo >
  ---
         \   ^__^ 
          \  (oo)\_______
             (__)\       )\/\
                 ||----w |
                 ||     ||
    
		"""
	}
}
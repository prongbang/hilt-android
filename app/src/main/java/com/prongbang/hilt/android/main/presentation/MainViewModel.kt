package com.prongbang.hilt.android.main.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prongbang.hilt.android.main.data.MainRepository
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
		private val mainRepository: MainRepository
) : ViewModel() {

	val cowSay = MutableLiveData<String>()

	fun hiCow() {
		viewModelScope.launch {
			cowSay.postValue("Hi cow...")
			cowSay.postValue(mainRepository.cowSay())
		}
	}

}
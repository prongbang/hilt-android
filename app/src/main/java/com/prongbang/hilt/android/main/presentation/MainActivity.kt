package com.prongbang.hilt.android.main.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.prongbang.hilt.android.R
import com.prongbang.hilt.android.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

	private val mainViewModel: MainViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
				.apply {
					lifecycleOwner = this@MainActivity
					viewModel = mainViewModel
				}
		initLoad()
	}

	private fun initLoad() {
		mainViewModel.hiCow()
	}
}
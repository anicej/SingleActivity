package com.nicej.hiltsample.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.nicej.hiltsample.api.ApiRepo

class MainViewModel @ViewModelInject constructor(var repository: ApiRepo) : ViewModel() {

    fun getPhoto(id: Int) = repository.getPhoto(id)


}
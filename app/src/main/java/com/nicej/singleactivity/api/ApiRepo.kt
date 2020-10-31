package com.nicej.hiltsample.api

import ir.sass.hilt_android.api.RemoteErrorEmitter
import ir.sass.hilt_android.api.apiCall
import javax.inject.Inject


class ApiRepo @Inject constructor(val apiService: ApiInterface, val emitter: RemoteErrorEmitter) {
    fun getPhoto(id: Int) = apiCall(emitter) { apiService.getPhoto(id) }
}
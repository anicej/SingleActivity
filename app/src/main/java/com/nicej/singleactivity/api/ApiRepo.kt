package com.nicej.singleactivity.api

import javax.inject.Inject


class ApiRepo @Inject constructor(val apiService: ApiInterface, val emitter: RemoteErrorEmitter) {
    fun getPhoto(id: Int) = apiCall(emitter) { apiService.getPhoto(id) }
}
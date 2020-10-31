package com.nicej.singleactivity.room

import com.nicej.singleactivity.api.ApiInterface
import com.nicej.singleactivity.api.RemoteErrorEmitter
import com.nicej.singleactivity.api.apiCall
import javax.inject.Inject

class BDRepo @Inject constructor(val apiService: ApiInterface, val emitter: RemoteErrorEmitter) {
    fun getPhoto(id: Int) = apiCall(emitter) { apiService.getPhoto(id) }
}
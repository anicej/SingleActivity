package com.nicej.singleactivity.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nicej.singleactivity.R
import dagger.hilt.android.AndroidEntryPoint
import ir.sass.hilt_android.api.ErrorType
import ir.sass.hilt_android.api.RemoteErrorEmitter

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), RemoteErrorEmitter {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onError(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onError(errorType: ErrorType) {
        TODO("Not yet implemented")
    }

}
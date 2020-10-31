package com.nicej.hiltsample.hilt

import android.app.Activity
import com.nicej.hiltsample.view.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import ir.sass.hilt_android.api.RemoteErrorEmitter

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {
    @Provides
    fun provideRemoteErrorEmitter(activity: Activity): RemoteErrorEmitter {
        return (activity as MainActivity)
    }
}
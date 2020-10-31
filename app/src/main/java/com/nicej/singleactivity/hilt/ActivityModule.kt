package com.nicej.singleactivity.hilt

import android.app.Activity
import com.nicej.singleactivity.api.RemoteErrorEmitter
import com.nicej.singleactivity.view.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {
    @Provides
    fun provideRemoteErrorEmitter(activity: Activity): RemoteErrorEmitter {
        return (activity as MainActivity)
    }
}
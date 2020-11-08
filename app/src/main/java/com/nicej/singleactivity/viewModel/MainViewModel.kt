package com.nicej.singleactivity.viewModel

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nicej.singleactivity.api.ApiRepo
import com.nicej.singleactivity.model.Applications
import com.nicej.singleactivity.room.ApplicationsDao
import com.nicej.singleactivity.room.ApplicationsDatabase
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
        var repository: ApiRepo,
        @ApplicationContext application: Context
) : ViewModel() {

        fun getPhoto(id: Int) = repository.getPhoto(id)

        private val applicationDao: ApplicationsDao =
                ApplicationsDatabase.getDatabase(application).applicationeDao()
        val directorList: LiveData<List<Applications>>

        init {
                directorList = applicationDao.allApplications
        }

        fun insert(applications: Array<Applications>) {
                GlobalScope.launch(Dispatchers.IO) {
                        var Long = applicationDao.insert(applications)
                }

        }


        suspend fun update(applications: Applications) {
                applicationDao.update(applications)
        }

        suspend fun deleteAll() {
                applicationDao.deleteAll()
        }
}
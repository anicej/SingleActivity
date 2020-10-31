package com.nicej.singleactivity.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nicej.singleactivity.api.ApiRepo
import com.nicej.singleactivity.model.Applications
import com.nicej.singleactivity.room.ApplicationsDao
import com.nicej.singleactivity.room.ApplicationsDatabase

class MainViewModel @ViewModelInject constructor(var repository: ApiRepo) : ViewModel() {

        fun getPhoto(id: Int) = repository.getPhoto(id)

        private val applicationDao: ApplicationsDao =
                ApplicationsDatabase.getDatabase(null).applicationeDao()
        val directorList: LiveData<List<Applications>>

        init {
                directorList = applicationDao.allApplications
        }

        suspend fun insert(vararg applications: Applications) {
//                applicationDao.insert(applications)
        }

        suspend fun update(applications: Applications) {
                applicationDao.update(applications)
        }

        suspend fun deleteAll() {
                applicationDao.deleteAll()
        }
}
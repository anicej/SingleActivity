package com.nicej.singleactivity.room

import com.nicej.singleactivity.model.Applications
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun rePopulateDb(database: ApplicationsDatabase?) {
    database?.let { db ->
        withContext(Dispatchers.IO) {
            val applicationsDao: ApplicationsDao = db.applicationeDao()


            applicationsDao.deleteAll()
            val appOne = Applications(title = "Adam McKay", description = "")
            val appTwo = Applications(title = "Denis Villeneuve", description = "")
            val appThree = Applications(title = "Morten Tyldum", description = "")
            val appFour = Applications(title = "The Big Short", description = "")
            val appFive = Applications(title = "Arrival", description = "")
            val appSix = Applications(title = "Blade Runner 2049", description = "")
            applicationsDao.insert(appOne, appTwo, appThree, appFour, appFive, appSix)
        }
    }
}
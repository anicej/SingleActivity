package com.nicej.singleactivity.room

import com.nicej.singleactivity.model.Applications
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun rePopulateDb(database: ApplicationsDatabase?) {
    database?.let { db ->
        withContext(Dispatchers.IO) {
            val applicationsDao: ApplicationsDao = db.applicationeDao()


            applicationsDao.deleteAll()
            val appOne = Applications(title = "Adam McKay", description = "", id = 0)
            val appTwo = Applications(title = "Denis Villeneuve", description = "", id = 1)
            val appThree = Applications(title = "Morten Tyldum", description = "", id = 2)
            val appFour = Applications(title = "The Big Short", description = "", id = 3)
            val appFive = Applications(title = "Arrival", description = "", id = 4)
            val appSix = Applications(title = "Blade Runner 2049", description = "", id = 5)
            var list = arrayOf<Applications>(appOne, appTwo, appThree, appFour, appFive, appSix)
            applicationsDao.insert(list)
        }
    }
}
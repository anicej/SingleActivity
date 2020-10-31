package com.nicej.singleactivity.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nicej.singleactivity.model.Applications

@Dao
interface ApplicationsDao {

    @Query("SELECT * FROM applications WHERE title = :id")
    suspend fun findApplicationById(id: String): Applications?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(
        applications: Applications,
        appTwo: Applications,
        appThree: Applications,
        appFour: Applications,
        appFive: Applications,
        appSix: Applications
    ): Long


    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(applications: Applications)

    @Query("DELETE FROM applications")
    suspend fun deleteAll()


    @get:Query("SELECT * FROM applications ORDER BY title ASC")
    val allApplications: LiveData<List<Applications>>
}
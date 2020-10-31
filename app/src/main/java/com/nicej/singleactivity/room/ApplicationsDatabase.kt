package com.nicej.singleactivity.room

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.nicej.singleactivity.model.Applications
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [Applications::class], version = 1)
abstract class ApplicationsDatabase : RoomDatabase() {

    abstract fun applicationeDao(): ApplicationsDao

    companion object {
        private var INSTANCE: ApplicationsDatabase? = null
        private const val DB_NAME = "movies.db"

        fun getDatabase(context: Context): ApplicationsDatabase {
            if (INSTANCE == null) {
                synchronized(ApplicationsDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            ApplicationsDatabase::class.java,
                            DB_NAME
                        )
                            //.allowMainThreadQueries() // Uncomment if you don't want to use RxJava or coroutines just yet (blocks UI thread)
                            .addCallback(object : Callback() {
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
                                    Log.d("ApplicationsDatabase", "populating with data...")
                                    GlobalScope.launch(Dispatchers.IO) { rePopulateDb(INSTANCE) }
                                }
                            }).build()
                    }
                }
            }

            return INSTANCE!!
        }
    }
}
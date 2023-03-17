package com.gacd.nycschool.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gacd.nycschool.model.Details

@Database(entities = arrayOf(Details::class), version = 1, exportSchema = false)
    abstract class DetailsDB : RoomDatabase() {

        abstract fun detailsDao() : DAODetails

        companion object {

            @Volatile
            private var INSTANCE: DetailsDB? = null

            fun getDatasetClient(context: Context) : DetailsDB {

                if (INSTANCE != null) return INSTANCE!!

                synchronized(this) {

                    INSTANCE = Room

                        .databaseBuilder(context, DetailsDB::class.java, "Details_DB")
                        .fallbackToDestructiveMigration()
                        .build()

                    return INSTANCE!!

                }
            }

        }

    }
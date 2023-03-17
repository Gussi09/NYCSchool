package com.gacd.nycschool.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gacd.nycschool.model.Details
import com.gacd.nycschool.model.School

@Dao
interface DAODetails {
    //Query to insert to Room DB the values of details to search after a especific value
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertData(Details: Details)

    //Query to search especific detail when the user doing click to see details.
    @Query("SELECT * FROM Details WHERE dbn =:dbn")
    fun getSchoolDetails(dbn: String?) : LiveData<Details>
}
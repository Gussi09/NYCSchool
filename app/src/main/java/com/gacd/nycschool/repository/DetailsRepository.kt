package com.gacd.nycschool.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.gacd.nycschool.model.Details
import com.gacd.nycschool.room.DetailsDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class DetailsRepository {

    companion object {

        var detailsDatabase: DetailsDB? = null

        var Details: LiveData<Details>? = null

        fun initializeDB(context: Context) : DetailsDB {
            return DetailsDB.getDatasetClient(context)
        }
        //Insert the Data to Room DB to Future Queries
        fun insertData(context: Context, dbn: String, name: String, math: String, reading: String, writing :String) {

            detailsDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                val loginDetails = Details(dbn,name,reading,math,writing)

                detailsDatabase!!.detailsDao().InsertData(loginDetails)
            }

        }
        //Get the JSON from Details in the EndPoint
        fun getDetails(context: Context, dbn: String) : LiveData<Details>? {

            detailsDatabase = initializeDB(context)

            Details = detailsDatabase!!.detailsDao().getSchoolDetails(dbn)

            return Details
        }

    }
}
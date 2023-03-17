package com.gacd.nycschool.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Data Class to See More Details Info About a School Scores According to de dbn Column.

@Entity(tableName = "Details")
data class Details (

    @ColumnInfo(name = "dbn")
    var dbn: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name= "reading")
    var reading: String,

    @ColumnInfo(name= "math")
    var math: String,

    @ColumnInfo(name= "writing")
    var writing: String


) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Int? = null

}
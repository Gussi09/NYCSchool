package com.gacd.nycschool.viewModel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gacd.nycschool.model.Details
import com.gacd.nycschool.model.School
import com.gacd.nycschool.network.ApiService
import com.gacd.nycschool.repository.DetailsRepository
import kotlinx.coroutines.launch

class schoolviewModel: ViewModel() {
    var schoolListResponse:List<School> by mutableStateOf(listOf())
    var schoolDetailResponse:List<Details> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getSchoolList(){
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val schoolList = apiService.getSchool()
                schoolListResponse = schoolList
            }
            catch (e: Exception){
                errorMessage = e.message.toString()
            }
        }
    }

    fun insertData(context: Context, dbn: String, name: String,reading:String, math:String, writing:String) {
        DetailsRepository.insertData(context,dbn,name,math, reading ,writing)
    }


    fun getSchoolDetails(){
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val schoolDetails = apiService.getDetails()
                schoolDetailResponse = schoolDetails
            }
            catch (e: Exception){
                errorMessage = e.message.toString()
            }
        }
    }

}
package com.gacd.nycschool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.gacd.nycschool.model.Details
import com.gacd.nycschool.model.School
import com.gacd.nycschool.ui.theme.NYCSchoolTheme
import com.gacd.nycschool.view.SchoolItem
import com.gacd.nycschool.view.SearchView
import com.gacd.nycschool.viewModel.schoolviewModel
import java.util.*

class MainActivity : ComponentActivity() {

    val schoolViewModel by viewModels<schoolviewModel>()
    lateinit var detailsViewModel: schoolviewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsViewModel = ViewModelProvider(this).get(schoolViewModel::class.java)
        setContent {

            NYCSchoolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    SchoolList(schoolList = schoolViewModel.schoolListResponse)
                    MainScreen()
                    schoolViewModel.getSchoolList()
                  }
            }
        }

    }
    
    
}

@Composable
fun MainScreen() {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Column {
        SearchView(textState)

    }
}

@Composable
fun SchoolList(schoolList: List<School>) {
    LazyColumn {
        itemsIndexed(items = schoolList) { index, item ->
            SchoolItem(school = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NYCSchoolTheme {
        val school = School(
            "15032023",
            "BHuviIT Solutions",
            "This is a challenge to be selected in a good project as android developer in Vistusa, I want to express my gratitude to this project, thank u so much!!",
           )

        SchoolItem(school = school )
    }
}
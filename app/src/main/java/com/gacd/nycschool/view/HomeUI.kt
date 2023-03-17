package com.gacd.nycschool.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gacd.nycschool.model.School

@Composable
fun SearchView(state: MutableState<TextFieldValue>) {
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },

        modifier = Modifier.fillMaxWidth().padding(0.dp,0.dp,0.dp,20.dp),
        textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)

            )
        },
        trailingIcon = {
            if (state.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        state.value =
                            TextFieldValue("") // Remove text from TextField when you press the 'X' icon
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        shape = RectangleShape, // The TextFiled has rounded corners top left and right by default
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            cursorColor = Color.Black,

        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun SchoolItem(school: School){

    Card(onClick = { onClick(school.dbn) },
        modifier = Modifier
            .padding(5.dp, 8.dp,5.dp,5.dp)
            .fillMaxWidth()
            .height(110.dp),
        shape = RoundedCornerShape(10.dp), elevation = CardDefaults.cardElevation(10.dp,4.dp)
    )
    {
        Surface() {
            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {

                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                )
                {

                    Text(
                        text = "School: "+ school.school_name,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text ="City: "+ school.city,

                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }

}

fun onClick(dbn : String) {


}

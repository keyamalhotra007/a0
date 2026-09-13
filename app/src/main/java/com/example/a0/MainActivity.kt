package com.example.a0

import android.R.attr.fontWeight
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a0.ui.theme.A0Theme
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight.Companion.Bold

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            A0Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color.Black
                ) { innerPadding ->
                    MainScreen( modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {



    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Details(
            ccid = "kmalhot2",
            studentID = "1868295"
        )

        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            var result by remember { mutableStateOf<Boolean?>(null) }
            var counter by remember { mutableStateOf<Int>(0) }

            Question()

            Spacer(modifier = Modifier.height(28.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    16.dp,
                    Alignment.CenterHorizontally
                )){


                OkButton(onClick = {
                    result = getResult(50)
                    counter++
                })

                MehButton(onClick = {
                    result = getResult(50)
                    counter++
                })

                NahButton(onClick = {
                    result = getResult(50)
                    counter++
                })

            }

            Text (
                text = "Click Counter: $counter",
                color = Color(0xFFF4C2C2)
            )

            Spacer(modifier = Modifier.height(40.dp))

            if (result == true) {
                Text(
                    text = "Yes :)",
                    color = Color(0xFFF4C2C2),
                    fontSize = 70.sp,
                    fontWeight = Bold
                )
            } else if (result == false) {
                Text(
                    text = "N0 :(",
                    color = Color(0xFFF4C2C2),
                    fontSize = 70.sp,
                    fontWeight = Bold
                )
            }

        }


    }
}

fun getResult(probability: Int): Boolean{
    return (1..100).random() <= probability
}

@Composable
fun Details(ccid: String, studentID: String, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Text(
            text = "CCID: $ccid",
            color = Color(0xFFF4C2C2),
            fontSize = 20.sp,
            lineHeight = 30.sp,
        )
        Text(
            text = "Student ID: $studentID",
            color = Color(0xFFF4C2C2),
            fontSize = 20.sp,
            lineHeight = 30.sp,
        )
    }
}

@Composable
fun Question(){
    Text(
        text = "Should We Go?",
        fontSize = 50.sp,
        lineHeight = 30.sp,
        color = Color(0xFFF4C2C2),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun OkButton(onClick: () -> Unit) {
    FilledTonalButton(
        onClick = { onClick() },
        colors = ButtonDefaults.filledTonalButtonColors(
            // Soft pink background (Hex: #F8BBD0)
            containerColor = Color(0xFFFFF4F2),
            // Darker pink text (Hex: #880E4F)
            contentColor = Color(0xFF880E4F)
        )
    ) {
        Text(
            text = "Ok!",
            fontSize = 30.sp
            )
    }
}

@Composable
fun MehButton(onClick: () -> Unit) {
    FilledTonalButton(
        onClick = { onClick() },
        colors = ButtonDefaults.filledTonalButtonColors(
            // Soft pink background (Hex: #F8BBD0)
            containerColor = Color(0xFFFFF4F2),
            // Darker pink text (Hex: #880E4F)
            contentColor = Color(0xFF880E4F)
        )
    ) {
        Text(
            text = "Meh",
            fontSize = 30.sp
        )
    }
}

@Composable
fun NahButton(onClick: () -> Unit) {
    FilledTonalButton(
        onClick = { onClick() },
        colors = ButtonDefaults.filledTonalButtonColors(
            // Soft pink background (Hex: #F8BBD0)
            containerColor = Color(0xFFFFF4F2),
            // Darker pink text (Hex: #880E4F)
            contentColor = Color(0xFF880E4F)
        )
    ) {
        Text(
            text = "Nah",
            fontSize = 30.sp
        )
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    A0Theme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Black
        ) { innerPadding ->
            MainScreen(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
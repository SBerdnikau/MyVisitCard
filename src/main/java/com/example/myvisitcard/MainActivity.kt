package com.example.myvisitcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myvisitcard.ui.theme.MyVisitCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyVisitCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    VisitCardApp()
                }
            }
        }
    }
}

@Composable
fun VisitCardApp() {
Column(
    Modifier
        .background(Color(78, 160, 166))
        .fillMaxSize()
) {
    MyInformation(
        painterResource(id = R.drawable.ic_main_logo),
        "Berdnikov Sergey",
        "Android Developer"
    )
    ContactsInfo( painterResource(id = R.drawable.ic_phone_logo),
        "+375-25-538-11-88",
        painterResource(id = R.drawable.ic_email_logo),
        "berdnikausiarhei@gmail.com", )
}

}

@Composable
fun MyInformation(
    logoMain: Painter,
    fullName: String,
    title: String,
    modifier : Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = logoMain,
            contentDescription = null,
            modifier = Modifier.padding(top = 60.dp, bottom = 20.dp)
        )
        Text(
            text = fullName,
            fontSize = 32.sp,
            modifier = Modifier.padding(bottom = 12.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(12.dp)
                .background(White)
        )
    }
}

@Composable
fun ContactsInfo(
    logoPhone: Painter,
    phone: String,
    logoEmail: Painter,
    email: String,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = logoPhone,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 12.dp, top = 8.dp)
            )
            Text(
                text = phone,
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(start = 12.dp,top = 8.dp, end = 12.dp, bottom = 4.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Image(
                painter = logoEmail,
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 8.dp, start = 12.dp)
            )
            Text(
                text = email,
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(top = 8.dp, end = 12.dp)
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun MyVisitCardPreview() {
    MyVisitCardTheme {
        VisitCardApp()
    }
}
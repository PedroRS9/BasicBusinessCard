package com.example.basicbusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basicbusinesscard.ui.theme.BasicBusinessCardTheme

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                BasicBusinessCardTheme {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(228, 242, 255))
                    ){
                        BasicInfo(
                            stringResource(R.string.name_text),
                            stringResource(R.string.title_text),
                            Modifier
                                .align(Alignment.Center)
                                .padding(30.dp)
                        )
                        ContactInfo(
                            "+34 677 77 66 55",
                            "@PedroRS9",
                            "pedro.romero105@alu.ulpgc.es",
                            Modifier
                                .align(Alignment.BottomCenter)
                                .padding(30.dp)
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun BasicInfo(name: String, title: String, modifier: Modifier = Modifier) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier
        ){
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = "Android logo",
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .size(100.dp)
                    .background(Color(0, 18, 154))
            )
            Text(
                text = name,
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                text = title,
                fontSize = 16.sp,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
        }
    }

    @Composable
    fun ContactInfo(phoneNumber: String, account: String, email: String, modifier: Modifier = Modifier){
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = modifier,
        ){
            Row(verticalAlignment = Alignment.CenterVertically){
                Image(painter = painterResource(id = R.drawable.ring_phone), contentDescription = "Icono de teléfono", modifier = Modifier
                    .padding(2.dp)
                    .size(23.dp))
                Text(text = phoneNumber, fontSize = 15.sp, modifier = Modifier.padding(2.dp))
            }
            Row(verticalAlignment = Alignment.CenterVertically){
                Image(painter = painterResource(id = R.drawable.gorjeo), contentDescription = "Icono de Twitter", modifier = Modifier
                    .padding(2.dp)
                    .size(23.dp))
                Text(text = account, fontSize = 15.sp, modifier = Modifier.padding(2.dp))
            }
            Row(verticalAlignment = Alignment.CenterVertically){
                Image(painter = painterResource(id = R.drawable.email), contentDescription = "Icono de email", modifier = Modifier
                    .padding(2.dp)
                    .size(23.dp))
                Text(text = email, fontSize = 15.sp, modifier = Modifier.padding(2.dp))
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        BasicBusinessCardTheme {
            Box(
                modifier = Modifier.background(Color(228, 242, 255))
            ){
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    BasicInfo(stringResource(R.string.name_text), stringResource(R.string.title_text), Modifier.padding(30.dp))
                    ContactInfo(stringResource(R.string.phone_number_text),
                        stringResource(R.string.twitter_account_text),
                        stringResource(R.string.email_text), Modifier.padding(30.dp))
                }
            }
        }
    }
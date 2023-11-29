package com.holy.jetpackcomposelogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.holy.jetpackcomposelogin.ui.theme.JetpackComposeLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}
@Composable
fun LoginScreen(

){
    var emailTextfieldValue = remember{
        mutableStateOf("")
    }
    var passwordTextfieldValue = remember{
        mutableStateOf("")
    }
    var signedUser = remember {
        mutableStateOf("")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 100.dp)
    ) {
    LoginLogo()
    SacmaText()
    EmailText()
    EmailTextField(name = emailTextfieldValue)
    Box(modifier = Modifier.height(20.dp))
    PasswordText()
    PasswordTextField(name = passwordTextfieldValue)    
    Box(modifier = Modifier.height(50.dp))
        LoginButton(signedUser,emailTextfieldValue)
        Box(modifier = Modifier.height(20.dp))
        Text(text = signedUser.value)
    }

    
}


@Composable
fun LoginButton(name: MutableState<String>,email:MutableState<String>){
    Button(onClick = {name.value = email.value}, modifier = Modifier
        .width(300.dp)
        .height(50.dp)) {
        Text(text = "Login", fontSize = 18.sp)
    }
}
@Composable
fun EmailText(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 60.dp),
        contentAlignment = Alignment.CenterStart){
        Text(text = "Email")

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(name:  MutableState<String>){
    TextField(
        
        value = name.value, onValueChange ={newValue-> name.value = newValue} )
}
@Composable
fun PasswordText(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 60.dp),
        contentAlignment = Alignment.CenterStart){
        Text(text = "Password")

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextField(name:  MutableState<String>){
    TextField(value = name.value, onValueChange ={newValue-> name.value = newValue} )
}

@Composable
fun SacmaText(){
    Text(
        modifier = Modifier.padding(vertical = 10.dp),
        text = "Geleceğe Köprü!",
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun LoginLogo(){
    Box(
        modifier = Modifier
            .width(120.dp)
            .height(120.dp),
        )
    {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logom")
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginPreview(){
    LoginScreen()
}


package com.example.gym

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gym.ui.theme.GYMTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginupScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var isEmailValid by remember { mutableStateOf(true) }
    var isPasswordValid by remember { mutableStateOf(true) }

    val context = LocalContext.current
    val color = colorResource(R.color.purple_500)
    val sign_in_c = colorResource(R.color.sign_in_color)

    val focusManager = LocalFocusManager.current
    Box(modifier = Modifier.fillMaxSize()
        .pointerInput(Unit) {
            detectTapGestures(onTap = {
                focusManager.clearFocus() // This will hide the keyboard
            })
        }) {
        Image(
            painter = painterResource(id = R.drawable.startedpage3), // Your sign-up background image
            contentDescription = "Sign Up Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Log in",
                fontSize = 30.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 70.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField( value = email,
                onValueChange = { email = it },
                label = { Text("Email",color = Color.White) },
                shape = androidx.compose.foundation.shape.RoundedCornerShape(50.dp),
                modifier = Modifier.padding(bottom = 10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedBorderColor = if (isEmailValid) Color.Cyan else Color.Red,
                    unfocusedBorderColor = if (isEmailValid) Color.White else Color.Red,
                    containerColor = Color.Black.copy(alpha = 0.5f)),
            )
            if (!isEmailValid) {
                Text("Username is required", color = Color.Red, fontSize = 12.sp)
            }
            OutlinedTextField( value = password,
                onValueChange = { password = it },
                label = { Text("password",color = Color.White) },
                shape = androidx.compose.foundation.shape.RoundedCornerShape(50.dp),
                modifier = Modifier.padding(bottom = 10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedBorderColor = if (isPasswordValid) Color.Cyan else Color.Red,
                    unfocusedBorderColor = if (isPasswordValid) Color.White else Color.Red,
                    containerColor = Color.Black.copy(alpha = 0.5f)),

            )
            if (!isPasswordValid) {
                Text("Username is required", color = Color.Red, fontSize = 12.sp)
            }
            //----------------------------------------------------------------------------------------------
            Button(onClick = { navController.navigate("m_page1")
                isEmailValid = email.isNotBlank()
                isPasswordValid = password.isNotBlank()
            }, modifier = Modifier.size(width =  200.dp, height = 40.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = color),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(100.dp)) {
                Text(text ="sign up",modifier = Modifier.size(40.dp))
            }

            Spacer(modifier = Modifier.height(10.dp))


            Text(text ="----   or   ----",color = Color.White)

            Spacer(modifier = Modifier.height(10.dp))

            Row(modifier = Modifier.height(50.dp)) {
                IconButton(onClick = {
                    val googleSignInUrl = "https://accounts.google.com/signup" // Or your specific sign-in URL
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(googleSignInUrl))
                    context.startActivity(intent)
                }) {
                    //Icon
                    Image(painterResource(id = R.drawable.google_icon),
                        contentDescription = "Google",
                        modifier = Modifier.height(158.dp)
                            .size( 30.dp))
                }
                IconButton(onClick = {
                    val facebookSignInUrl = "https://www.facebook.com/signup" // Or your specific sign-in URL
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(facebookSignInUrl))
                    context.startActivity(intent) // Use context.startActivity
                }) {
                    //Icon
                    Image(painterResource(id = R.drawable.facebook_icon),
                        contentDescription = "Facebook",
                        modifier = Modifier.height(158.dp)
                            .size( 30.dp))
                }
            }

            Spacer(modifier = Modifier.height(5.dp))
            Row {
                Text(
                    text = "If you have an account? ",
                    color = Color.White
                )
                Text(text = "Sign In" , color = sign_in_c,modifier = Modifier
                    .padding(start = 4.dp)
                    .clickable {
                        navController.navigate("Signing")
                    }
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LoginupScreenPreview() {
    GYMTheme {
        val navController = rememberNavController() // Create a NavController
        LoginupScreen(navController = navController)
    }

}
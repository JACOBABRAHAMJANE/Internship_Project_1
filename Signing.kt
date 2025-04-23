package com.example.gym
// STILL MORE WORK TO DO IN THIS FILE on equalozation and database integration
import android.content.Intent

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.gym.ui.theme.GYMTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var isUsernameValid by remember { mutableStateOf(true) }
    var isEmailValid by remember { mutableStateOf(true) }
    var isPasswordValid by remember { mutableStateOf(true) }
    var isConfirmPasswordValid by remember { mutableStateOf(true) }

    val context = LocalContext.current
    val color = colorResource(R.color.purple_500)
    val loginc = colorResource(R.color.login_color)
    val focusManager = LocalFocusManager.current
    Box(modifier = Modifier.fillMaxSize()
        .pointerInput(Unit) {
            detectTapGestures(onTap = {
                focusManager.clearFocus()
            })
        }
    ) {
        Image(
            painter = painterResource(id = R.drawable.startedpage2), // Your sign-up background image
            contentDescription = "Sign Up Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize(),

        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Sign Up",
                fontSize = 30.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 70.dp)

            )

            Spacer(modifier = Modifier.height(16.dp))
            //focusedTextColor = androidx.compose.ui.graphics.Color.White,
//---------------------------------------------------------------
            OutlinedTextField(value = username,
                onValueChange = { username = it
                    isUsernameValid = true
                                },
                isError = !isUsernameValid,
                label = {Text(text = "username",color = Color.White)},
                placeholder = { Text("Type here", color = Color.White)},
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedBorderColor = if (isUsernameValid) Color.Cyan else Color.Red,
                    unfocusedBorderColor = if (isUsernameValid) Color.White else Color.Red,
                    containerColor = Color.Black.copy(alpha = 0.5f)),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(50.dp),
                modifier = Modifier.padding(bottom = 10.dp)

               // colors = TextFieldDefaults.colors(cursorColor = androidx.compose.ui.graphics.Color.White)
            )
            if (!isUsernameValid) {
                Text("Username is required", color = Color.Red, fontSize = 12.sp)
            }

            OutlinedTextField(value = email,
                onValueChange = {email = it
                    isEmailValid = true},
                isError = !isEmailValid,
                label = { Text(text ="Email",color = Color.White) },
                placeholder = { Text("Type here", color = Color.White)},
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedBorderColor = if (isEmailValid) Color.Cyan else Color.Red,
                    unfocusedBorderColor =if (isEmailValid) Color.White else Color.Red,
                    containerColor = Color.Black.copy(alpha = 0.5f)),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(50.dp),
                modifier = Modifier.padding(bottom = 10.dp)
            )


            if (!isEmailValid) {
                Text("Email is required", color = Color.Red, fontSize = 12.sp)
            }

            OutlinedTextField(value = password,
                onValueChange = {password = it
                    isPasswordValid = true},
                isError = !isPasswordValid,
                label = { Text(text ="password",color = Color.White) },
                placeholder = { Text("Type here", color = Color.White)},
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedBorderColor = if (isPasswordValid) Color.Cyan else Color.Red,
                    unfocusedBorderColor = if (isPasswordValid) Color.White else Color.Red,
                    containerColor = Color.Black.copy(alpha = 0.5f)),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(50.dp),
                modifier = Modifier.padding(bottom = 10.dp)
                // colors = TextFieldDefaults.colors(cursorColor = androidx.compose.ui.graphics.Color.White)
            )

            if (!isPasswordValid) {
                Text("Password is required", color = Color.Red, fontSize = 12.sp)
            }

            OutlinedTextField(value = confirmPassword,
                onValueChange = { confirmPassword = it
                    isConfirmPasswordValid = true},
                isError = !isConfirmPasswordValid,
                label = { Text(text ="confirm password",color = Color.White) },
                placeholder = { Text("Type here", color = Color.White)},
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedBorderColor = if (isConfirmPasswordValid) Color.Cyan else Color.Red,
                    unfocusedBorderColor = if (isConfirmPasswordValid) Color.White else Color.Red,
                    containerColor = Color.Black.copy(alpha = 0.5f)),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(50.dp),
                modifier = Modifier.padding(bottom = 10.dp)
                // colors = TextFieldDefaults.colors(cursorColor = androidx.compose.ui.graphics.Color.White)
            )

            if (!isConfirmPasswordValid) {
                Text("Confirm Password is required", color = Color.Red, fontSize = 12.sp)
            }
            //-----------------------------------------------------------------------------
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                isUsernameValid = username.isNotBlank()
                isEmailValid = email.isNotBlank()
                isPasswordValid = password.isNotBlank()
                isConfirmPasswordValid = confirmPassword.isNotBlank()

                if (isUsernameValid && isEmailValid && isPasswordValid && isConfirmPasswordValid) {
                    // Proceed with sign-up logic
                    navController.navigate("option_start")
                }
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
                Text(text = "Log In", color = loginc,
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .clickable {
                            navController.navigate("login")
                        }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SigningPreview() {
    GYMTheme {
        val navController = rememberNavController() // Create a NavController
        SignUpScreen(navController = navController)
    }

}
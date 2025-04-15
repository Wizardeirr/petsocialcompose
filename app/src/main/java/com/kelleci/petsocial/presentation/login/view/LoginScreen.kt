package com.kelleci.petsocial.presentation.login.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kelleci.petsocial.R
import com.kelleci.petsocial.Screen
import com.kelleci.petsocial.util.Constants

@Composable
fun LoginScreen(
    navController: NavController,
    submit: () -> Unit,
    modifier: Modifier = Modifier

) {
    var userNameValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    ) {
        TextField(
            value = userNameValue,
            onValueChange = { newValue ->
                userNameValue = newValue
            },
            modifier = modifier,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            keyboardActions = KeyboardActions(
                onDone = { submit() }
            ),
            label = { Text("Kullanıcı Adı") },

            singleLine = true,
            shape = RoundedCornerShape(9.dp),
            maxLines = 1,

            )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = passwordValue,
            onValueChange = {
                passwordValue = it
            },
            modifier = modifier,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            keyboardActions = KeyboardActions(
                onDone = { submit() }
            ),
            label = {
                Text("Şifre")
            },
            singleLine = true,
            shape = RoundedCornerShape(9.dp),
            maxLines = 1,
            supportingText = {
                if (passwordValue != "") {
                    Text("Şifre en az 6 haneli, 1 küçük ve 1 büyük harf içermelidir")
                }
            },
            isError = passwordValue.isNotEmpty() && !isValidPassword(passwordValue)

        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(modifier = modifier.fillMaxWidth(), onClick = {
            println("giriş yap")
        }) {
            Text("Giriş Yap")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(modifier = modifier.fillMaxWidth(), onClick = {
//            if (userNameValue.isNotEmpty() && passwordValue.isNotEmpty() && isValidPassword(
//                    passwordValue
//                )
//            ) {
//                println("Kayıt başarılı")
//            } else {
//                println("Kayıt başarısız")
//            }
            navController.navigate(Screen.RegisterScreen.route)
        }) {
            Text("Kayıt Ol")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(modifier = Modifier.fillMaxWidth(), onClick = {

        }) {
            Icon(painter = painterResource(R.drawable.google), "", modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text("Google İle Giriş Yap")

        }
    }
}

fun isValidPassword(password: String): Boolean {
    val regex = Constants.PASSWORD_VALID_RULE.toRegex()
    return password.matches(regex)
}
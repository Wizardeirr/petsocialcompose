package com.kelleci.petsocial.presentation.login.telephonelogin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kelleci.petsocial.Screen

@Preview
@Composable
fun TelephoneLogin(
    modifier: Modifier = Modifier,
    navController: NavController = NavController(LocalContext.current)
) {
    var telephoneNumber = ""
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        TextField(
            value = telephoneNumber,
            onValueChange = { newValue ->
                telephoneNumber = newValue
            },
            modifier = modifier,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            label = { Text("Telefon Numarası") },
            singleLine = true,
            shape = RoundedCornerShape(9.dp),
            maxLines = 1,

            )
        Spacer(modifier = Modifier.height(16.dp))

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            navController.navigate(Screen.TelephoneLoginScreen.route)

        }) {
            Spacer(modifier = Modifier.width(10.dp))
            Text("Devam")

        }
    }
}
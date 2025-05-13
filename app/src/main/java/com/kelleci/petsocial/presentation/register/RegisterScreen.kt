package com.kelleci.petsocial.presentation.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview
@Composable
fun RegisterScreen(
) {
    var userID by remember { mutableStateOf("") }
    var userPetName by remember { mutableStateOf("") }
    val userPetSpecies by remember { mutableStateOf(false) }
    var userPetGenius by remember { mutableStateOf("") }
    var userPetKg by remember { mutableStateOf("") }
    var userPetAge by remember { mutableStateOf("") }
    var userPetVaccine by remember { mutableStateOf("") }
    var userMailAddress by remember { mutableStateOf("") }
    val userPassword by remember { mutableStateOf("") }
    val userPetSpay by remember { mutableStateOf(false) }
    var selectedPet by remember { mutableStateOf(RegisterConstant.petGenius[0]) }
    var selectedPetSpay by remember { mutableStateOf(RegisterConstant.petSpay[0]) }
    val context = LocalContext.current
    val registerViewModel: RegisterViewModel = viewModel()


    LaunchedEffect(key1 = Unit){

        registerViewModel.loading.collect{
            if (it){

            }
        }

    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally,
        modifier = Modifier
            .padding(1.dp)
            .fillMaxSize()
    ) {

        TextField(
            value = userID,
            onValueChange = { newValue ->
                userID = newValue
            },
            modifier = Modifier,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            keyboardActions = KeyboardActions(),
            label = { Text("Kullanıcı Adı") },
            singleLine = true,
            shape = RoundedCornerShape(9.dp),
            maxLines = 1,

            )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = userPetName,
            onValueChange = { newValue ->
                userPetName = newValue
            },
            modifier = Modifier,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            keyboardActions = KeyboardActions(),
            label = { Text("Evcil Hayvanızın Adı") },

            singleLine = true,
            shape = RoundedCornerShape(9.dp),
            maxLines = 1,

            )
        Spacer(modifier = Modifier.height(16.dp))
        RegisterConstant.petGenius.forEach { text ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedPet),
                        onClick = { selectedPet = text })
                    .padding(10.dp)
            }
            Text(
                text = text,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = userPetGenius,
            onValueChange = { newValue ->
                userPetGenius = newValue
            },
            modifier = Modifier,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            keyboardActions = KeyboardActions(),
            label = { Text("Evcil Hayvanınızın Cinsi") },
            singleLine = true,
            shape = RoundedCornerShape(9.dp),
            maxLines = 1,

            )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = userPetKg,
            onValueChange = { newValue ->
                userPetKg = newValue
            },
            modifier = Modifier,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            keyboardActions = KeyboardActions(),
            label = { Text("Kilosu") },

            singleLine = true,
            shape = RoundedCornerShape(9.dp),
            maxLines = 1,

            )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = userPetAge,
            onValueChange = { newValue ->
                userPetAge = newValue
            },
            modifier = Modifier,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            keyboardActions = KeyboardActions(),
            label = { Text("Yaşı") },

            singleLine = true,
            shape = RoundedCornerShape(9.dp),
            maxLines = 1,

            )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = userPetVaccine,
            onValueChange = { newValue ->
                userPetVaccine = newValue
            },
            modifier = Modifier,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            keyboardActions = KeyboardActions(),
            label = { Text("Aşı Durumu") },
            singleLine = true,
            shape = RoundedCornerShape(9.dp),
            maxLines = 1,

            )

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = userMailAddress,
            onValueChange = { newValue ->
                userMailAddress = newValue
            },
            modifier = Modifier,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Email
            ),
            keyboardActions = KeyboardActions(),
            label = { Text("E-posta") },
            singleLine = true,
            shape = RoundedCornerShape(9.dp),
            maxLines = 1,

            )
        Spacer(modifier = Modifier.height(16.dp))

        RegisterConstant.petSpay.forEach { text ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(9.dp)
            ) {
                RadioButton(
                    selected = (text == selectedPetSpay),
                    onClick = { selectedPetSpay = text },
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterVertically)
                )
            }
            Text(
                text = text,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .align(CenterHorizontally)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            registerViewModel.saveUserRegisterInfo(
                userID = userID,
                userPetName = userPetName,
                userPetGenius = userPetGenius,
                userPetKg = userPetKg,
                userPetAge = userPetAge,
                userPetVaccine = userPetVaccine,
                userPetSpecies = userPetSpecies,
                userPetSpay = userPetSpay,
                context = context,
                userEmail = userMailAddress,
                userPassword = userPassword

            )
        }) {
            Spacer(modifier = Modifier.width(10.dp))
            Text("Devam")
        }
    }


}
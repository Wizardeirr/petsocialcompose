package com.kelleci.petsocial.presentation.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelleci.petsocial.data.UserRegister
import java.util.UUID

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
    val userPetSpay by remember { mutableStateOf(false) }
    var selectedPet by remember { mutableStateOf(RegisterConstant.petGenius[0]) }
    var selectedPetSpay by remember { mutableStateOf(RegisterConstant.petSpay[0]) }

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

        RegisterConstant.petSpay.forEach { text ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedPetSpay),
                        onClick = { selectedPetSpay = text })
                    .padding(10.dp)
            }
            Text(
                text = text,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            saveUserRegisterInfo(
                userID,
                userPetName,
                userPetGenius,
                userPetKg,
                userPetAge,
                userPetVaccine,
                userPetSpecies,
                userPetSpay
            )
        }) {
            Spacer(modifier = Modifier.width(10.dp))
            Text("Devam")
        }
    }


}

fun saveUserRegisterInfo(
    userID: String, userPetName: String, userPetGenius: String, userPetKg: String,
    userPetAge: String,
    userPetVaccine: String,
    userPetSpecies: Boolean,
    userPetSpay: Boolean
) {
    if (userID.isNotEmpty() &&
        userPetName.isNotEmpty() &&
        userPetGenius.isNotEmpty() &&
        userPetKg.isNotEmpty() &&
        userPetAge.isNotEmpty() &&
        userPetVaccine.isNotEmpty()
    ) {
        val userRegister = UserRegister(
            userID = userID,
            userPetSpecies = userPetSpecies,
            userPetGenius = userPetGenius,
            userPetKg = userPetKg,
            userPetAge = userPetAge,
            userPetVaccine = userPetVaccine,
            userPetSpay = userPetSpay,
            userPetName = userPetName,
            userUUID = UUID.randomUUID()
        )

        //viewModel.saveRegisterInformation(userRegister)
    }else{

    }
}
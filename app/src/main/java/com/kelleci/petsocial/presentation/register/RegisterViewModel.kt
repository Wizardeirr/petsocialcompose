package com.kelleci.petsocial.presentation.register

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.kelleci.petsocial.data.UserRegister
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.UUID

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerRepository: RegisterRepository,
    private val firebaseAuth: FirebaseAuth
) : ViewModel() {
    private val _errorMessage: MutableStateFlow<String> = MutableStateFlow("")
    val errorMessage :StateFlow<String> get() = _errorMessage

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading :StateFlow<Boolean> get() = _loading

    private val _userRegister: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val userRegister :StateFlow<Boolean> get() = _userRegister

    fun saveUserRegisterInfo(
        userID: String, userPetName: String, userPetGenius: String, userPetKg: String,
        userPetAge: String,
        userPetVaccine: String,
        userPetSpecies: Boolean,
        userPetSpay: Boolean,
        context: Context,
        userEmail: String,
        userPassword: String,
    ) {
        _loading.value = true
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
            val userRegisterValue = registerRepository.registerUser(userRegister, firebaseAuth, userEmail, userPassword)
            userRegisterValue.let {
                _loading.value = false
                _userRegister.value = true
            }
        } else {
            Toast.makeText(
                context, "Please check your informations", Toast.LENGTH_SHORT
            ).show()
        }
    }
}
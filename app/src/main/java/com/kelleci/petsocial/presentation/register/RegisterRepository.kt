package com.kelleci.petsocial.presentation.register

import com.google.firebase.auth.FirebaseAuth
import com.kelleci.petsocial.data.UserRegister
import com.kelleci.petsocial.util.Resource

interface RegisterRepository {
    fun registerUser(
        userRegister: UserRegister,
        auth: FirebaseAuth,
        userEmail: String,
        userPassword: String
    ): Resource<UserRegister>
}
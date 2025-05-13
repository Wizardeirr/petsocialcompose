package com.kelleci.petsocial.presentation.register

import com.google.firebase.auth.FirebaseAuth
import com.kelleci.petsocial.data.UserRegister
import com.kelleci.petsocial.util.Resource

class RegisterRepositoryImpl: RegisterRepository {
    override fun registerUser(userRegister: UserRegister, auth:FirebaseAuth, userEmail: String, userPassword: String): Resource<UserRegister> {
        var valueOfSuccess = false
        auth.createUserWithEmailAndPassword(userEmail, userPassword).addOnSuccessListener {
            auth.currentUser?.let {
                userRegister.userID = it.uid
                valueOfSuccess = true
            }
        }
        return if (valueOfSuccess){
             Resource.Success(userRegister)
        }else{
            return Resource.Error("Kullanıcı kayıt olamadı")
        }

    }
}
package com.kelleci.petsocial.presentation.login.telephonelogin

interface TelephoneLoginRepository {

    fun telephoneAuthStart(telephoneNumber: String)
}
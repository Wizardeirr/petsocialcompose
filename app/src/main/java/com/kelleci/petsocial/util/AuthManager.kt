package com.kelleci.petsocial.util

import android.app.Activity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

object AuthManager {
    fun telephoneNumberAuth(activity: Activity, phoneNumber: String, auth: FirebaseAuth, callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks){
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(activity) // Activity (for callback binding)
            .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
            .build()
        auth.setLanguageCode("tr")
        PhoneAuthProvider.verifyPhoneNumber(options)
    }
}
package com.kelleci.petsocial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kelleci.petsocial.presentation.login.telephonelogin.TelephoneLogin
import com.kelleci.petsocial.presentation.login.view.LoginScreen
import com.kelleci.petsocial.presentation.register.RegisterScreen
import com.kelleci.petsocial.ui.theme.PetsocialTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            PetsocialTheme {
                val navHostController = rememberNavController()
                NavHost(navController = navHostController, startDestination = Screen.LoginScreen.route){

                    composable(route = Screen.LoginScreen.route){
                        LoginScreen(navHostController, {}, Modifier.fillMaxWidth())
                    }
                    composable(route = Screen.RegisterScreen.route) {
                        RegisterScreen()
                    }
                    composable(route = Screen.TelephoneLoginScreen.route) {
                        TelephoneLogin(Modifier,navHostController)
                    }


                }
            }
        }
    }
}

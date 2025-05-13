package com.kelleci.petsocial.data

import java.util.UUID

data class UserRegister(
    var userID: String,
    val userPetName : String,
    val userPetSpecies: Boolean,
    val userPetGenius : String,
    val userPetKg : String,
    val userPetAge : String,
    val userPetVaccine: String,
    val userPetSpay: Boolean,
    val userUUID : UUID
)

package com.example.mindgeek_test.navigation

import java.io.Serializable

sealed class Destination : Serializable {
    object UP : Destination()
    object NEXT : Destination()
    object MAIN : Destination()
    object PASSWORD_MANAGEMENT : Destination()
    object CREATE_PASSWORD : Destination()
    object REQUEST_PASSWORD : Destination()
    object ALERT_LOCKED : Destination()
}
package com.petros.efthymiou.dailypulse.android.screens

enum class Screens : Route {
    ARTICLES {
        override val destination: String get() = "reminders"
    },
    ABOUT_DEVICE {
        override val destination: String get() = "about-device"
    };
}
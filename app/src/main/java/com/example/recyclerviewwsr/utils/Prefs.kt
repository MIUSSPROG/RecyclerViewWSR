package com.example.recyclerviewwsr.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class Prefs(context: Context) {

    companion object{
        private const val PREFS_NAME = "myPrefs"
        private const val KEY_LOGIN = "login"
    }

    private val sharedPref: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    var myLogin: String
        get() = sharedPref.getString(KEY_LOGIN, "") ?: ""
        set(value) = sharedPref.edit { putString(KEY_LOGIN, value) }
}
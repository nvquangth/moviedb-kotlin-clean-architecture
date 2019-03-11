package com.clean.data.local.pref

import android.content.Context
import com.google.gson.Gson

class AppPrefs constructor(context: Context, gson: Gson) : PrefHelper {

    private val sharedPreferences =
        context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    companion object {
        private const val FIRST_RUN = "first_run"
    }

    override fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}
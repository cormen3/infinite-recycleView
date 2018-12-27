package ir.cobal.data.local.preference

import android.content.Context
import android.content.SharedPreferences

class PreferenceService constructor(var context: Context) {
    private val KEY_USERNAME = "USER_NAME"

    companion object {
        private var sharedPreferences: SharedPreferences? = null
    }

    fun clearPreferences() {
        sharedPreferences!!.edit().clear().apply()
    }

    fun setUserName(userName: String) {
        val editor = sharedPreferences!!.edit()
        editor.putString(KEY_USERNAME, userName)
        editor.apply()
    }

    fun clearUserName() {
        val editor = sharedPreferences!!.edit()
        editor.remove(KEY_USERNAME)
        editor.apply()
    }

}
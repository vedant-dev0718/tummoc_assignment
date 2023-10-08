package vedant.tiwari.tummoc_assignment.ulities

import android.content.Context
import android.content.SharedPreferences
import vedant.tiwari.tummoc_assignment.ulities.Constants.SHARED_PREFERENCE

object SharedPreference {

    class Prefs(context: Context) {
        private val preferences: SharedPreferences = context.getSharedPreferences(
            SHARED_PREFERENCE, Context.MODE_PRIVATE
        )

        fun saveString(key: String, value: String) {
            val editor: SharedPreferences.Editor = preferences.edit()
            editor.putString(key, value)
            editor.apply()
        }

        fun readString(key: String): String? {
            return preferences.getString(key, "")
        }

    }
}
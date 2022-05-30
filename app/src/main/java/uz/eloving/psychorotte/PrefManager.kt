package uz.eloving.psychorotte

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

private const val CACHE_NAME = "app"
private const val PASSWORD = "password"
private const val SETNEWPASSWORD = "setnewpassword"
private const val TOGGLE = "toggle"
private const val DELETED = "deleted"
private const val NAME = "name"
private const val ASKPASSWORD = "askpassword"

class PrefManager {
    companion object {
        private fun getInstance(ctx: Context): SharedPreferences {
            return ctx.getSharedPreferences(CACHE_NAME, Context.MODE_PRIVATE)
        }

        fun setPassword(ctx: Context, password: String) {
            getInstance(ctx).edit().putString(PASSWORD, password).apply()
        }

        fun setNewPassword(ctx: Context, action: Boolean) {
            getInstance(ctx).edit().putBoolean(SETNEWPASSWORD, action).apply()
        }

        fun setToggle(ctx: Context, action: Boolean) {
            getInstance(ctx).edit().putBoolean(TOGGLE, action).apply()
        }

        fun setDeleted(ctx: Context, action: Boolean) {
            getInstance(ctx).edit().putBoolean(DELETED, action).apply()
        }

        fun setName(ctx: Context, name: String) {
            getInstance(ctx).edit().putString(NAME, name).apply()
        }

        fun setAskPassword(ctx: Context, action: Boolean) {
            getInstance(ctx).edit().putBoolean(ASKPASSWORD, action).apply()
        }

        fun getAskPassword(ctx: Context): Boolean {
            return getInstance(ctx).getBoolean(ASKPASSWORD, false)
        }

        fun getSetNewPassword(ctx: Context): Boolean {
            return getInstance(ctx).getBoolean(SETNEWPASSWORD, false)
        }

        fun getPassword(ctx: Context): String? {
            return getInstance(ctx).getString(PASSWORD, "password")
        }

        fun getName(ctx: Context): String? {
            return getInstance(ctx).getString(NAME, "Boss")
        }

        fun getToggle(ctx: Context):Boolean{
            return getInstance(ctx).getBoolean(TOGGLE, false)
        }

        fun setHighScore(ctx: Context, highScore:Int){
            getInstance(ctx).edit().putInt("highscore", highScore).apply()
        }

        fun getHighScore(ctx: Context):Int{
            return getInstance(ctx).getInt("highscore", 0)
        }
    }
}
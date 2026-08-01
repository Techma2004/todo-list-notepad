package com.techma2004.todolist

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import android.util.Base64
import java.security.SecureRandom

object SecureKeyStore {
    private const val PREFS_NAME = "secure_prefs"
    private const val KEY_DB = "db_key"

    fun getOrCreateDbKey(context: Context): ByteArray {
        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        val prefs = EncryptedSharedPreferences.create(
            context,
            PREFS_NAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        var base64 = prefs.getString(KEY_DB, null)
        if (base64 == null) {
            val key = ByteArray(32)
            SecureRandom().nextBytes(key)
            base64 = Base64.encodeToString(key, Base64.NO_WRAP)
            prefs.edit().putString(KEY_DB, base64).apply()
        }
        return Base64.decode(base64, Base64.NO_WRAP)
    }
}

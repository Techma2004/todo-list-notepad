package com.techma2004.todolist.auth

import android.app.Activity
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import java.util.concurrent.Executor

class BiometricUnlock(private val activity: Activity) {
    private val executor: Executor = ContextCompat.getMainExecutor(activity)

    fun prompt(onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Unlock Encrypted Data")
            .setSubtitle("Use biometric to unlock the encrypted database")
            .setDeviceCredentialAllowed(true)
            .build()

        val biometricPrompt = BiometricPrompt(activity, executor, object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                onSuccess()
            }

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                onFailure(errString.toString())
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                onFailure("Authentication failed")
            }
        })

        biometricPrompt.authenticate(promptInfo)
    }
}

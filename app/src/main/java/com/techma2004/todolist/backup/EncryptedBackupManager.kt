package com.techma2004.todolist.backup

import android.content.Context
import androidx.security.crypto.MasterKey
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.EncryptedFile.Builder
import java.io.File

object EncryptedBackupManager {
    // Creates an encrypted backup file containing the app's database bytes.
    // The backup file is stored under context.filesDir/backup/.
    fun createEncryptedBackup(context: Context, outputFileName: String = "todo_backup.enc"): File {
        val dbFile = context.getDatabasePath("encrypted_todo.db")
        val backupDir = File(context.filesDir, "backup").apply { if (!exists()) mkdirs() }
        val outFile = File(backupDir, outputFileName)

        // Use MasterKey to create EncryptedFile wrapper
        val masterKey = MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build()

        val encryptedFile = EncryptedFile.Builder(
            context,
            outFile,
            masterKey,
            EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
        ).build()

        // Copy raw DB bytes into encrypted file
        dbFile.inputStream().use { fis ->
            encryptedFile.openFileOutput().use { fos ->
                fis.copyTo(fos)
            }
        }

        return outFile
    }

    // Restore will overwrite the DB from an encrypted backup file (caller must handle permissions)
    fun restoreEncryptedBackup(context: Context, inputFile: File) {
        val dbFile = context.getDatabasePath("encrypted_todo.db")
        val masterKey = MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build()

        val encryptedFile = EncryptedFile.Builder(
            context,
            inputFile,
            masterKey,
            EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
        ).build()

        encryptedFile.openFileInput().use { fis ->
            dbFile.outputStream().use { fos ->
                fis.copyTo(fos)
            }
        }
    }
}

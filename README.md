# Encrypted Todo + Notepad (Scaffold)

This repository contains a scaffold for an Android app (Kotlin + Jetpack Compose) that provides:

- Encrypted storage (SQLCipher + Room) protected by a randomly-generated key stored with AndroidX Security (MasterKey + EncryptedSharedPreferences)
- Todo list with embedded notepad per item
- Internal calendar view (in-app)
- Alarm system using AlarmManager + BroadcastReceiver
- Biometric gating sketch (BiometricPrompt integration points)

How to build
1. Open the project in Android Studio (Arctic Fox or later).
2. Let Gradle sync; it will download dependencies.
3. Build and run on a device or emulator (minSdk 24 in scaffold).

Notes
- This is a scaffold: it includes core wiring and examples (entities, DAOs, DB, key storage, alarm wiring, and a minimal Compose UI). It's not a full production app yet.
- Do not ship without proper testing, migrations, and removing fallbackToDestructiveMigration.

Branch: feature/encrypted-todo-scaffold


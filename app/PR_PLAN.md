This PR will add improvements and optional features to the scaffold:

Planned improvements:
- Add Application class to initialize DB, notification channels, and reschedule alarms on boot.
- Wire a basic ViewModel using Kotlin coroutines + Flow for Todos and Notes.
- Add Biometric gating at app startup to unlock DB key.
- Create proper notification channel on app startup.
- Add Room migrations placeholder.

Optional features to implement in this PR:
- Encrypted cloud backup (local export encrypted with wrapped key) - no server credentials required; produces a local encrypted backup file under app files.
- Simple home screen App Widget showing next todo (limited to scaffold demo).
- Better Gradle versions and dependency stability updates.

I will add these changes and then open the PR with a detailed description and checklist.

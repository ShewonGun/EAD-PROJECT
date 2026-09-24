# EAD-PROJECT

Skeleton for the SE4040 group project — a fresh, unmodified starting point
for the backend, frontend and mobile app. Nothing here is implemented yet;
each member builds their assigned slice on top of this.

## Layout

```
EAD-PROJECT/
├── backend/SmartMicrogrid/     dotnet new webapi (ASP.NET Core 8, controllers)
├── frontend/                   npm create vite@latest -- --template react
└── mobile/EADProject/          Android, Kotlin + Jetpack Compose, Empty Activity
```

## One manual step for mobile

The Gradle wrapper's binary jar (`gradle/wrapper/gradle-wrapper.jar`) isn't
included — it can't be hand-written, and generating it needs either Android
Studio or a local Gradle install. Before `mobile/EADProject` will build:

1. Open `mobile/EADProject` in Android Studio.
2. Let it sync — Android Studio detects the missing wrapper jar and offers
   to regenerate it automatically. Accept the prompt (or run **File → Sync
   Project with Gradle Files** if it doesn't appear on its own).

Everything else — backend and frontend — runs immediately with `dotnet run`
and `npm install && npm run dev` respectively, no extra setup.

## Renaming things

- Backend project name: `SmartMicrogrid.Api` (change via find-and-replace if
  you want something else — nothing else depends on this name yet).
- Mobile package: `com.example.eadproject` — rename via Android Studio's
  **Refactor → Rename** on the package, which updates every reference safely.

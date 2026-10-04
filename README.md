# VoltShare

Smart Solar Microgrid Trading System — SE4040 Enterprise Application
Development group project.

**Group:** J26-SE-78

## Individual contribution

| Member | Student ID | Contribution |
|---|---|---|
| Shewon Gunarathne | IT22144744 | Microgrid Node Management (web) — hubs, GPS, capacity, battery slots, schedule, deactivate. Maps (mobile) — nearby grid nodes, from "Dashboard & Maps". Operator Mode (mobile) — scan prosumer QR. |
| Kinara Hemachandra | IT23431126 | Prosumer Management (web) — NIC-keyed prosumer CRUD, deactivate/reactivate. Prosumer Account Control (mobile) — register with NIC, edit profile, request deactivation. |
| Aseni Thennakoon | IT23390928 | Energy Slot Reservation Management (web) — create/update/cancel, 7-day window, 12-hour notice. Reservation & QR Dispatch (mobile) — reserve/modify/cancel a slot, generate transaction QR once approved. |
| Mahen Perera | IT23201750 | User Management (web) — Backoffice and Grid Operator accounts. Dashboard (web & mobile) — active/pending counts, booking history, pending booking, search booking, from "Dashboard & Maps". |

## Layout

```
EAD-PROJECT/
├── backend/SmartMicrogrid/     ASP.NET Core 8 Web API
├── frontend/                   React 19 + Vite + Tailwind
└── mobile/EADProject/          Android, Kotlin + Jetpack Compose
```

## Setup

### Prerequisites

- [.NET 8 SDK](https://dotnet.microsoft.com/download/dotnet/8.0)
- [Node.js](https://nodejs.org/) 18 or later
- [MongoDB](https://www.mongodb.com/try/download/community) running locally, or a free [MongoDB Atlas](https://www.mongodb.com/cloud/atlas) cluster
- [Android Studio](https://developer.android.com/studio) (includes the Android SDK and a JDK) — only needed for the mobile app
- A [Google Maps API key](https://developers.google.com/maps/documentation/android-sdk/get-api-key) — only needed for the mobile app's map screen; the app still runs without one, just with a blank map

### 1. Backend (ASP.NET Core Web API)

```bash
cd backend/SmartMicrogrid/SmartMicrogrid.Api
dotnet user-secrets set "MongoDb:ConnectionString" "mongodb://localhost:27017"
dotnet user-secrets set "Jwt:Key" "a-random-string-at-least-32-characters-long"
dotnet user-secrets set "Seed:AdminPassword" "ChooseYourOwnPassword123!"
dotnet run
```

- The API starts on `http://localhost:8081` with Swagger at `/swagger`.
- `Jwt:Key` must be at least 32 bytes — the value committed in `appsettings.json` is a short placeholder and will not start the app on its own.
- On first run, `DatabaseInitializer` creates the indexes and the first Backoffice account, using `Seed:AdminNic`/`AdminFullName`/`AdminEmail` from `appsettings.json` and the `Seed:AdminPassword` secret you just set. Sign in with that NIC and password to reach the Backoffice console.

### 2. Frontend (React web console)

```bash
cd frontend
npm install
npm run dev
```

- Opens on `http://localhost:5173`, already allowed by the backend's CORS config.
- To point at a different API, create `frontend/.env.local` with `VITE_API_BASE_URL=http://localhost:8081/api` (this is also the default, so it's optional for local development).

### 3. Mobile (Android app)

```bash
cd mobile/EADProject
```

1. Open the `mobile/EADProject` folder in Android Studio and let it sync Gradle, or build from the command line with `./gradlew assembleDebug`.
2. The emulator reaches the backend through `10.0.2.2:8081`, already configured as the default `API_BASE_URL` — no changes needed to run against a backend on the same machine. For a physical device, edit `API_BASE_URL` in `app/build.gradle.kts` to your machine's LAN IP instead.
3. (Optional) To show the map, create `mobile/EADProject/local.properties` (if Android Studio hasn't already) and add:
   ```
   MAPS_API_KEY=your-google-maps-api-key
   ```
4. Run the app on an emulator or device. Register a new prosumer account from the app, or sign in with the Backoffice account created by the backend seed step above. A Grid Operator account must be created from the web console's Users page by that Backoffice account first.

### Running everything together

Start the backend first, then the frontend and/or the mobile app — both depend on the API being up. MongoDB must already be running (or your Atlas cluster reachable) before `dotnet run`.

# EAD-PROJECT

Skeleton for the SE4040 group project. Each of the three parts starts from
its real toolchain's own scaffold (`dotnet new webapi`, `npm create vite`,
Android's Empty Activity template), plus the shared infrastructure, branding
and config that match the reference build — so every member starts from the
same look, feel and plumbing instead of reconciling four different styles
later. The actual features (Controllers, Pages, screens) are added per
member on their own branch — see `TEAM_SPLIT.md` for who owns what.

## Layout

```
EAD-PROJECT/
├── backend/SmartMicrogrid/     ASP.NET Core 8 Web API
├── frontend/                   React 19 + Vite + Tailwind
└── mobile/EADProject/          Android, Kotlin + Jetpack Compose
```

## What's already wired up (so nobody has to redo it)

**Backend** — MongoDB client + `MongoDbContext`, JWT auth scaffold, CORS,
Swagger, global exception handling, the account-status filter, and the
`User` model (needed by that filter). `Program.cs` has `// TODO` markers
showing exactly where to register your own service and, if you're the one
who builds `DatabaseInitializer`, where to call it — add your line, don't
remove anyone else's.

**Frontend** — Tailwind + the Outfit font, the full shared component kit
(`PageControls`, `FormControls`, `Icons`, `ConfirmDialog`, `Pagination`),
`usePagination`, the validation/date/sorting utils, the axios client, and
the session helpers. `App.jsx` is a placeholder — routing gets wired up once
Login and `auth/session.js`'s consumer exists.

**Mobile** — the real branding (VoltShare launcher icon, Outfit font,
theme), `ApiClient`/`SmartGridApi`/`Dtos` (Retrofit), `SessionStore` +
`SmartGridDbHelper` (SQLite), and the `ApiResult`/`ApiCall` wrapper every
repository builds on. `ServiceLocator.kt`, `ViewModelFactory.kt` and
`MainActivity.kt` have `// TODO` markers for wiring in each repository,
ViewModel and the navigation graph as they're built — same rule: add your
line, don't remove anyone else's. The Gradle wrapper is included and
functional (`./gradlew build` works immediately, no Android Studio step
required first).

Run each part the same way as the real project (see its own README once one
exists, or the commands above): `dotnet run` for the backend,
`npm install && npm run dev` for the frontend, and Android Studio or
`./gradlew` for mobile.

## Renaming things

- Backend project name: `SmartMicrogrid.Api`.
- Mobile package: `com.example.smartgrid_mobile` — rename via Android
  Studio's **Refactor → Rename** on the package if you want something else.

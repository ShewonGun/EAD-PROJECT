/* ============================================================================
 * File        : ServiceLocator.kt
 * Purpose     : Minimal manual dependency container. Keeps the app free of any
 *               injection framework while giving every screen one shared
 *               repository, API client and SQLite session store. Matches the
 *               shape of the real project's ServiceLocator; the feature
 *               repositories are left for each member to wire in when they
 *               merge their branch (see the TODO below) - none of those
 *               repository classes exist on main yet.
 * Author      : Shewon Gunarathne
 * Created     : 2026-09-25
 * ==========================================================================*/
package com.example.smartgrid_mobile.core

import android.content.Context
import com.example.smartgrid_mobile.data.local.SessionStore
import com.example.smartgrid_mobile.data.remote.ApiClient

object ServiceLocator {

    private lateinit var appContext: Context

    /** Local SQLite-backed session cache, created lazily on first use. */
    val sessionStore: SessionStore by lazy { SessionStore(appContext) }

    /** Retrofit implementation of the SmartGrid Web API. */
    val api by lazy { ApiClient.create(sessionStore) }

    // TODO (each member, on their own branch):
    //   val authRepository: AuthRepository by lazy { AuthRepository(api, sessionStore, stationCache, reservationCache) }
    //   val stationCache: StationCache by lazy { StationCache(appContext) }
    //   val reservationCache: ReservationCache by lazy { ReservationCache(appContext) }
    //   val reservationRepository: ReservationRepository by lazy { ReservationRepository(api, stationCache, reservationCache) }
    //   val operatorRepository: OperatorRepository by lazy { OperatorRepository(api) }
    //   val locationProvider: DeviceLocationProvider by lazy { DeviceLocationProvider(appContext) }
    // Add your own line here when your repository exists, and merge - don't remove anyone else's.

    /** Called once from the Application class before any screen is created. */
    fun init(context: Context) {
        appContext = context.applicationContext
    }
}

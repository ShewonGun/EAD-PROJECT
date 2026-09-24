/* ============================================================================
 * File        : MainActivity.kt
 * Purpose     : Single activity host for the SmartGrid mobile client. Applies
 *               the app theme; hands control to the navigation graph once one
 *               exists. Matches the shape of the real project's MainActivity -
 *               see the TODO below for what replaces the placeholder screen.
 * Author      : Shewon Gunarathne
 * Created     : 2026-09-25
 * ==========================================================================*/
package com.example.smartgrid_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.smartgrid_mobile.ui.theme.SmartGridMobileTheme

class MainActivity : ComponentActivity() {

    /** Sets up the Compose content tree for the whole application. */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartGridMobileTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // TODO: replace with SmartGridNavHost() once a navigation graph
                    // and its first screens exist - see the real project's
                    // navigation/SmartGridNavHost.kt for the shape to match.
                    Surface(modifier = Modifier.wrapContentSize(Alignment.Center)) {
                        Text("EAD-PROJECT skeleton — navigation not wired up yet.")
                    }
                }
            }
        }
    }
}

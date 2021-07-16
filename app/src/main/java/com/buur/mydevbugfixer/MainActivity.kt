package com.buur.mydevbugfixer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.buur.mydevbugfixer.ui.theme.MyDevBugFixerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyDevBugFixerTheme {
                MainScreen()
            }
        }
    }
}

package br.com.atmo


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.atmo.navigation.NavigationRoutes
import br.com.atmo.ui.theme.AtmoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AtmoTheme {
                NavigationRoutes()
                }
        }
    }
}
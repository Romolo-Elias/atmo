package br.com.atmo

import DashboardScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import br.com.atmo.ui.theme.AtmoTheme
import br.com.atmo.ui.theme.components.AtmoBottomBar
import br.com.atmo.ui.theme.screens.AddExpenseScreen
import br.com.atmo.ui.theme.screens.InsightsScreen
import br.com.atmo.ui.theme.screens.ProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AtmoTheme {
                var selectedTab by remember { mutableStateOf(0) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AtmoBottomBar(
                            onItemSelected = { index ->
                                selectedTab = index
                            }
                        )
                    }
                ) { innerPadding ->
                    when (selectedTab) {
                        0 -> DashboardScreen(modifier = Modifier.padding(innerPadding))
                        1 -> InsightsScreen(modifier = Modifier.padding(innerPadding))
                        2 -> AddExpenseScreen(modifier = Modifier.padding(innerPadding))
                        3 -> ProfileScreen(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}
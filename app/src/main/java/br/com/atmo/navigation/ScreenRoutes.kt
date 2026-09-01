package br.com.atmo.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.atmo.screens.AddExpenseScreen
import br.com.atmo.screens.InsightsScreen
import br.com.atmo.screens.DashboardScreen.DashboardScreen
import br.com.atmo.screens.LoginScreen
import br.com.atmo.screens.ProfileScreen
import br.com.atmo.screens.RegisterScreen
import br.com.atmo.ui.theme.components.AtmoBottomBar

@Composable
fun NavigationRoutes() {
    val navController = rememberNavController()

    var userEmail by remember { mutableStateOf("") }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val telasComBottomBar = listOf(
        Destination.DashboardScreen.route,
        Destination.InsightScreen.route,
        Destination.AddExpenseScreen.route,
        Destination.ProfileScreen.route
    )

    Scaffold(
        bottomBar = {
            if (currentRoute in telasComBottomBar) {
                AtmoBottomBar(
                    onItemSelected = { index ->
                        when (index) {
                            0 -> navController.navigate(Destination.DashboardScreen.createRoute(userEmail))
                            1 -> navController.navigate(Destination.InsightScreen.route)
                            2 -> navController.navigate(Destination.AddExpenseScreen.route)
                            3 -> navController.navigate(Destination.ProfileScreen.createRoute(userEmail))
                        }
                    }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Destination.LoginScreen.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Destination.LoginScreen.route) {
                LoginScreen(navController)
            }
            composable(Destination.RegisterScreen.route) {
                RegisterScreen(navController)
            }
            composable(
                route = Destination.DashboardScreen.route,
                arguments = listOf(navArgument("email") { type = NavType.StringType })
            ) { backStackEntry ->
                val email = backStackEntry.arguments?.getString("email") ?: ""
                userEmail = email
                DashboardScreen(navController, email)
            }
            composable(
                route = Destination.ProfileScreen.route,
                arguments = listOf(navArgument("email") { type = NavType.StringType })
            ) { backStackEntry ->
                val email = backStackEntry.arguments?.getString("email") ?: ""
                userEmail = email
                ProfileScreen(Modifier, navController, email)
            }
            composable(Destination.InsightScreen.route) {
                InsightsScreen()
            }
            composable(Destination.AddExpenseScreen.route) {
                AddExpenseScreen(navController)
            }
        }
    }
}
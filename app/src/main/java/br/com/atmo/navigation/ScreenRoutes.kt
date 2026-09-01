package br.com.atmo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.atmo.screens.AddExpenseScreen
import br.com.atmo.screens.InsightsScreen
import br.com.atmo.screens.DashboardScreen.DashboardScreen
import br.com.atmo.screens.LoginScreen
import br.com.atmo.screens.ProfileScreen
import br.com.atmo.screens.RegisterScreen

@Composable
fun NavigationRoutes() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.LoginScreen.route
    ){
        composable(Destination.LoginScreen.route){
            LoginScreen(navController)
        }
        composable(Destination.RegisterScreen.route){
            RegisterScreen(navController)
        }
        composable(
            route = Destination.DashboardScreen.route,
            arguments = listOf(navArgument("email") {
                type = NavType.StringType
            })
        ){ backStackEntry ->
            val email = backStackEntry.arguments?.getString("email")
            DashboardScreen(navController, email)
        }
        composable(
            route = Destination.ProfileScreen.route,
            arguments = listOf(navArgument("email") {
                type = NavType.StringType
            })
        ){ backStackEntry ->
            var email = backStackEntry.arguments?.getString("email")
            ProfileScreen(Modifier, navController, email)
        }
        composable(Destination.InsightScreen.route){
            InsightsScreen()
        }
        composable(Destination.AddExpenseScreen.route){
            AddExpenseScreen()
        }
    }
}
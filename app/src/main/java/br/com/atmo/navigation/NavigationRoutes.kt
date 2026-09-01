package br.com.atmo.navigation

sealed class Destination(val route: String){

    object LoginScreen: Destination("login")
    object RegisterScreen: Destination("register")
    object DashboardScreen: Destination("dashboard/{email}"){
        fun createRoute(email: String): String {
            return "dashboard/$email"
        }
    }
    object InsightScreen: Destination("insight")
    object AddExpenseScreen: Destination("addExpense")
    object ProfileScreen: Destination("profile")

}
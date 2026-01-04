package com.example.stoxlk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.stoxlk.presentation.home.HomeScreen
import com.example.stoxlk.presentation.intro.IntroScreen
import com.example.stoxlk.presentation.login.LoginScreen
import com.example.stoxlk.presentation.stock.StockProfileScreen
import com.example.stoxlk.ui.theme.StoxLKTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StoxLKTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "intro") {
        composable("intro") {
            IntroScreen(
                onLoginClick = {
                    navController.navigate("home") {
                         popUpTo("intro") { inclusive = true }
                    }
                },
            )
        }
        composable("login") {
            LoginScreen(
                onLoginClick = {
                    navController.navigate("home") {
                        popUpTo("intro") { inclusive = true }
                    }
                },
            )
        }
        composable("home") {
            HomeScreen(
                onStockClick = { symbol ->
                    navController.navigate("stock_profile/$symbol")
                },
            )
        }
        composable(
            route = "stock_profile/{symbol}",
            arguments = listOf(navArgument("symbol") { type = NavType.StringType }),
        ) { backStackEntry ->
            val symbol = backStackEntry.arguments?.getString("symbol") ?: "Unknown"
            StockProfileScreen(
                symbol = symbol,
                onBackClick = { navController.popBackStack() },
            )
        }
    }
}

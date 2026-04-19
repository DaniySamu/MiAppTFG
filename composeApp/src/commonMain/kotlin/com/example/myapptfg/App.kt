package com.example.myapptfg

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapptfg.ui.screens.LoginScreen
import com.example.myapptfg.ui.screens.RegisterScreen
import com.example.myapptfg.ui.screens.SplashScreen
import org.jetbrains.compose.resources.painterResource
import androidx.compose.ui.tooling.preview.Preview

import com.example.myapptfg.ui.screens.*
import com.example.myapptfg.ui.theme.MyAppTheme

@Composable
@Preview
fun App() {
    MyAppTheme {
        val navController = rememberNavController()
        
        NavHost(
            navController = navController,
            startDestination = "splash"
        ) {
            composable("splash") {
                SplashScreen(onTimeout = {
                    navController.navigate("login") {
                        popUpTo("splash") { inclusive = true }
                    }
                })
            }
            composable("login") {
                LoginScreen(
                    onLoginSuccess = {
                        navController.navigate("main") {
                            popUpTo("login") { inclusive = true }
                        }
                    },
                    onNavigateToRegister = {
                        navController.navigate("register")
                    }
                )
            }
            composable("register") {
                RegisterScreen(
                    onRegisterSuccess = {
                        navController.navigate("login") {
                            popUpTo("register") { inclusive = true }
                        }
                    },
                    onNavigateToLogin = {
                        navController.popBackStack()
                    }
                )
            }
            composable("main") {
                MainScreen(
                    onMenuClick = { /* Handle Drawer in MainScreen */ },
                    onAddProductClick = { navController.navigate("add_product") },
                    onBackToLogin = {
                        navController.navigate("login") {
                            popUpTo("main") { inclusive = true }
                        }
                    }
                )
            }
            composable("add_product") {
                // To be implemented
            }
        }
    }
}

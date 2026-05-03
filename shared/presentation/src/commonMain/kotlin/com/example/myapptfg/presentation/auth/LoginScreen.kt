package com.example.myapptfg.presentation.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapptfg.ui.theme.BackgroundGreen
import com.example.myapptfg.ui.theme.PrimaryGreen
import com.example.myapptfg.ui.theme.SecondaryGreen

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onNavigateToRegister: () -> Unit
) {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundGreen)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        // Login Header
        Surface(
            modifier = Modifier
                .width(200.dp)
                .height(60.dp),
            color = PrimaryGreen,
            shape = RoundedCornerShape(30.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = "Login",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Profile Icon Placeholder
        Surface(
            modifier = Modifier.size(100.dp),
            shape = CircleShape,
            color = PrimaryGreen.copy(alpha = 0.8f)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.size(60.dp),
                    tint = Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        // Input Fields
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Usuario",
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 4.dp)
            )
            TextField(
                value = user,
                onValueChange = { user = it },
                placeholder = { Text("Su usuario") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Contraseña",
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 4.dp)
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Su contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(12.dp)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = onLoginSuccess,
            modifier = Modifier
                .width(180.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen),
            shape = RoundedCornerShape(25.dp)
        ) {
            Text("Entrar", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "¿No tienes cuenta?, Registrate",
            fontSize = 14.sp,
            color = Color.Black
        )
        
        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onNavigateToRegister,
            modifier = Modifier
                .width(180.dp)
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(containerColor = SecondaryGreen),
            shape = RoundedCornerShape(22.dp)
        ) {
            Text("Registrarse", color = Color.Black, fontWeight = FontWeight.SemiBold)
        }
        
        Spacer(modifier = Modifier.height(20.dp))
    }
}

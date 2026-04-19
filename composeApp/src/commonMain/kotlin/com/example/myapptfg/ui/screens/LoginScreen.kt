package com.example.myapptfg.ui.screens

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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        // Login Header
        Surface(
            modifier = Modifier
                .width(180.dp)
                .height(60.dp),
            color = PrimaryGreen,
            shape = RoundedCornerShape(30.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = "Login",
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Profile Icon Placeholder
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(PrimaryGreen),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier.size(60.dp),
                tint = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Input Fields
        Text(
            text = "Usuario",
            modifier = Modifier.align(Alignment.Start),
            fontSize = 14.sp,
            color = Color.Gray
        )
        TextField(
            value = user,
            onValueChange = { user = it },
            placeholder = { Text("Su usuario") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = SecondaryGreen.copy(alpha = 0.3f),
                focusedContainerColor = SecondaryGreen.copy(alpha = 0.3f),
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Contraseña",
            modifier = Modifier.align(Alignment.Start),
            fontSize = 14.sp,
            color = Color.Gray
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
                unfocusedContainerColor = SecondaryGreen.copy(alpha = 0.3f),
                focusedContainerColor = SecondaryGreen.copy(alpha = 0.3f),
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = onLoginSuccess,
            modifier = Modifier
                .width(150.dp)
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen),
            shape = RoundedCornerShape(22.dp)
        ) {
            Text("Entrar", color = Color.White)
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "¿No tienes cuenta?, Registrate",
            fontSize = 14.sp,
            color = Color.Black
        )
        
        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onNavigateToRegister,
            modifier = Modifier
                .width(150.dp)
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = SecondaryGreen),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text("Registrarse", color = Color.Black)
        }
        
        Spacer(modifier = Modifier.height(20.dp))
    }
}

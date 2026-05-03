package com.example.myapptfg.presentation.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
fun RegisterScreen(
    onRegisterSuccess: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var acceptTerms by remember { mutableStateOf(false) }
    var acceptPrivacy by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundGreen)
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        // Register Header
        Surface(
            modifier = Modifier
                .width(200.dp)
                .height(60.dp),
            color = PrimaryGreen,
            shape = RoundedCornerShape(30.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = "Registro",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Input Fields
        RegisterTextField(label = "Nombre", value = name, onValueChange = { name = it }, placeholder = "Nombre")
        RegisterTextField(label = "Apellido", value = lastName, onValueChange = { lastName = it }, placeholder = "Apellido")
        RegisterTextField(label = "Teléfono (opcional)", value = phone, onValueChange = { phone = it }, placeholder = "Teléfono")
        RegisterTextField(label = "Email", value = email, onValueChange = { email = it }, placeholder = "Email")
        RegisterTextField(label = "Contraseña", value = password, onValueChange = { password = it }, placeholder = "Contraseña", isPassword = true)

        Spacer(modifier = Modifier.height(16.dp))

        // Checkboxes
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = acceptTerms,
                    onCheckedChange = { acceptTerms = it },
                    colors = CheckboxDefaults.colors(checkedColor = PrimaryGreen)
                )
                Text(text = "Términos y condiciones", fontSize = 14.sp, color = Color.Black)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = acceptPrivacy,
                    onCheckedChange = { acceptPrivacy = it },
                    colors = CheckboxDefaults.colors(checkedColor = PrimaryGreen)
                )
                Text(text = "Política de privacidad", fontSize = 14.sp, color = Color.Black)
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = onRegisterSuccess,
            modifier = Modifier
                .width(220.dp)
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen),
            shape = RoundedCornerShape(28.dp)
        ) {
            Text("Crear Cuenta", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
        
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun RegisterTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false
) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(start = 4.dp)
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(placeholder) },
            visualTransformation = if (isPassword) PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(12.dp)
        )
    }
}

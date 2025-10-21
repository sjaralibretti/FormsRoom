package com.example.form

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.form.model.AppDatabase
import com.example.form.repository.UsuarioRepository
import com.example.form.ui.theme.FormTheme
import com.example.form.view.FormularioScreen
import com.example.form.view.ResumenScreen
import com.example.form.viewmodel.UsuarioViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            val context = LocalContext.current
            val db = remember { AppDatabase.getDatabase(context) }
            val repository = remember { UsuarioRepository(db.usuarioDao()) }
            val usuarioViewModel = remember { UsuarioViewModel(repository) }

            NavHost(navController = navController, startDestination = "FormularioScreen") {
                composable("FormularioScreen") {
                    FormularioScreen(
                        navController = navController,
                        viewModel = usuarioViewModel
                    )
                }
                composable("resumen") {
                    ResumenScreen(
                        usuarioViewModel, navController
                    )
                }
            }
        }
    }
}


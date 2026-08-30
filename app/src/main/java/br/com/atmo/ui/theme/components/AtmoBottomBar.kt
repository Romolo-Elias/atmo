package br.com.atmo.ui.theme.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import br.com.atmo.ui.theme.AtmoCyan
import br.com.atmo.ui.theme.AtmoSurface

@Composable
fun AtmoBottomBar(
    onItemSelected: (Int) -> Unit = {}
) {
    var selectedItem by remember { mutableStateOf(0) }

    NavigationBar(
        containerColor = AtmoSurface,
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Início") },
            label = { Text("Início") },
            selected = selectedItem == 0,
            onClick = {
                selectedItem = 0
                onItemSelected(0)
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = AtmoCyan,
                unselectedIconColor = MaterialTheme.colorScheme.secondary,
                selectedTextColor = AtmoCyan,
                unselectedTextColor = MaterialTheme.colorScheme.secondary,
                indicatorColor = AtmoCyan.copy(alpha = 0.1f)
            )
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.Lightbulb, contentDescription = "Insights") },
            label = { Text("Insights") },
            selected = selectedItem == 1,
            onClick = {
                selectedItem = 1
                onItemSelected(1)
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = AtmoCyan,
                unselectedIconColor = MaterialTheme.colorScheme.secondary,
                selectedTextColor = AtmoCyan,
                unselectedTextColor = MaterialTheme.colorScheme.secondary,
                indicatorColor = AtmoCyan.copy(alpha = 0.1f)
            )
        )

        // Item de Adicionar com o símbolo "+" integrado no menu
        NavigationBarItem(
            icon = { Icon(Icons.Default.Add, contentDescription = "Adicionar") },
            label = { Text("Novo") },
            selected = selectedItem == 2,
            onClick = {
                selectedItem = 2
                onItemSelected(2)
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = AtmoCyan,
                unselectedIconColor = MaterialTheme.colorScheme.secondary,
                selectedTextColor = AtmoCyan,
                unselectedTextColor = MaterialTheme.colorScheme.secondary,
                indicatorColor = AtmoCyan.copy(alpha = 0.1f)
            )
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
            label = { Text("Perfil") },
            selected = selectedItem == 3,
            onClick = {
                selectedItem = 3
                onItemSelected(3)
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = AtmoCyan,
                unselectedIconColor = MaterialTheme.colorScheme.secondary,
                selectedTextColor = AtmoCyan,
                unselectedTextColor = MaterialTheme.colorScheme.secondary,
                indicatorColor = AtmoCyan.copy(alpha = 0.1f)
            )
        )
    }
}
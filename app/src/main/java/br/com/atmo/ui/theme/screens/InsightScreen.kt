package br.com.atmo.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ElectricBolt
import androidx.compose.material.icons.filled.LocalDrink
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.atmo.ui.theme.AtmoTextSecondary
import br.com.atmo.ui.theme.AtmoTheme
import br.com.atmo.ui.theme.components.InsightItem

@Composable
fun InsightsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Column(modifier = Modifier.padding(bottom = 8.dp)) {
            Text(
                text = "Insights",
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Dicas práticas para reduzir sua pegada",
                color = AtmoTextSecondary,
                fontSize = 14.sp
            )
        }

        InsightItem(
            title = "Menos Carne Vermelha",
            description = "Substituir a carne vermelha por frango ou opções vegetais 2x na semana.",
            carbonBadge = "-20 KG",
            icon = Icons.Default.Spa
        )

        InsightItem(
            title = "Otimização de Energia",
            description = "Reduzir o brilho das telas e desligar o stand-by de aparelhos eletrônicos.",
            carbonBadge = "-5.2 KG",
            icon = Icons.Default.ElectricBolt
        )

        InsightItem(
            title = "Limpeza Digital",
            description = "Apagar e-mails antigos e cancelar newsletters não lidas reduz a carga de servidores.",
            carbonBadge = "-2.5 KG",
            icon = Icons.Default.Public
        )

        InsightItem(
            title = "Banhos Curtos",
            description = "Reduzir o tempo de banho quente em 3 minutos economiza água e energia.",
            carbonBadge = "-8 KG",
            icon = Icons.Default.LocalDrink
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun InsightsScreenPreview() {
    AtmoTheme {
        InsightsScreen()
    }
}
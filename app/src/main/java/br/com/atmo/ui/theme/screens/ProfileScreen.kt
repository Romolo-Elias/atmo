package br.com.atmo.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.atmo.ui.theme.AtmoCyan
import br.com.atmo.ui.theme.AtmoTextSecondary
import br.com.atmo.ui.theme.AtmoTheme
import br.com.atmo.ui.theme.components.AtmoCard

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Meu Perfil",
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp
        )

        // Card de Informações do Usuário
        AtmoCard {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Avatar circular com ícone
                Surface(
                    shape = CircleShape,
                    color = AtmoCyan.copy(alpha = 0.15f),
                    modifier = Modifier.size(60.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = AtmoCyan,
                        modifier = Modifier
                            .padding(14.dp)
                            .size(32.dp)
                    )
                }

                Column {
                    Text(
                        text = "Usuário Atmo",
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "usuario@faculdade.com",
                        color = AtmoTextSecondary,
                        fontSize = 13.sp
                    )
                }
            }
        }
        AtmoCard {
            Text(
                text = "SUSTENTABILIDADE",
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.SemiBold,
                fontSize = 11.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = "Nível ESG", color = AtmoTextSecondary, fontSize = 12.sp)
                    Text(text = "Nível Prata", color = AtmoCyan, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(text = "CO₂ Poupado", color = AtmoTextSecondary, fontSize = 12.sp)
                    Text(text = "48.2 kg", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }
        }

        AtmoCard {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text(
                    text = "CONFIGURAÇÕES",
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 11.sp
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = null,
                            tint = AtmoCyan,
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "Notificações e Alertas",
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = 14.sp
                        )
                    }
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = null,
                        tint = AtmoTextSecondary
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Security,
                            contentDescription = null,
                            tint = AtmoCyan,
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "Privacidade e Dados",
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = 14.sp
                        )
                    }
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = null,
                        tint = AtmoTextSecondary
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    AtmoTheme {
        ProfileScreen()
    }
}
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.Laptop
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.atmo.R
import br.com.atmo.ui.theme.AtmoTheme
import br.com.atmo.ui.theme.components.AtmoCard
import br.com.atmo.ui.theme.components.CategoryEmissionItem
import br.com.atmo.ui.theme.components.ExpenseItem

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = stringResource(R.string.ola_usuario),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AtmoCard(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "GASTOS",
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 11.sp
                )
                Text(
                    text = "R$ 781,00",
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            AtmoCard(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "PEGADA CO₂",
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 11.sp
                    )
                    Text(
                        text = "+20.7%",
                        color = MaterialTheme.colorScheme.error,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 11.sp
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "217.3 kg",
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        }

        Text(
            text = "Emissões por categoria",
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.Medium
            )
            CategoryEmissionItem(
                title = "Transporte",
                value = "0.05 kg",
                progress = 0.2f,
                icon = Icons.Default.DirectionsCar,
            )

            CategoryEmissionItem(
                title = "Alimentação",
                value = "43.0 kg",
                progress = 0.8f,
                icon = Icons.Default.ShoppingCart
            )
            CategoryEmissionItem(
                title = "Casa",
                value = "36.0 kg",
                progress = 0.5f,
                icon = Icons.Default.House
            )

            CategoryEmissionItem(
                title = "Digital",
                value = "60.0 kg",
                progress = 1f,
                icon = Icons.Default.Laptop
            )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Últimas Despesas",
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(10.dp))

        ExpenseItem(
            title = "Uber para o centro",
            category = "Transporte",
            value = "R$ 85,00",
            carbonValue = "42.5 kg",
            icon = Icons.Default.DirectionsCar
        )

        ExpenseItem(
            title = "Supermercado",
            category = "Alimentação",
            value = "R$ 450,00",
            carbonValue = "135.0 kg",
            icon = Icons.Default.ShoppingCart
        )

        ExpenseItem(
            title = "Conta de Luz",
            category = "Casa",
            value = "R$ 180,00",
            carbonValue = "36.0 kg",
            icon = Icons.Default.Laptop
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DashboardScreenPreview() {
    AtmoTheme {
        DashboardScreen()
    }
}
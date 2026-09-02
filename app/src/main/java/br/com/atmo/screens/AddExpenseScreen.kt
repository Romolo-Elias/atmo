package br.com.atmo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.atmo.BuildConfig
import br.com.atmo.data.AtmoDatabase
import br.com.atmo.data.EmissionFactorSelector
import br.com.atmo.data.EstimateRequest
import br.com.atmo.data.MoneyParameters
import br.com.atmo.data.RetrofitClient
import br.com.atmo.data.categoriaParaBusca
import br.com.atmo.model.Expense
import br.com.atmo.ui.theme.AtmoCyan
import br.com.atmo.ui.theme.AtmoSurface
import br.com.atmo.ui.theme.AtmoTextSecondary
import br.com.atmo.ui.theme.AtmoTheme
import br.com.atmo.viewmodel.ExpenseViewModel
import kotlinx.coroutines.launch

@Composable
fun AddExpenseScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var title by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }

    val context = LocalContext.current
    val viewModel: ExpenseViewModel = viewModel(
        factory = ExpenseViewModel.Factory(AtmoDatabase.getInstance(context).expenseDao())
    )
    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Column(modifier = Modifier.padding(bottom = 8.dp)) {
            Text(
                text = "Novo Registro",
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Adicione uma despesa e calcule seu impacto",
                color = AtmoTextSecondary,
                fontSize = 14.sp
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(
                text = "Descrição",
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            )
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                placeholder = { Text("Ex: Uber para o trabalho", color = AtmoTextSecondary) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = AtmoCyan,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                    focusedContainerColor = AtmoSurface,
                    unfocusedContainerColor = AtmoSurface,
                    focusedTextColor = MaterialTheme.colorScheme.onSurface,
                    unfocusedTextColor = MaterialTheme.colorScheme.onSurface
                ),
                singleLine = true
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(
                text = "Valor (R$)",
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            )
            OutlinedTextField(
                value = amount,
                onValueChange = { amount = it },
                placeholder = { Text("Ex: 45.00", color = AtmoTextSecondary) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = AtmoCyan,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                    focusedContainerColor = AtmoSurface,
                    unfocusedContainerColor = AtmoSurface,
                    focusedTextColor = MaterialTheme.colorScheme.onSurface,
                    unfocusedTextColor = MaterialTheme.colorScheme.onSurface
                ),
                singleLine = true
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(
                text = "Categoria",
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            )
            OutlinedTextField(
                value = category,
                onValueChange = { category = it },
                placeholder = { Text("Ex: Transporte, Alimentação...", color = AtmoTextSecondary) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = AtmoCyan,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                    focusedContainerColor = AtmoSurface,
                    unfocusedContainerColor = AtmoSurface,
                    focusedTextColor = MaterialTheme.colorScheme.onSurface,
                    unfocusedTextColor = MaterialTheme.colorScheme.onSurface
                ),
                singleLine = true
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val valorConvertido = amount.replace(",", ".").toDoubleOrNull() ?: 0.0

                scope.launch {
                    val carbonValue = try {
                        val termoBusca = categoriaParaBusca(category)
                        val resultadoBusca = RetrofitClient.api.search(
                            token = "Bearer ${BuildConfig.CLIMATIQ_API_KEY}",
                            query = termoBusca
                        )
                        val activityId = resultadoBusca.results.firstOrNull()?.activity_id

                        if (activityId != null) {
                            val estimativa = RetrofitClient.api.estimate(
                                token = "Bearer ${BuildConfig.CLIMATIQ_API_KEY}",
                                request = EstimateRequest(
                                    emission_factor = EmissionFactorSelector(activityId),
                                    parameters = MoneyParameters(money = valorConvertido)
                                )
                            )
                            estimativa.co2e
                        } else {
                            0.0
                        }
                    } catch (e: Exception) {
                        android.util.Log.e("ClimatiqAPI", "Erro ao chamar a API", e)
                        0.0
                    }

                    viewModel.insert(
                        Expense(
                            title = title,
                            category = category,
                            value = valorConvertido,
                            carbonValue = carbonValue
                        )
                    )
                    navController.popBackStack()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AtmoCyan,
                contentColor = MaterialTheme.colorScheme.background
            )
        ) {
            Text(
                text = "Salvar Despesa",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}

@Preview
@Composable
private fun AddExpenseScreenPreview() {
    AtmoTheme {
        AddExpenseScreen(rememberNavController())
    }
}
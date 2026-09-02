package br.com.atmo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import br.com.atmo.data.ExpenseDao
import br.com.atmo.model.Expense
import br.com.atmo.repository.ExpenseRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ExpenseViewModel(private val repository: ExpenseRepository) : ViewModel() {

    val expenses: StateFlow<List<Expense>> = repository.getAll()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val totalGasto: StateFlow<Double> = expenses
        .map { lista -> lista.sumOf { it.value } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0.0)

    val totalCO2: StateFlow<Double> = expenses
        .map { lista -> lista.sumOf { it.carbonValue } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0.0)

    val emissoesPorCategoria: StateFlow<Map<String, Double>> = expenses
        .map { lista -> lista.groupBy { it.category }.mapValues { (_, l) -> l.sumOf { it.carbonValue } } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyMap())

    fun insert(expense: Expense) {
        viewModelScope.launch {
            repository.insert(expense)
        }
    }

    class Factory(private val dao: ExpenseDao) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return ExpenseViewModel(ExpenseRepository(dao)) as T
        }
    }
}
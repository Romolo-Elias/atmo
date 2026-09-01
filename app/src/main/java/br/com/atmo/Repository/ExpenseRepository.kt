package br.com.atmo.repository

import br.com.atmo.data.ExpenseDao
import br.com.atmo.model.Expense
import kotlinx.coroutines.flow.Flow

class ExpenseRepository(private val dao: ExpenseDao) {

    fun getAll(): Flow<List<Expense>> = dao.getAll()

    suspend fun insert(expense: Expense) {
        dao.insert(expense)
    }
}
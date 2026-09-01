package br.com.atmo.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.atmo.model.Expense
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Insert
    suspend fun insert(expense: Expense)

    @Query("SELECT * FROM expenses")
    fun getAll(): Flow<List<Expense>>
}
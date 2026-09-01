package br.com.atmo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.atmo.model.Expense

@Database(entities = [Expense::class], version = 1, exportSchema = false)
abstract class AtmoDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao

    companion object {
        @Volatile
        private var INSTANCE: AtmoDatabase? = null

        fun getInstance(context: Context): AtmoDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AtmoDatabase::class.java,
                    "atmo_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
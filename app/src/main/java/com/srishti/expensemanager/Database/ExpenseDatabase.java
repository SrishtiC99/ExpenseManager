package com.srishti.expensemanager.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.srishti.expensemanager.Dao.ExpenseDao;
import com.srishti.expensemanager.Entity.Expense;

@Database(entities = {Expense.class}, version = 2)
public abstract class ExpenseDatabase extends RoomDatabase {
    private static ExpenseDatabase instance;
    public abstract ExpenseDao getExpenseDao();

    public static synchronized ExpenseDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ExpenseDatabase.class,
                    "expense_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

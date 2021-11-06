package com.srishti.expensemanager.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.srishti.expensemanager.Entity.Expense;

import java.util.List;

public interface ExpenseDao {
    @Insert
    void insert(Expense expense);

    @Update
    void update(Expense expense);

    @Delete
    void delete(Expense expense);

    @Query("DELETE FROM expense_table")
    void deleteAll();

    @Query("Select * FROM expense_table")
    LiveData<List<Expense>> getAllCategories();
}

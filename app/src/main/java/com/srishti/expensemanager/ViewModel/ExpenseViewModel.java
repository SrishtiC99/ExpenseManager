package com.srishti.expensemanager.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.srishti.expensemanager.Entity.Expense;
import com.srishti.expensemanager.Repository.ExpenseRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ExpenseViewModel extends AndroidViewModel {
    private ExpenseRepository repository;
    private LiveData<List<Expense>> allExpenses;
    public ExpenseViewModel(@NonNull @NotNull Application application) {
        super(application);
        repository = new ExpenseRepository(application);
        allExpenses = repository.getAllExpenses();
    }

    public void insert(Expense expense){
        repository.insert(expense);
    }
    public void update(Expense expense){
        repository.update(expense);
    }
    public void delete(Expense expense){
        repository.delete(expense);
    }
    public void deleteAll(){
        repository.deleteAll();
    }
    public LiveData<List<Expense>> getAllExpenses(){
        return allExpenses;
    }
}

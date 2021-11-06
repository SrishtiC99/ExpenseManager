package com.srishti.expensemanager.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.srishti.expensemanager.Entity.Income;
import com.srishti.expensemanager.Repository.IncomeRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class IncomeViewModel extends AndroidViewModel {
    private IncomeRepository repository;
    private LiveData<List<Income>> allIncomes;
    public IncomeViewModel(@NonNull @NotNull Application application) {
        super(application);
        repository = new IncomeRepository(application);
        allIncomes = repository.getAllIncomes();
    }

    public void insert(Income income){
        repository.insert(income);
    }
    public void update(Income income){
        repository.update(income);
    }
    public void delete(Income income){
        repository.delete(income);
    }
    public void deleteAll(){
        repository.deleteAll();
    }
    public LiveData<List<Income>> getAllIncomes(){
        return allIncomes;
    }
}

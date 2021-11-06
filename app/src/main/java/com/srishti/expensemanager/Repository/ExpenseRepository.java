package com.srishti.expensemanager.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.srishti.expensemanager.Dao.ExpenseDao;
import com.srishti.expensemanager.Database.ExpenseDatabase;
import com.srishti.expensemanager.Entity.Expense;

import java.util.List;

public class ExpenseRepository {
    private ExpenseDao expenseDao;
    private LiveData<List<Expense>> allExpenses;

    public ExpenseRepository(Application application){
        ExpenseDatabase database = ExpenseDatabase.getInstance(application);
        expenseDao = database.getExpenseDao();
        allExpenses = expenseDao.getAllExpenses();
    }

    public void insert(Expense expense){
        new InsertExpenseAsyncTask(expenseDao).execute(expense);
    }

    public void update(Expense expense){
        new UpdateExpenseAsyncTask(expenseDao).execute(expense);
    }

    public void delete(Expense expense){
        new DeleteExpenseAsyncTask(expenseDao).execute(expense);
    }

    public void deleteAll(){
        new DeleteAllAsyncTask(expenseDao).execute();
    }
    public LiveData<List<Expense>> getAllExpenses(){
        return allExpenses;
    }

    private static class InsertExpenseAsyncTask extends AsyncTask<Expense, Void, Void>{
        private ExpenseDao expenseDao;
        private InsertExpenseAsyncTask(ExpenseDao expenseDao){
            this.expenseDao = expenseDao;
        }
        @Override
        protected Void doInBackground(Expense... expenses) {
            expenseDao.insert(expenses[0]);
            return null;
        }
    }
    private static class UpdateExpenseAsyncTask extends AsyncTask<Expense, Void, Void>{
        private ExpenseDao expenseDao;
        private UpdateExpenseAsyncTask(ExpenseDao expenseDao){
            this.expenseDao = expenseDao;
        }
        @Override
        protected Void doInBackground(Expense... expenses) {
            expenseDao.update(expenses[0]);
            return null;
        }
    }
    private static class DeleteExpenseAsyncTask extends android.os.AsyncTask<Expense, Void, Void> {
        private ExpenseDao expenseDao;
        private DeleteExpenseAsyncTask(ExpenseDao expenseDao){
            this.expenseDao = expenseDao;
        }
        @Override
        protected Void doInBackground(Expense... expenses) {
            expenseDao.delete(expenses[0]);
            return null;
        }
    }
    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void>{
        private ExpenseDao expenseDao;
        private DeleteAllAsyncTask(ExpenseDao expenseDao){
            this.expenseDao = expenseDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            expenseDao.deleteAll();
            return null;
        }
    }
}

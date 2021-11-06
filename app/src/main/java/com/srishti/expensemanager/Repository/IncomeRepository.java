package com.srishti.expensemanager.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.srishti.expensemanager.Dao.CategoryDao;
import com.srishti.expensemanager.Dao.IncomeDao;
import com.srishti.expensemanager.Database.IncomeDatabase;
import com.srishti.expensemanager.Entity.Category;
import com.srishti.expensemanager.Entity.Income;

import java.util.List;

public class IncomeRepository {
    private IncomeDao incomeDao;
    private LiveData<List<Income>> allIncomes;
    public IncomeRepository(Application application){
        IncomeDatabase database = IncomeDatabase.getInstance(application);
        incomeDao = database.getIncomeDao();
        allIncomes = incomeDao.getAllIncome();
    }

    public void insert(Income income){
        new InsertIncomeAsyncTask(incomeDao).execute(income);
    }
    public void update(Income income){
        new UpdateIncomeAsyncTask(incomeDao).execute(income);
    }
    public void delete(Income income){
        new DeleteIncomeAsyncTask(incomeDao).execute(income);
    }
    public void deleteAll(){
        new DeleteAllAsyncTask(incomeDao).execute();
    }
    public LiveData<List<Income>> getAllIncomes(){
        return allIncomes;
    }
    private static class InsertIncomeAsyncTask extends AsyncTask<Income, Void, Void>{
        private IncomeDao incomeDao;

        private InsertIncomeAsyncTask(IncomeDao incomeDao) {
            this.incomeDao = incomeDao;
        }
        @Override
        protected Void doInBackground(Income... incomes) {
            incomeDao.insert(incomes[0]);
            return null;
        }
    }
    private static class UpdateIncomeAsyncTask extends AsyncTask<Income, Void, Void>{
        private IncomeDao incomeDao;

        private UpdateIncomeAsyncTask(IncomeDao incomeDao) {
            this.incomeDao = incomeDao;
        }

        @Override
        protected Void doInBackground(Income... incomes) {
            incomeDao.update(incomes[0]);
            return null;
        }
    }

    private static class DeleteIncomeAsyncTask extends AsyncTask<Income, Void, Void>{
        private IncomeDao incomeDao;

        private DeleteIncomeAsyncTask(IncomeDao incomeDao) {
            this.incomeDao = incomeDao;
        }

        @Override
        protected Void doInBackground(Income... incomes) {
            incomeDao.delete(incomes[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private IncomeDao incomeDao;

        private DeleteAllAsyncTask(IncomeDao incomeDao) {
            this.incomeDao = incomeDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            incomeDao.deleteAll();
            return null;
        }
    }
}

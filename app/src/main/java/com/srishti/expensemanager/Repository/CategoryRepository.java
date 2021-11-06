package com.srishti.expensemanager.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.srishti.expensemanager.Dao.CategoryDao;
import com.srishti.expensemanager.Database.CategoryDatabase;
import com.srishti.expensemanager.Entity.Category;

import java.util.List;

public class CategoryRepository {
    private CategoryDao categoryDao;
    private LiveData<List<Category>> allCategories;

    public CategoryRepository(Application application){
        CategoryDatabase database = CategoryDatabase.getInstance(application);
        categoryDao = database.getCategoryDao();
        allCategories = categoryDao.getAllCategories();
    }

    public void insert(Category category){
        new InsertCategoryAsyncTask(categoryDao).execute(category);
    }
    public void update(Category category){
        new UpdateCategoryAsyncTask(categoryDao).execute(category);
    }
    public void delete(Category category){
        new DeleteCategoryAsyncTask(categoryDao).execute(category);
    }
    public void deleteAll(){
        new DeleteAllAsyncTask(categoryDao).execute();
    }
    public LiveData<List<Category>> getAllCategories(){
        return allCategories;
    }

    private static class InsertCategoryAsyncTask extends AsyncTask<Category, Void, Void>{
        private CategoryDao categoryDao;

        private InsertCategoryAsyncTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.insert(categories[0]);
            return null;
        }
    }
    private static class UpdateCategoryAsyncTask extends AsyncTask<Category, Void, Void>{
        private CategoryDao categoryDao;

        private UpdateCategoryAsyncTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.update(categories[0]);
            return null;
        }
    }

    private static class DeleteCategoryAsyncTask extends AsyncTask<Category, Void, Void>{
        private CategoryDao categoryDao;

        private DeleteCategoryAsyncTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.delete(categories[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void>{
        private CategoryDao categoryDao;

        private DeleteAllAsyncTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            categoryDao.deleteAll();
            return null;
        }
    }
}

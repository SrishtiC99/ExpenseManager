package com.srishti.expensemanager.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.srishti.expensemanager.Dao.CategoryDao;
import com.srishti.expensemanager.Entity.Category;

@Database(entities = {Category.class}, version = 2)
public abstract class CategoryDatabase extends  RoomDatabase{
    private static CategoryDatabase instance;
    public abstract CategoryDao getCategoryDao();

    public static synchronized CategoryDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CategoryDatabase.class,
                    "category_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

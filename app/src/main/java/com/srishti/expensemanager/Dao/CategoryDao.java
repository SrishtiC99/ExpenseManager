package com.srishti.expensemanager.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.srishti.expensemanager.Entity.Category;

import java.util.List;

public interface CategoryDao {
    @Insert
    void insert(Category category);

    @Update
    void update(Category category);

    @Delete
    void delete(Category category);

    @Query("DELETE FROM category_table")
    void deleteAll();

    @Query("Select * FROM category_table")
    LiveData<List<Category>> getAllCategories();
}

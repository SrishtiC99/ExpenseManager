package com.srishti.expensemanager.Entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.DateFormat;

@Entity(tableName = "income_table")
public class Income {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String date;

    private double value;

    public Income(String date, double value) {
        this.date = date;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }

}

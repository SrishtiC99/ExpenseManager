package com.srishti.expensemanager.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.DateFormat;

@Entity(tableName = "income_table")
public class Income {
    @PrimaryKey(autoGenerate = false)
    private String id;

    private DateFormat date;

    private double value;

    public Income(DateFormat date, double value) {
        this.date = date;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public DateFormat getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }

}

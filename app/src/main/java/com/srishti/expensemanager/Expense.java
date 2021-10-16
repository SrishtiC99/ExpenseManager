package com.srishti.expensemanager;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.DateFormat;

@Entity(tableName = "expense_table")
public class Expense {
    @PrimaryKey(autoGenerate = false)
    private String id;

    private DateFormat date;

    private double amount;

    private String category;

    private String note;

    public Expense(DateFormat date, double amount, String category) {
        this.date = date;
        this.amount = amount;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public DateFormat getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

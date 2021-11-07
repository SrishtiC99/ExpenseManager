package com.srishti.expensemanager.Activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.srishti.expensemanager.Entity.Category;
import com.srishti.expensemanager.Entity.Expense;
import com.srishti.expensemanager.Entity.Income;
import com.srishti.expensemanager.R;
import com.srishti.expensemanager.ViewModel.CategoryViewModel;
import com.srishti.expensemanager.ViewModel.ExpenseViewModel;
import com.srishti.expensemanager.ViewModel.IncomeViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AddNewActivity extends AppCompatActivity {
    EditText expenseAmountET;
    EditText expenseCategoryET;
    EditText expenseNoteET;
    EditText expenseDateET;
    EditText incomeAmountET;
    EditText incomeDateET;
    private ExpenseViewModel expenseViewModel;
    private IncomeViewModel incomeViewModel;
    private CategoryViewModel categoryViewModel;
    Calendar myCalendar;
    int FLAG = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        expenseAmountET = findViewById(R.id.expense_amount_et);
        expenseCategoryET = findViewById(R.id.expense_category_et);
        expenseNoteET = findViewById(R.id.expense_note_et);
        expenseDateET = findViewById(R.id.expense_date_et);
        Button expenseAddButton = findViewById(R.id.expense_add_button);
        incomeAmountET = findViewById(R.id.income_amount_et);
        incomeDateET = findViewById(R.id.income_date_et);
        Button incomeAddButton = findViewById(R.id.income_add_button);
        TextView expenseTV = findViewById(R.id.add_expense);
        TextView incomeTV = findViewById(R.id.add_income);

        myCalendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        expenseDateET.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddNewActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                FLAG = 0;
            }
        });

        incomeDateET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(AddNewActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                FLAG = 1;
            }
        });

        expenseAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addExpense();
            }
        });

        incomeAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addIncome();
            }
        });

        expenseTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        incomeTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void addExpense(){
        double amount = Double.parseDouble(expenseAmountET.getText().toString());
        String date = expenseDateET.getText().toString();
        String category = expenseCategoryET.getText().toString();
        String note = expenseNoteET.getText().toString();
        expenseViewModel = ViewModelProviders.of(this).get(ExpenseViewModel.class);
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        categoryViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                boolean isPresent = false;
                for(Category cate : categories){
                    if(cate.getName().equals(category)){
                        isPresent = true;
                        double value = cate.getValue();
                        cate.setValue(value + amount);
                        break;
                    }
                }
                if(!isPresent){
                    Category cate = new Category(category);
                    cate.setValue(amount);
                    categoryViewModel.insert(cate);
                }
            }
        });
        Expense expense = new Expense(date, amount, category);
        expense.setNote(note);
        expenseViewModel.insert(expense);
    }

    private void addIncome(){
        double amount = Double.parseDouble(incomeAmountET.getText().toString());
        String date = incomeDateET.getText().toString();
        incomeViewModel = ViewModelProviders.of(this).get(IncomeViewModel.class);
        Income income = new Income(date, amount);
        incomeViewModel.insert(income);
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        if(FLAG == 0)
            expenseDateET.setText(sdf.format(myCalendar.getTime()));
        else {
            incomeDateET.setText(sdf.format(myCalendar.getTime()));
        }
    }
}
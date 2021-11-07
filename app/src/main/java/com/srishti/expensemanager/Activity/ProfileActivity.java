package com.srishti.expensemanager.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.srishti.expensemanager.R;

public class ProfileActivity extends AppCompatActivity {
    TextView allExpensesTV;
    TextView allIncomesTV;
    TextView allCategoriesTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("YOUR PROFILE");

        allCategoriesTV = findViewById(R.id.all_category_tv);
        allExpensesTV = findViewById(R.id.all_expenses_tv);
        allIncomesTV = findViewById(R.id.all_expenses_tv);

        allIncomesTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //goToIncomes();
                Intent intent = new Intent(ProfileActivity.this, IncomeActivity.class);
                startActivity(intent);
            }
        });
        allExpensesTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //goToExpenses();
                Intent intent = new Intent(ProfileActivity.this, ExpenseActivity.class);
                startActivity(intent);
            }
        });
        allCategoriesTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //goToCategories();
                Intent intent = new Intent(ProfileActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });

    }
}
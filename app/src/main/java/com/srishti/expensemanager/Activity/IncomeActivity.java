package com.srishti.expensemanager.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.srishti.expensemanager.Adapter.IncomeAdapter;
import com.srishti.expensemanager.Entity.Income;
import com.srishti.expensemanager.R;
import com.srishti.expensemanager.ViewModel.IncomeViewModel;

import java.util.List;

public class IncomeActivity extends AppCompatActivity {
    IncomeViewModel incomeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        RecyclerView recyclerView = findViewById(R.id.income_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        IncomeAdapter adapter = new IncomeAdapter();
        recyclerView.setAdapter(adapter);

        incomeViewModel = ViewModelProviders.of(this).get(IncomeViewModel.class);
        incomeViewModel.getAllIncomes().observe(this, new Observer<List<Income>>() {
            @Override
            public void onChanged(List<Income> incomes) {
                adapter.setIncome(incomes);
            }
        });
    }
}
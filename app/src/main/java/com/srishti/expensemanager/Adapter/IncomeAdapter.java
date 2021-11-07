package com.srishti.expensemanager.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.srishti.expensemanager.Entity.Income;
import com.srishti.expensemanager.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.IncomeHolder>{
    private List<Income> incomeList;

    @NonNull
    @NotNull
    @Override
    public IncomeHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.income_item, parent, false);
        return new IncomeHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull IncomeHolder holder, int position) {
        Income currentIncome = incomeList.get(position);
        holder.incomeTV.setText(String.valueOf(currentIncome.getValue()));
        holder.dateTV.setText(currentIncome.getDate());
    }

    @Override
    public int getItemCount() {
        if(incomeList == null)
            return 0;
        return incomeList.size();
    }

    public void setIncome(List<Income> incomeList){
        this.incomeList = incomeList;
        notifyDataSetChanged();
    }

    class IncomeHolder extends RecyclerView.ViewHolder{
        private TextView incomeTV;
        private TextView dateTV;
        public IncomeHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            incomeTV = itemView.findViewById(R.id.income_rv_tv);
            dateTV = itemView.findViewById(R.id.income_date_rv_tv);
        }
    }
}

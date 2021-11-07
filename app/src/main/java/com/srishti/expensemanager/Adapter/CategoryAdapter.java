package com.srishti.expensemanager.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.srishti.expensemanager.Entity.Category;
import com.srishti.expensemanager.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder>{
    private List<Category> categories;

    @NonNull
    @NotNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new CategoryHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CategoryHolder holder, int position) {
        Category category = categories.get(position);
        holder.categoryNameTV.setText(category.getName());
        String value = String.valueOf(category.getValue());
        holder.valueInDayTV.setText(value);
        holder.valueInWeekTV.setText(value);
        holder.valueInMonthTV.setText(value);
        holder.valueInYearTV.setText(value);
    }

    @Override
    public int getItemCount() {
        if(categories == null)
            return 0;
        return categories.size();
    }

    public void setCategories(List<Category> categories){
        this.categories = categories;
        notifyDataSetChanged();
    }
    class CategoryHolder extends RecyclerView.ViewHolder{

        TextView categoryNameTV;
        TextView valueInYearTV;
        TextView valueInMonthTV;
        TextView valueInWeekTV;
        TextView valueInDayTV;

        public CategoryHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            categoryNameTV = itemView.findViewById(R.id.category_name_rv_tv);
            valueInYearTV = itemView.findViewById(R.id.value_year_rv_tv);
            valueInMonthTV = itemView.findViewById(R.id.value_month_rv_tv);
            valueInWeekTV = itemView.findViewById(R.id.value_week_rv_tv);
            valueInDayTV = itemView.findViewById(R.id.value_day_rv_tv);
        }
    }
}

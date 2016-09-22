package com.gibblicious.gdi.Sample3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {

    List<String> todoList = new ArrayList<>();

    public ToDoAdapter(List<String> dataSet) {
        todoList = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView textView = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.to_do_list_item, parent, false);

        return new ToDoAdapter.ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv.setText(todoList.get(position));
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv;

        public ViewHolder(TextView itemView) {
            super(itemView);
            tv = itemView;
        }
    }

}

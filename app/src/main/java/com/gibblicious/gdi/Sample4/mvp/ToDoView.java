package com.gibblicious.gdi.Sample4.mvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gibblicious.gdi.Sample3.ToDoAdapter;
import com.gibblicious.gdi.Sample3.ToDoRefactorActivity;
import com.gibblicious.gdi.Sample3.R;

public class ToDoView {

    RecyclerView recyclerView;

    public ToDoView(ToDoRefactorActivity activity) {
        setupViews(activity);
    }

    private void setupViews(ToDoRefactorActivity activity) {
        activity.setContentView(R.layout.activity_to_do);
        recyclerView = (RecyclerView) activity.findViewById(R.id.my_todo_list);
        LinearLayoutManager layoutMgr = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutMgr);
    }

    public void populateList(ToDoAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }

}

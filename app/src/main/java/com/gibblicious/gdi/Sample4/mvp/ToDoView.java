package com.gibblicious.gdi.Sample4.mvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.widget.Button;

import com.gibblicious.gdi.Sample3.ToDoAdapter;
import com.gibblicious.gdi.Sample3.ToDoRefactorActivity;
import com.gibblicious.gdi.Sample3.R;
import com.squareup.otto.Bus;

public class ToDoView {

    RecyclerView recyclerView;
    Button button_yes;
    Button button_no;
    Bus bus;


    public ToDoView(ToDoRefactorActivity activity, Bus bus) {
        this.bus = bus;
        setupViews(activity);

    }

    private void setupViews(ToDoRefactorActivity activity) {
        activity.setContentView(R.layout.activity_to_do);
        recyclerView = (RecyclerView) activity.findViewById(R.id.my_todo_list);
        button_no = (Button) activity.findViewById(R.id.button_no);
        button_yes = (Button) activity.findViewById(R.id.button_yes);
        LinearLayoutManager layoutMgr = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutMgr);

        button_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bus.post(new NoButtonClickedEvent());
            }
        });

        button_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bus.post(new YesButtonClickedEvent());
            }
        });
    }

    public void populateList(ToDoAdapter adapter) {
        recyclerView.setAdapter(adapter);

    }

    public static class NoButtonClickedEvent { }

    public static class YesButtonClickedEvent { }
}

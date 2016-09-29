package com.gibblicious.gdi.Sample4.mvp;

import com.gibblicious.gdi.Sample3.ToDoAdapter;

public class ToDoPresenter {

    ToDoModel model;
    ToDoView view;
    ToDoAdapter adapter;

    public ToDoPresenter(ToDoModel model, ToDoView view) {
        this.model = model;
        this.view = view;
        createAdapter();
    }

    private void createAdapter(){
        adapter = new ToDoAdapter(model.getTodoList());
    }

    public void showList(){
        view.populateList(adapter);
    }

}

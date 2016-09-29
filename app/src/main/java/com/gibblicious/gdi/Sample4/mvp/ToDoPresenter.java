package com.gibblicious.gdi.Sample4.mvp;

import com.gibblicious.gdi.Sample3.ToDoAdapter;
import com.gibblicious.gdi.Sample4.mvp.ToDoView.NoButtonClickedEvent;
import com.gibblicious.gdi.Sample4.mvp.ToDoView.YesButtonClickedEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import android.util.Log;

public class ToDoPresenter {

    private static final String TAG = "ToDoPresenter";
    ToDoModel model;
    ToDoView view;
    ToDoAdapter adapter;

    public ToDoPresenter(ToDoModel model, ToDoView view, Bus bus) {
        this.model = model;
        this.view = view;
        createAdapter();
        bus.register(this);
    }

    private void createAdapter(){
        adapter = new ToDoAdapter(model.getTodoList());
    }

    public void showList(){
        view.populateList(adapter);
    }

    @Subscribe
    public void onNoButtonClicked(NoButtonClickedEvent event){
        Log.d(TAG, "NO button clicked");
        // update view based on this result
    }

    @Subscribe
    public void onYesButtonClicked(YesButtonClickedEvent event){
        Log.d(TAG, "Yes button clicked");
        // update view based on this result
    }

}

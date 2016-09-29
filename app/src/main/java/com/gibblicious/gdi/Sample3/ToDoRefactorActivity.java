package com.gibblicious.gdi.Sample3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gibblicious.gdi.Sample4.mvp.ToDoModel;
import com.gibblicious.gdi.Sample4.mvp.ToDoPresenter;
import com.gibblicious.gdi.Sample4.mvp.ToDoView;


public class ToDoRefactorActivity extends AppCompatActivity {

    ToDoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPresenter();
    }

    private void createPresenter() {
        presenter = new ToDoPresenter(new ToDoModel(), new ToDoView(this));
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.showList();
    }

}

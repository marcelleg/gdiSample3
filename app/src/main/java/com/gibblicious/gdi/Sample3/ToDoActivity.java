package com.gibblicious.gdi.Sample3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.List;
import java.util.Arrays;

public class ToDoActivity extends AppCompatActivity {

    List<String> toDoList = Arrays.asList(
            "Go to Harris Teeter",
            "Wash the car",
            "Buy Grant a birthday present",
            "Pay AmEx bill",
            "Drop off library book",
            "Call mom",
            "change the sheets",
            "get a will",
            "replace the roof",
            "Plan fall break vacation",
            "prepare for intro to Android session 4",
            "simplify your life with fewer lists",
            "deposit check");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);
        setupViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_to_do, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //populate RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_todo_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        ToDoAdapter adapter = new ToDoAdapter(toDoList);
        recyclerView.setAdapter(adapter);
    }

}

package com.gibblicious.gdi.Sample3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;
import java.util.Arrays;

public class ToDoActivity extends AppCompatActivity {

    private static final List<String> toDoList = Arrays.asList(
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

    private static final String PREF_IS_ANDROID_USER = "com.gibblicious.gdi.sample3.isAndroidUser";

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Action", null).show();
            }
        });

        //populate RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_todo_list);

        LinearLayoutManager layoutMgr = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutMgr);

        ToDoAdapter adapter = new ToDoAdapter(toDoList);
        recyclerView.setAdapter(adapter);
    }



    public void onNoClick(View v) {
        savetoPreferences(false);
        displayPreference();
    }

    public void onYesClick(View v) {
        savetoPreferences(true);
        displayPreference();
    }


    private void savetoPreferences(boolean isAndroidUser) {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putBoolean(PREF_IS_ANDROID_USER, isAndroidUser);
        editor.commit();
    }


    private boolean getIsAndroidUserPreference() {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        return sharedPref.getBoolean(PREF_IS_ANDROID_USER, true);
    }

    private void displayPreference() {
        TextView tv = (TextView) findViewById(R.id.response);
        String s = "Response: " + String.valueOf(getIsAndroidUserPreference());
        tv.setText(s);
    }


}

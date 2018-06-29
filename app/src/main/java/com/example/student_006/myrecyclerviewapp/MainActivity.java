package com.example.student_006.myrecyclerviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRecycleViewAdapter.ItemClickListener {

MyRecycleViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> androidVersion = new ArrayList<String>();

        androidVersion.add("Android 1.0 1 BASE");
        androidVersion.add("Android 1.1 2 BASE_1_1");
        androidVersion.add("Android 1.2 3 BASE");
        androidVersion.add("Android 1.3 4 BASE_1_1");
        androidVersion.add("Android 1.4 5 BASE");
        androidVersion.add("Android 1.5 6 BASE_1_1");
        androidVersion.add("Android 1.6 7 BASE");
        androidVersion.add("Android 1.7 8 BASE_1_1");


        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter= new MyRecycleViewAdapter(this,androidVersion);
        adapter.setClickListner(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItemId(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}

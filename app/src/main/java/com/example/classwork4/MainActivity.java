package com.example.classwork4;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    private FloatingActionButton fab;
    boolean isedit =true;
    private Model_task Model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle_v);
        taskAdapter = new TaskAdapter(this, MainActivity.this);
        recyclerView.setAdapter(taskAdapter);
        fab = findViewById(R.id.fabb);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 100);
            }
        });
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        taskAdapter = new TaskAdapter(this, MainActivity.this);
//        recyclerView.setAdapter(taskAdapter);
        taskAdapter.setOnItenClickListener(new OnItenClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("title", taskAdapter.list.get(position).getTitle());
                intent.putExtra("description", taskAdapter.list.get(position).getDescription());
                intent.putExtra("poss", position);
                startActivityForResult(intent, 10);
            }
        });



    }

    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            if (data != null) ;
            Model_task model_task = new Model_task(data.getStringExtra("title"), data.getStringExtra("description"));
            taskAdapter.addData(model_task);
        }

        if (requestCode == 10 && resultCode == RESULT_OK) {
           // Model_task model_task = new Model_task(data.getStringExtra("title"), data.getStringExtra("title2"));
                Model_task modelTask = new Model_task(data.getStringExtra("title"), data.getStringExtra("description"));
                int poss = data.getIntExtra("poss", 0);
                taskAdapter.updateData(modelTask, poss);

        }
    }
}
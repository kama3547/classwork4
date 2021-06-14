package com.example.classwork4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.service.quicksettings.Tile;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.xml.transform.Result;

public class SecondActivity extends AppCompatActivity {

    EditText edit_txt,edit_txt2;
    Button btn_txt;
    Model_task model_task;
    private int position ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        edit_txt = findViewById(R.id.edit_txt);
        edit_txt2 = findViewById(R.id.edit_txt2);
        btn_txt = findViewById(R.id.btn_txt);
        btn_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edit_txt.getText().toString().trim();
                String title2 = edit_txt2.getText().toString().trim();
                if (title.isEmpty()) {
                    edit_txt.setError("Input text");
                    return;

                }
                if (title2.isEmpty()){
                    edit_txt2.setError("input text");
                }
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                    intent.putExtra("title", title);
                    intent.putExtra("description",title2 );
                    intent.putExtra("poss",position);
                    setResult(RESULT_OK, intent);
                    finish();

                }

              });
        Intent intent = getIntent();
        String editText = intent.getStringExtra("title");
        String editText2 = intent.getStringExtra("description");
        edit_txt.setText(editText);
        edit_txt2.setText(editText2);
        }
    }

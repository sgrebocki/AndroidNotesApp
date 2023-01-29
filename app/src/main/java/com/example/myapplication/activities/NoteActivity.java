package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

import java.util.HashSet;

public class NoteActivity extends AppCompatActivity {
//    EditText etInputTitle;
    EditText etInputDescription;
    Button btnSaveNote;
    int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

//        etInputTitle = findViewById(R.id.etInputTitle);
        etInputDescription = findViewById(R.id.etInputDescription);
        btnSaveNote = findViewById(R.id.btnSaveNote);

        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);

        if(noteId != -1){
            (etInputDescription).setText(HomePageActivity.notes.get(noteId));
        } else {
            HomePageActivity.notes.add("");
            noteId = HomePageActivity.notes.size() -1;
            HomePageActivity.arrayAdapter.notifyDataSetChanged();
        }

        etInputDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                HomePageActivity.notes.set(noteId, String.valueOf(s));
                HomePageActivity.arrayAdapter.notifyDataSetChanged();

                SharedPreferences sharedPreferences = getApplicationContext()
                        .getSharedPreferences("com.example.myapplication.activities", Context.MODE_PRIVATE);

                HashSet<String> set = new HashSet<>(HomePageActivity.notes);

                sharedPreferences.edit().putStringSet("notes", set).apply();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        btnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String title = etInputTitle.getText().toString();
                String description = etInputDescription.getText().toString();

                startActivity(new Intent(NoteActivity.this, HomePageActivity.class));
            }
        });
    }
}
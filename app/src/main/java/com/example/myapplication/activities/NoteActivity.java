package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

public class NoteActivity extends AppCompatActivity {
    EditText etInputTitle;
    EditText etInputDescription;
    Button btnSaveNote;
    int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        etInputTitle = findViewById(R.id.etInputTitle);
        etInputDescription = findViewById(R.id.etInputDescription);
        btnSaveNote = findViewById(R.id.btnSaveNote);

        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);

        if(noteId != -1){
            (etInputTitle).setText(HomePageActivity.notes.get(noteId));
        } else {
            HomePageActivity.notes.add("");
            noteId = HomePageActivity.notes.size() -1;
            HomePageActivity.arrayAdapter.notifyDataSetChanged();
        }

        etInputTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                HomePageActivity.notes.set(noteId, String.valueOf(s));
                HomePageActivity.arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        btnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etInputTitle.getText().toString();
                String description = etInputDescription.getText().toString();

                startActivity(new Intent(NoteActivity.this, HomePageActivity.class));
            }
        });
    }
}
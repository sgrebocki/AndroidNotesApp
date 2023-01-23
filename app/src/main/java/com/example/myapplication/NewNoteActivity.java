package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class NewNoteActivity extends AppCompatActivity {
    EditText etInputTitle;
    EditText etInputDescription;
    Button btnSaveNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        etInputTitle = findViewById(R.id.etInputTitle);
        etInputDescription = findViewById(R.id.etInputDescription);
        btnSaveNote = findViewById(R.id.btnSaveNote);

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        btnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etInputTitle.getText().toString();
                String description = etInputDescription.getText().toString();

                realm.beginTransaction();
                Note note = realm.createObject(Note.class);
                note.setTitle(title);
                note.setDescription(description);
                realm.commitTransaction();
                Toast.makeText(getApplicationContext(), "Notatka dodana", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
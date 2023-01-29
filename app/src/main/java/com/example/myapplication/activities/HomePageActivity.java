package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashSet;

public class HomePageActivity extends AppCompatActivity {

    Button btnNewNote;
    static ArrayAdapter arrayAdapter;
    static ListView listView;

    public static ArrayList<String> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        listView = (ListView) findViewById(R.id.lvNotes);

        SharedPreferences sharedPreferences = getApplicationContext()
                .getSharedPreferences("com.example.myapplication.activities", Context.MODE_PRIVATE);

        HashSet<String> set = (HashSet<String>) sharedPreferences.getStringSet("notes", null);

        if (set == null){
            notes.add("Przykładowa notatka :)");
        } else {
            notes = new ArrayList(set);
        }

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, notes);

        listView.setAdapter(arrayAdapter);

        btnNewNote = findViewById(R.id.btnNewNote);

        btnNewNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePageActivity.this, NoteActivity.class));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), NoteActivity.class);
                intent.putExtra("noteId", position);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                new AlertDialog.Builder(HomePageActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Usuń notatkę")
                        .setMessage("Czy na pewno chcesz usunąć tą notatkę?")
                        .setPositiveButton("Tak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                notes.remove(position);
                                arrayAdapter.notifyDataSetChanged();

                                SharedPreferences sharedPreferences = getApplicationContext()
                                        .getSharedPreferences("com.example.myapplication.activities", Context.MODE_PRIVATE);

                                HashSet<String> set = new HashSet<>(HomePageActivity.notes);

                                sharedPreferences.edit().putStringSet("notes", set).apply();
                            }
                        })
                        .setNegativeButton("Nie", null)
                        .show();

                return true;
            }
        });
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnCreateAcc;

    private String Username = "admin";
    private String Password = "admin";

    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnCreateAcc = findViewById(R.id.btnCreateAcc);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputUsername = etUsername.getText().toString();
                String inputPassword = etPassword.getText().toString();

                if(inputUsername.isEmpty() || inputPassword.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wpisać nazwę użytkownika oraz hasło", Toast.LENGTH_SHORT).show();
                } else {

                    isValid = validate(inputUsername, inputPassword);

                    if(!isValid){
                        Toast.makeText(MainActivity.this, "Błędny login lub hasło!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Cześć "+ inputUsername + "!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean validate(String username, String password){
        if (username.equals(Username) && password.equals(Password)){
            return true;
        } else {
            return false;
        }
    }
}
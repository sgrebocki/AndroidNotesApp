package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private EditText etLogin;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnCreateAcc;

    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnCreateAcc = findViewById(R.id.btnCreateAcc);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputLogin = etLogin.getText().toString();
                String inputPassword = etPassword.getText().toString();

                admin();

                if(inputLogin.isEmpty() || inputPassword.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wpisać login oraz hasło", Toast.LENGTH_SHORT).show();
                } else {

                    isValid = validate(inputLogin, inputPassword);

                    if(!isValid){
                        Toast.makeText(MainActivity.this, "Błędny login lub hasło!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Witaj "+ inputLogin + "!", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(MainActivity.this, HomePageActivity.class));
                    }
                }
            }
        });

        btnCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

    }

    private boolean validate(String username, String password){

        if(RegisterActivity.registerData != null){
            if (username.equals(RegisterActivity.registerData.getLogin())
                    && password.equals(RegisterActivity.registerData.getPassword())){
                return true;
            }
        }
        return false;
    }


    private void admin(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etLogin.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")){
                    Toast.makeText(MainActivity.this, "Witaj admin!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
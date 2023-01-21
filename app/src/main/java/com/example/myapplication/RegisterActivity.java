package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText etRegLogin;
    private EditText etRegEmail;
    private EditText etRegPassword;
    private EditText etRegRePassword;
    private Button btnRegister;

    public static RegisterData registerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etRegLogin = findViewById(R.id.etRegLogin);
        etRegEmail = findViewById(R.id.etRegEmail);
        etRegPassword = findViewById(R.id.etRegPassword);
        etRegRePassword = findViewById(R.id.etRegRePassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String regLogin = etRegLogin.getText().toString();
                String regEmail = etRegEmail.getText().toString();
                String regPassword = etRegPassword.getText().toString();
                String regRePassword = etRegRePassword.getText().toString();

                if(validate(regLogin, regEmail, regPassword, regRePassword)){
                    registerData = new RegisterData(regLogin, regPassword);

                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));

                    Toast.makeText(RegisterActivity.this, "Pomyślnie zarejestrowano!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validate(String login, String email, String password, String rePassword){
        if (login.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty()){
            Toast.makeText(this, "Wprowadź wszystkie potrzebne dane do rejestracji!", Toast.LENGTH_SHORT).show();
            return false;
            } else if (password.length() < 6 || password.length() < 6) {
                Toast.makeText(this, "Hasło powinno zawierać co najmniej 6 znaków!", Toast.LENGTH_SHORT).show();
                return false;
            }

        return true;
    }
}
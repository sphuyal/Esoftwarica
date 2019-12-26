package com.hello.esoftwarica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername,etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username,password;

                username = etUsername.getText().toString();
                password = etPassword.getText().toString();

                if ((username.equals("softwarica") && (password.equals("coventry"))))

                {
                    Toast.makeText(LoginActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

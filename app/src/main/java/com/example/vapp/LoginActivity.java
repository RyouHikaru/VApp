package com.example.vapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText pc1, pc2, pc3, pc4;
    String passCode;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pc1 = findViewById(R.id.pc1);
        pc2 = findViewById(R.id.pc2);
        pc3 = findViewById(R.id.pc3);
        pc4 = findViewById(R.id.pc4);

        pc1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    if (pc1.getText().length() == 1) {
                        pc2.requestFocus();
                    }
                }
                return false;
            }
        });
        pc2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    if (pc2.getText().length() == 1) {
                        pc3.requestFocus();
                    }
                    else if (pc2.getText().length() == 0) {
                        pc1.requestFocus();
                    }
                }
                return false;
            }
        });
        pc3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    if (pc3.getText().length() == 1) {
                        pc4.requestFocus();
                    }
                    else if (pc3.getText().length() == 0) {
                        pc2.requestFocus();
                    }
                }
                return false;
            }
        });
        pc4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    if (pc4.getText().length() == 0) {
                        pc3.requestFocus();
                    }
                }
                return false;
            }
        });

        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passCode = (pc1.getText().toString()) + (pc2.getText().toString()) + (pc3.getText().toString()) + (pc4.getText().toString());
                if (passCode.equals("0214")) {
                    setPassCodeTextToEmpty();
                    Toast.makeText(LoginActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                }
                else {
                    setPassCodeTextToEmpty();
                    Toast.makeText(LoginActivity.this, "Incorrect passcode", Toast.LENGTH_SHORT).show();
                    pc1.requestFocus();
                }
            }
        });
    }
    public void setPassCodeTextToEmpty() {
        pc1.setText("");
        pc2.setText("");
        pc3.setText("");
        pc4.setText("");
    }
}

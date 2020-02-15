package com.example.vapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button memoriesButton;
    Button messageButton;
    Button aboutButton;
    float msgRating = 0.0f;
    float[] descRating = {0,0,0,0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memoriesButton = findViewById(R.id.memoriesButton);
        messageButton = findViewById(R.id.messageButton);
        aboutButton = findViewById(R.id.aboutButton);

        memoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MemoriesActivity.class);
//                Toast.makeText(MainActivity.this, "Memories", Toast.LENGTH_SHORT).show();
//                startActivity(i);
                i.putExtra("RATINGVAL", descRating);
                startActivityForResult(i, 1);
            }
        });

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MessageActivity.class);
                i.putExtra("MSGRATING", msgRating);
                startActivityForResult(i, 2);
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(i);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 2) {
            msgRating = data.getFloatExtra("MSGRATING", 0.0f);
//            Toast.makeText(this, Float.toString(rating), Toast.LENGTH_SHORT).show();
        }
        else if (resultCode == 1) {
            descRating = data.getFloatArrayExtra("RATINGARR");
//            Toast.makeText(this, Float.toString(descRating[0]), Toast.LENGTH_SHORT).show();
        }
    }
}

package com.example.vapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MessageActivity extends AppCompatActivity {
    Button returnButton2;
    RatingBar msgRatingBar;
    float rating = 0.0f;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        msgRatingBar = findViewById(R.id.msgRatingBar);
        msgRatingBar.setRating(getIntent().getFloatExtra("MSGRATING", 0.0f));

        returnButton2 = findViewById(R.id.returnButton2);
        returnButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MessageActivity.this, MainActivity.class);
                i.putExtra("MSGRATING", msgRatingBar.getRating());
                setResult(2, i);
//                Toast.makeText(MessageActivity.this, Float.toString(msgRatingBar.getRating()), Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

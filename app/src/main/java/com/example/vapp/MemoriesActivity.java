package com.example.vapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MemoriesActivity extends AppCompatActivity {
    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9, img10;
    Intent i;
    Button memoriesReturnButton;
    float[] rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memories);

        rating = getIntent().getFloatArrayExtra("RATINGVAL");   // testing

        i = new Intent(MemoriesActivity.this, MemoriesDescActivity.class);

        memoriesReturnButton = findViewById(R.id.memoriesReturnButton);
        memoriesReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemoriesActivity.this, MainActivity.class);
                intent.putExtra("RATINGARR", rating);
                setResult(1, intent);
                finish();
            }
        });

        img1 = findViewById(R.id.img1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("IMGCODE", 1);
                i.putExtra("DESCRATING", rating[0]);
//                Toast.makeText(getApplicationContext(), "anime " + Float.toString(rating[0]), Toast.LENGTH_SHORT).show();
                startActivityForResult(i, 69);
            }
        });
        img2 = findViewById(R.id.img2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("IMGCODE", 2);
                i.putExtra("DESCRATING", rating[1]);
                startActivityForResult(i, 69);
            }
        });
        img3 = findViewById(R.id.img3);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("IMGCODE", 3);
                i.putExtra("DESCRATING", rating[2]);
                startActivityForResult(i, 69);
            }
        });
        img4 = findViewById(R.id.img4);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("IMGCODE", 4);
                i.putExtra("DESCRATING", rating[3]);
                startActivityForResult(i, 69);
            }
        });
        img5 = findViewById(R.id.img5);
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("IMGCODE", 5);
                i.putExtra("DESCRATING", rating[4]);
                startActivityForResult(i, 69);
            }
        });
        img6 = findViewById(R.id.img6);
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("IMGCODE", 6);
                i.putExtra("DESCRATING", rating[5]);
                startActivityForResult(i, 69);
            }
        });
        img7 = findViewById(R.id.img7);
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("IMGCODE", 7);
                i.putExtra("DESCRATING", rating[6]);
                startActivityForResult(i, 69);
            }
        });
        img8 = findViewById(R.id.img8);
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("IMGCODE", 8);
                i.putExtra("DESCRATING", rating[7]);
                startActivityForResult(i, 69);
            }
        });
        img9 = findViewById(R.id.img9);
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("IMGCODE", 9);
                i.putExtra("DESCRATING", rating[8]);
                startActivityForResult(i, 69);
            }
        });
        img10 = findViewById(R.id.img10);
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("IMGCODE", 10);
                i.putExtra("DESCRATING", rating[9]);
                startActivityForResult(i, 69);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 69) {
            rating[data.getIntExtra("INDEX", 0)] = data.getFloatExtra("DESCRATING", 0.0f);
        }
    }
}

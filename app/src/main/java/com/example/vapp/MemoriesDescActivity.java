package com.example.vapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MemoriesDescActivity extends AppCompatActivity {
    ImageView descImgView;
    TextView descTextView;
    Button mdscReturnButton;
    Intent i;
    RatingBar descRatingBar;
    int imgCode;
    float rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_desc);

        descImgView = findViewById(R.id.descImgView);
        descTextView = findViewById(R.id.descTextView);

        descRatingBar = findViewById(R.id.descRatingBar);

        mdscReturnButton = findViewById(R.id.mdscReturnButton);

        i = getIntent();
        imgCode = i.getIntExtra("IMGCODE", 0);

        rating = getIntent().getFloatExtra("DESCRATING", 0.0f);

        switch (imgCode) {
            case 1:
                descImgView.setImageResource(R.drawable.anime);
                descTextView.setText(R.string.img1_desc);
                break;
            case 2:
                descImgView.setImageResource(R.drawable.cat);
                descTextView.setText(R.string.img2_desc);
                break;
            case 3:
                descImgView.setImageResource(R.drawable.comsci);
                descTextView.setText(R.string.img3_desc);
                break;
            case 4:
                descImgView.setImageResource(R.drawable.family);
                descTextView.setText(R.string.img4_desc);
                break;
            case 5:
                descImgView.setImageResource(R.drawable.friends_1);
                descTextView.setText(R.string.img5_desc);
                break;
            case 6:
                descImgView.setImageResource(R.drawable.parents);
                descTextView.setText(R.string.img6_desc);
                break;
            case 7:
                descImgView.setImageResource(R.drawable.husky);
                descTextView.setText(R.string.img7_desc);
                break;
            case 8:
                descImgView.setImageResource(R.drawable.laptop);
                descTextView.setText(R.string.img8_desc);
                break;
            case 9:
                descImgView.setImageResource(R.drawable.fried_chicken);
                descTextView.setText(R.string.img9_desc);
                break;
            case 10:
                descImgView.setImageResource(R.drawable.milktea);
                descTextView.setText(R.string.img10_desc);
                break;
        }

        descRatingBar.setRating(rating);

        mdscReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MemoriesDescActivity.this, MemoriesActivity.class);
                i.putExtra("DESCRATING", descRatingBar.getRating());
                i.putExtra("INDEX", imgCode - 1);   // Return index of float array
                setResult(69, i);
                finish();
            }
        });
    }
}

package com.example.foodapi.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodapi.R;
import com.squareup.picasso.Picasso;

public class FoodActivity extends AppCompatActivity {
    ImageView image;
    TextView header, description, fats, protein, calories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        image = findViewById(R.id.imageload);
        header = findViewById(R.id.headingg);
        description = findViewById(R.id.descriptionn);
        fats = findViewById(R.id.fatt);
        protein = findViewById(R.id.proteinn);
        calories = findViewById(R.id.caloriess);
        Intent intent = getIntent();
        String image1 = intent.getStringExtra("image");
        String heading1 = intent.getStringExtra("heading");
        String desc1 = intent.getStringExtra("desc");
        String protein1 = intent.getStringExtra("protein");
        String fat1 = intent.getStringExtra("fat");
        String calorie1 = intent.getStringExtra("calorie");
try {
    Picasso.with(getApplicationContext()).load(image1).into(image);

//       image.setImageResource(Integer.parseInt(image1));
        header.setText(heading1);
        description.setText(desc1);
        fats.setText(protein1);
        protein.setText(fat1);
        calories.setText(calorie1);
}catch (Exception e){
    Log.d("error","failed");
}


    }
}
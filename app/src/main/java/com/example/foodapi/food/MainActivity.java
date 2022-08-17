package com.example.foodapi.food;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.foodapi.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity  {
    RecyclerView recyclerView;
    List<Record> list;
    private Context context;
    private MyOnClick MyOnClick;
    BottomNavigationView bnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        bnv=findViewById(R.id.navigation_bar);
        bnv.setSelectedItemId(R.id.home1);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Call1:
                        startActivity(new Intent(MainActivity.this,FoodActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home1:
                        return true;

                }


                return true;
            }
        });
            Apiclient apiclient = Retrofitclient.getRetrofitinstance().create(Apiclient.class);
            Call<Model> call = apiclient.getAllData();
            call.enqueue(new Callback<Model>() {


                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {
                    LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(manager);
                    Adapter adapter = new Adapter(response.body().getRecord(), MainActivity.this, new MyOnClick() {
                        @Override
                        public void onClick(Record position) {

                            Log.i("name>>>" , position.getName());

                            Log.i("url" , position.getImage());

                            Intent intent = new Intent(MainActivity.this, FoodActivity.class);
                            intent.putExtra("image", position.getImage());
                            intent.putExtra("heading", position.getHeadline());
                            intent.putExtra("desc", position.getDescription());
                            intent.putExtra("protein",position.getProteins() );
                            intent.putExtra("fat", position.getFats());
                            intent.putExtra("calorie", position.getCalories());
                            startActivity(intent);
//                            finish();

                        }
                    });
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<Model> call, Throwable t) {
                    Log.d("TAG", "onFailure: " + t.getLocalizedMessage());
                }
            });


    }


}
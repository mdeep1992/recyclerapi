package com.example.foodapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
Adapter adapter;
private List<ModelApi>list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
         getAllDatas();
        LinearLayoutManager manager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
     Adapter adapter = new Adapter(list);
        recyclerView.setAdapter(adapter);
    }
    public void getAllDatas(){

    Apiclient apiclient= Retrofitclient.getRetrofitinstance().create(Apiclient.class);
    apiclient.getAllData().enqueue(new Callback<ModelApi>() {
        @Override
        public void onResponse(Call<ModelApi> call, Response<ModelApi> response) {

            Log.i("data" , response.toString());
            Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailure(Call<ModelApi> call, Throwable t) {
            Toast.makeText(MainActivity.this, "failure", Toast.LENGTH_SHORT).show();

        }
    });

    }
}
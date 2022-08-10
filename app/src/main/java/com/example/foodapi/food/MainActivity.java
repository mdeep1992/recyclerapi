package com.example.foodapi.food;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.foodapi.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Record> list;
    private Context context;
//    Adapter adapter;
//    private List<ModelApi> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        try {
            Apiclient apiclient = Retrofitclient.getRetrofitinstance().create(Apiclient.class);
            Call<Model> call = apiclient.getAllData();
            call.enqueue(new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {
                    LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(manager);
                    Adapter adapter = new Adapter(MainActivity.this, response.body().getRecord(), new MyOnClick() {
                        @Override
                        public void onClick(View view, Record getvalue) {

                            Log.i("name>>" , getvalue.getName());
                            Log.i("desc>>"  , getvalue.getDescription());
                            Intent intent = new Intent(context, FoodActivity.class);
                            intent.putExtra("image", list.get(getAdapterPosition()).getImage());
                            intent.putExtra("heading", list.get(getAdapterPosition()).getHeadline());
                            intent.putExtra("desc", list.get(getAdapterPosition()).getDescription());
                            intent.putExtra("protein", list.get(getAdapterPosition()).getProteins());
                            intent.putExtra("fat", list.get(getAdapterPosition()).getFats());
                            intent.putExtra("calorie", list.get(getAdapterPosition()).getCalories());
                            context.startActivity(intent);

                        }

                        @Override
                        public void onLongClick(View view, int position) {

                        }
                    });
                    recyclerView.setAdapter(adapter);
                    Log.d("TAG", "onsuccess: " +toString());
                }

                @Override
                public void onFailure(Call<Model> call, Throwable t) {
                    Log.d("TAG", "onFailure: " + t.getLocalizedMessage());
                }
            });


        } catch (Exception e) {
            Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
            Log.e("Fail 2", e.toString());
            e.printStackTrace();


        }


    }
}
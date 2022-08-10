package com.example.foodapi.food;

import android.view.View;

public interface MyOnClick {

    void onClick(View view, Record record);

    void onLongClick(View view, int position);
}

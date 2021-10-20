package com.example.halkhomeworkatakan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String message = intent.getStringExtra("message");

        Toast.makeText(this, "" + name + " -- " + message, Toast.LENGTH_SHORT).show();


    }
}
package com.example.halkhomeworkatakan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

public class SerializationActivity extends AppCompatActivity {

    TextView dsTxt;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serialization);
        dsTxt = findViewById(R.id.serializeTxt);
        btn1 = findViewById(R.id.seriBtn);
        Gson gson = new Gson();

        //Log'a breakpoint koyup employee nesnesinin detaylarına bakın
        String json = "{\"first_name\":\"John\",\"age\":30,\"mail\":\"john@gmail.com\"}";
        Employee employee = gson.fromJson(json, Employee.class);
        Log.d("test","asd" +employee);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Employee employee = new Employee("John", 30, "john@gmail.com");
                String json2 = gson.toJson(employee);
                dsTxt.setText(json2);


            }
        });
    }


}
package com.example.halkhomeworkatakan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn;
    public EditText editText1;
    public String transferData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button2);
        editText1 = findViewById(R.id.editTextData);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                transferData = editText1.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("dataString", transferData);


                startActivity(intent);

            }
        });
    }


}
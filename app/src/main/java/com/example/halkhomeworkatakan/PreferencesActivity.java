package com.example.halkhomeworkatakan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PreferencesActivity extends AppCompatActivity {

    Button btnSub, btnAdd;
    TextView resultTxt;

    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        btnSub = findViewById(R.id.btnSubtraction);
        btnAdd = findViewById(R.id.btnAddition);
        resultTxt = findViewById(R.id.textResult);

        counter = PrefConfig.loadTotalFromPref(this);
        resultTxt.setText("Sonuç : " + counter);

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                counter--;
                PrefConfig.saveTotalInPref(getApplicationContext(), counter);
                resultTxt.setText("Sonuç : " + counter);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                counter++;
                PrefConfig.saveTotalInPref(getApplicationContext(), counter);
                resultTxt.setText("Sonuç : " + counter);
            }
        });
    }


}
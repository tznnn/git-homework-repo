package com.example.halkhomeworkatakan;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    Button btn, btnResultActivity, btnFragmentCreate, btnFragmentDataTransfer, btnViewPager, btnRecycleView, btnNavMenu, btnCalenderView, btnCurrentLocation,btnSharedPref,btnVolley;
    public EditText editText1;
    public String transferData, tag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, "onCreate", Toast.LENGTH_SHORT).show();

        btn = findViewById(R.id.button2);
        editText1 = findViewById(R.id.editTextData);
        btnResultActivity = findViewById(R.id.buttonResult);
        btnFragmentCreate = findViewById(R.id.buttonFragment);
        btnFragmentDataTransfer = findViewById(R.id.buttonFragmentDataTransfer);
        btnViewPager = findViewById(R.id.buttonFragmentViewPager);
        btnRecycleView = findViewById(R.id.buttonRecycleViewDetail);
        btnNavMenu = findViewById(R.id.buttonNavMenu);
        btnCalenderView = findViewById(R.id.buttonCalenView);
        btnCurrentLocation = findViewById(R.id.buttonLocation);
        btnSharedPref = findViewById(R.id.buttonPref);
        btnVolley = findViewById(R.id.buttonVolley);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                transferData = editText1.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("dataString", transferData);
                startActivity(intent);
            }
        });

        btnResultActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent(MainActivity.this, BackResultActivity.class);

                someActivityResultLauncher.launch(resultIntent);
            }
        });

        btnFragmentCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fragmentIntent = new Intent(MainActivity.this, FragmentExamplesActivity.class);
                startActivity(fragmentIntent);
            }
        });

        btnFragmentDataTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fragmentDataIntent = new Intent(MainActivity.this, FragmentDataTransferActivity.class);
                startActivity(fragmentDataIntent);
            }
        });

        btnViewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fragmentViewPager = new Intent(MainActivity.this, FragmentViewPagerActivity.class);
                startActivity(fragmentViewPager);
            }
        });

        btnRecycleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rcvPage = new Intent(MainActivity.this, RecycleViewActivity.class);
                startActivity(rcvPage);
            }
        });

        btnNavMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navPage = new Intent(MainActivity.this, NavMenuActivity.class);
                startActivity(navPage);
            }
        });

        btnCalenderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calendarPage = new Intent(MainActivity.this, CalenderActivity.class);
                startActivity(calendarPage);
            }
        });

        btnCurrentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent locationPage = new Intent(MainActivity.this, LocationActivity.class);
                startActivity(locationPage);
            }
        });

        btnSharedPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharedPrefPage = new Intent(MainActivity.this,PreferencesActivity.class);
                startActivity(sharedPrefPage);
            }
        });

        btnVolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volleyPage = new Intent(MainActivity.this,ActivityRequestResponse.class);
                startActivity(volleyPage);
            }
        });

    }

    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {

                        Toast.makeText(MainActivity.this, "Result OK", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(MainActivity.this, "Result ile Other Activity'den dönüldü", Toast.LENGTH_LONG).show();

                    }
                }
            });


    public void onStart() {
        super.onStart();
        //Toast.makeText(MainActivity.this, "onStart", Toast.LENGTH_SHORT).show();
    }

    public void onRestart() {
        super.onRestart();
        //Toast.makeText(MainActivity.this, "onRestart", Toast.LENGTH_SHORT).show();

    }

    public void onResume() {
        super.onResume();
        //Toast.makeText(MainActivity.this, "onResume", Toast.LENGTH_SHORT).show();

    }

    public void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "onPause", Toast.LENGTH_SHORT).show();

    }

    public void onStop() {
        super.onStop();
        //Toast.makeText(MainActivity.this, "onStop", Toast.LENGTH_SHORT).show();

    }

    public void onDestroy() {
        super.onDestroy();
        //Toast.makeText(MainActivity.this, "onDestroy", Toast.LENGTH_SHORT).show();

    }


}
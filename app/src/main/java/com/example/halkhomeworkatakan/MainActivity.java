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

    Button btn, btnResultActivity, btnFragmentCreate, btnFragmentDataTransfer, btnViewPager, btnRecycleView;
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

        /*
        rcv_main = findViewById(R.id.rcv_main);
        rcv_main.setHasFixedSize(true);
        rcv_main.setLayoutManager(new LinearLayoutManager(this));

        List<ItemMain> itemMainList = new ArrayList<>();
        itemMainList.add(new ItemMain(1,"asdadas"));
        itemMainList.add(new ItemMain(1,"123123"));

        itemMainList.add(new ItemMain(1,"2323"));

        itemMainList.add(new ItemMain(1,"dfgdfgd"));





        rcv_main.setAdapter(new AdapterMain(itemMainList));
*/

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
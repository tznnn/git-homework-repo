package com.example.halkhomeworkatakan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

public class FragmentDataTransferActivity extends AppCompatActivity {

    EditText editText;
    Button btnSend;
    FrameLayout frameLayout;
    String data1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_data_transfer);
        btnSend = findViewById(R.id.btnSendData);
        editText = findViewById(R.id.fragmentEditText);



        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentData1 myFragment = new FragmentData1();
                Bundle bundle = new Bundle();
                data1 = editText.getText().toString();
                bundle.putString("myData",data1);
                myFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.myFrameLayout,myFragment).commit();

            }
        });

    }


}
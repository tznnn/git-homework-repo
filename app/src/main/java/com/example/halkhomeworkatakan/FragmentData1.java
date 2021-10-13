package com.example.halkhomeworkatakan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentData1 extends Fragment {

    TextView textView;
    String myStr;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data1, container, false);
        Bundle bundle = getArguments();
        textView=view.findViewById(R.id.textFragment);

        if(bundle != null){
            myStr = bundle.getString("myData");
        }
        textView.setText(myStr);
        return view;
    }
}
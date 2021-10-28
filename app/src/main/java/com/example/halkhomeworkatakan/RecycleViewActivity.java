package com.example.halkhomeworkatakan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.halkhomeworkatakan.Model.RowModel;
import com.example.halkhomeworkatakan.MyAdapter.Adapter;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends AppCompatActivity {

    RecyclerView rcv;
    Adapter myAdapter;
    List<RowModel> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        rcv = findViewById(R.id.rcview);
        modelList = new ArrayList<>();

        rcv.setLayoutManager(new LinearLayoutManager(this));

        //RowModel rowModel = new RowModel("Atakan Tüzün", "Sa As hahaa", R.drawable.ic_launcher_background);
        modelList.add(new RowModel("Atakan Tüzün", "Sa As hahaa", R.drawable.ic_launcher_background));
        modelList.add(new RowModel("Başlık", "Açıklama", R.drawable.ic_launcher_foreground));
        modelList.add(new RowModel("DıLeley", "acıklama acıklama tey tey lalalalal", R.drawable.ic_message));
        modelList.add(new RowModel("Özge Canlı", "Android developer", R.drawable.ic_launcher_background));
        modelList.add(new RowModel("CCCCC", "Android developer 3", R.drawable.ic_launcher_background));
        modelList.add(new RowModel("BBBBB", "Android developer 4", R.drawable.ic_launcher_background));
        modelList.add(new RowModel("AAAA", "Android developer 5", R.drawable.ic_launcher_background));


        myAdapter = new Adapter(this, modelList);
        rcv.setAdapter(myAdapter);
    }
}
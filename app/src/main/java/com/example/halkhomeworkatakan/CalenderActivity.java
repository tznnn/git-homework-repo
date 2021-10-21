package com.example.halkhomeworkatakan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalenderActivity extends AppCompatActivity {

    TextView dateText;
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        dateText = findViewById(R.id.myDate);
        calendarView = findViewById(R.id.calendarView);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String selectedDate = sdf.format(new Date(calendarView.getDate()));
        dateText.setText(selectedDate);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = i2 + "." + i1 + "." + i;
                dateText.setText(date);
            }
        });
    }
}
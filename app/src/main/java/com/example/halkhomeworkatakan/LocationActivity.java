package com.example.halkhomeworkatakan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationActivity extends AppCompatActivity {

    Button btLocation;
    TextView locationTxt1, locationTxt2, locationTxt3, locationTxt4, locationTxt5;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        btLocation = findViewById(R.id.btnLocation);
        locationTxt1 = findViewById(R.id.locationTxt);
        locationTxt2 = findViewById(R.id.locationTxt2);
        locationTxt3 = findViewById(R.id.locationTxt3);
        locationTxt4 = findViewById(R.id.locationTxt4);
        locationTxt5 = findViewById(R.id.locationTxt5);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        btLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(LocationActivity.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                    getLocation();
                } else {
                    ActivityCompat.requestPermissions(LocationActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
            }
        });
    }

    private void getLocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null) {
                    try {
                        Geocoder geocoder = new Geocoder(LocationActivity.this, Locale.getDefault());
                        List<Address> addressList = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                        locationTxt1.setText(Html.fromHtml("<font color='#6200EE'><b>Enlem : </br><br></font>" + addressList.get(0).getLatitude()));
                        locationTxt2.setText(Html.fromHtml("<font color='#6200EE'><b>Boylam : </br><br></font>" + addressList.get(0).getLongitude()));
                        locationTxt3.setText(Html.fromHtml("<font color='#6200EE'><b>Ülke : </br><br></font>" + addressList.get(0).getCountryName()));
                        locationTxt4.setText(Html.fromHtml("<font color='#6200EE'><b>Şehir :  </br><br></font>" + addressList.get(0).getLocality()));
                        locationTxt3.setText(Html.fromHtml("<font color='#6200EE'><b>Adres : </br><br></font>" + addressList.get(0).getAddressLine(0)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
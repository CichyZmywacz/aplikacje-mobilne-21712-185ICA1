package com.example.fragmenty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CarDetail extends AppCompatActivity {

    //aby przekazywać identyfikator z aktywności MainActivity do CarDetail używam stałej
    public static final String EXTRA_CAR_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        // zwraca referencję do fragmentu
        CarDetailFragment carDetailFragment = (CarDetailFragment) getSupportFragmentManager().findFragmentById(R.id.car_detail_fragment);
        //pobieranie id auta i przekazanie go do fragmentu
        int carId = (int) getIntent().getExtras().get(EXTRA_CAR_ID); // pobieranie id
        carDetailFragment.setCar(carId); // ustawia id

    }
}
package com.example.fragmenty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements CarListFragment.Listener{

    public void itemClicked(long id){ //metoda definiowana przez interfejs
        Intent intent = new Intent(this, CarDetail.class);
        intent.putExtra(CarDetail.EXTRA_CAR_ID, (int)id); // przekazywanie identyfikatora
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
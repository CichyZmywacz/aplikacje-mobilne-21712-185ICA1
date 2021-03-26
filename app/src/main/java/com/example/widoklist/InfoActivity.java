package com.example.widoklist;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class InfoActivity extends AppCompatActivity {
    //info
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Toolbar toolbar = findViewById(R.id.toolbar); // pozyskanie referencji do toolbar'a, i ustawienie go jako pasek aplikacji aktywności
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar(); //toolbox pochodzi z biblioteki wsparcia
        actionBar.setDisplayHomeAsUpEnabled(true); //wyświetla przycisk powrotu do strony głównej
    }
}
package com.example.widoklist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AppleActivity extends AppCompatActivity {

    public static final String EXTRA_PHONE = "iPhoneID"; // stała

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple);

        Toolbar toolbar = findViewById(R.id.toolbar); // opisane wcześniej
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Pobieranie identyfikatora telefonu z intencji
        int iPhoneID = (Integer)getIntent().getExtras().get(EXTRA_PHONE);
        Apple apple = Apple.smartphoneApple[iPhoneID];

        //Wyświetlanie nazwy telefonu i model
        TextView name = findViewById(R.id.namePhone);
        name.setText(apple.getName());
        
        //Wyświetlamy opis
        TextView descPhone = findViewById(R.id.descPhone);
        descPhone.setText(apple.getDescription());

        //Wyświetlamy cenę
        TextView priceIphone = findViewById(R.id.priceIphone);
        priceIphone.setText(apple.getPrice());

        //Wyświetlamy zdjęcie
        ImageView phoneImage = findViewById(R.id.imagePhone);
        phoneImage.setImageResource(apple.getImageID());
        phoneImage.setContentDescription(apple.getName());
    }
}
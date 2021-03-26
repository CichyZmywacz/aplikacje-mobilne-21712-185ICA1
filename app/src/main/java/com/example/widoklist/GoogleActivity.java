package com.example.widoklist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GoogleActivity extends AppCompatActivity {

    public static final String EXTRA_PHONE_PIXEL = "googleID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Pobieranie identyfikatora telefonu z intencji
        int googleID = (Integer)getIntent().getExtras().get(EXTRA_PHONE_PIXEL);
        Google google = Google.smartphoneGoogle[googleID];

        //Wyświetlanie nazwy telefonu i model
        TextView name = findViewById(R.id.nameGoogle);
        name.setText(google.getName());

        //Wyświetlamy opis
        TextView descPhone = findViewById(R.id.descGoogle);
        descPhone.setText(google.getDescription());

        //Wyświetlamy cenę
        TextView priceIphone = findViewById(R.id.priceGoogle);
        priceIphone.setText(google.getPrice());

        //Wyświetlamy zdjęcie
        ImageView phoneImage = findViewById(R.id.imageGoogle);
        phoneImage.setImageResource(google.getImageID());
        phoneImage.setContentDescription(google.getName());
    }
}
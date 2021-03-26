package com.example.widoklist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AccessoriesActivity extends AppCompatActivity {

    public static final String EXTRA_ACCESSORIES = "accessoriesID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessories);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Pobieranie identyfikatora telefonu z intencji
        int accessoriesID = (Integer)getIntent().getExtras().get(EXTRA_ACCESSORIES);
        Accessories accessories = Accessories.accessoriesItems[accessoriesID];

        //Wyświetlanie nazwy telefonu i model
        TextView name = findViewById(R.id.nameAccessories);
        name.setText(accessories.getName());

        //Wyświetlamy opis
        TextView descPhone = findViewById(R.id.descAccessories);
        descPhone.setText(accessories.getDescription());

        //Wyświetlamy cenę
        TextView priceIphone = findViewById(R.id.priceAccessories);
        priceIphone.setText(accessories.getPrice());

        //Wyświetlamy zdjęcie
        ImageView phoneImage = findViewById(R.id.imageAccessories);
        phoneImage.setImageResource(accessories.getImageID());
        phoneImage.setContentDescription(accessories.getName());
    }
}
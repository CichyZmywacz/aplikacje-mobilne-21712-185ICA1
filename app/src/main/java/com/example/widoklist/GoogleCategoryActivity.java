package com.example.widoklist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GoogleCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_category);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter<Google> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,Google.smartphoneGoogle);
        ListView listPixel = findViewById(R.id.list_pixel);
        listPixel.setAdapter(listAdapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Obiekt nasłuchujący
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listPixel, View view, int position, long id) {
                //Brak instrukcji warunkowej if, w tym momencie obojętnie jaką opcję kliknę
                //Zostanę przeniesiony do AppleActivity
                Intent intentGoogle = new Intent(GoogleCategoryActivity.this, GoogleActivity.class); // intencja
                intentGoogle.putExtra(GoogleActivity.EXTRA_PHONE_PIXEL,(int) id); // zostaje przekazany identifikator
                startActivity(intentGoogle);
            }
        };
        //Przypisanie obiektu nasłuchującego do widoku listy
        listPixel.setOnItemClickListener(itemClickListener);
    }
}
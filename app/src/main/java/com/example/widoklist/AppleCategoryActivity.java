package com.example.widoklist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AppleCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartphones_category);

        Toolbar toolbar = findViewById(R.id.toolbar); // pozyskanie referencji do toolbar'a, i ustawienie go jako pasek aplikacji aktywności
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar(); //toolbox pochodzi z biblioteki wsparcia
        actionBar.setDisplayHomeAsUpEnabled(true); //wyświetla przycisk powrotu do strony głównej


        //ArrayAdapter łączy widok ze źródłem danych, w tym przypadku odpowiada za wyświetlenie nazw z tablicy zdefiniowanej w klasie Apple
        ArrayAdapter<Apple> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Apple.smartphoneApple);
        ListView listPhones = findViewById(R.id.list_iphone); // pozyskanie id listy
        listPhones.setAdapter(listAdapter); // przypisanie do listy danych

        //Obiekt nasłuchujący
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listPhones, View view, int position, long id) {
                //Brak instrukcji warunkowej if, w tym momencie obojętnie jaką opcję kliknę
                //Zostanę przeniesiony do AppleActivity
                Intent intentApple = new Intent(AppleCategoryActivity.this, AppleActivity.class); // intencja
                intentApple.putExtra(AppleActivity.EXTRA_PHONE,(int) id); // zostaje przekazany identifikator
                startActivity(intentApple);
            }
        };
        //Przypisanie obiektu nasłuchującego do widoku listy
        listPhones.setOnItemClickListener(itemClickListener);
    }
}
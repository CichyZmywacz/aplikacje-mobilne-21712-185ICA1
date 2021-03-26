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

public class AccessoriesCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessories_category);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayAdapter<Accessories> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,Accessories.accessoriesItems);
        ListView listAcessories = findViewById(R.id.listAcessories);
        listAcessories.setAdapter(listAdapter);

        //Obiekt nasłuchujący
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listAcessories, View view, int position, long id) {
                //Brak instrukcji warunkowej if, w tym momencie obojętnie jaką opcję kliknę
                //Zostanę przeniesiony do AppleActivity
                Intent intentAcessories = new Intent(AccessoriesCategoryActivity.this, AccessoriesActivity.class); // intencja
                intentAcessories.putExtra(AccessoriesActivity.EXTRA_ACCESSORIES,(int) id); // zostaje przekazany identifikator
                startActivity(intentAcessories);
            }
        };
        //Przypisanie obiektu nasłuchującego do widoku listy
        listAcessories.setOnItemClickListener(itemClickListener);
    }
}
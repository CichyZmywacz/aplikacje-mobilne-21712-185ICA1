package com.example.widoklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class TopLevelActivity extends AppCompatActivity {


    public boolean onOptionsItemSelected(MenuItem item){ // MenuItem to akcja umieszczona pasku aplikacji, ta kliknięta
        switch (item.getItemId()) { // pobieranie identyfikatora akcji
            case R.id.action_about:
                // intencja do InfoActivity
                Intent intent = new Intent(TopLevelActivity.this, InfoActivity.class);
                startActivity(intent);
                return true; // info dla systemu, że zostało obsłużone kliknięcie
            default:
                return  super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //dodanie elementu do paska menu
        getMenuInflater().inflate(R.menu.menu_main,menu); //plik zasobu menu. A po przecinku, obiekt Menu
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar); // pozyskanie referencji do toolbar'a, i ustawienie go jako pasek aplikacji aktywności
        setSupportActionBar(toolbar);

        //OnItemClickListener definicja interfejsu dla wywołania zwrotnego, które ma zostać wywołane po kliknięciu elementu w AdapterView
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){ //Pozycja 0 odpowiada pierwszemu elementowi w ListWiev
                    //Intencja do aktywności z telefonami Apple
                    Intent intent = new Intent(TopLevelActivity.this, AppleCategoryActivity.class);
                    startActivity(intent);
                }
                else if(position == 1){ //Pozycja 1 odpowiada drugiemu elementowi w ListWiev
                    //Intencja do aktywności z telefonami Samsung
                    Intent intent = new Intent(TopLevelActivity.this, GoogleCategoryActivity.class);
                    startActivity(intent);
                }
                else if(position == 2){ //Pozycja 2 odpowiada drugiemu elementowi w ListWiev
                    //Intencja do aktywności z akcesoriami
                    Intent intent = new Intent(TopLevelActivity.this, AccessoriesCategoryActivity.class);
                    startActivity(intent);
                }
            }
        };
        ListView listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(itemClickListener); // obiekt nasłuchujący

    }

}
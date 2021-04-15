package com.example.widoklist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class AccessoriesCategoryActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessories_category);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ListView listAcessories = findViewById(R.id.listAcessories);
        SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
        try{
            db = databaseHelper.getReadableDatabase(); //referencja do bazy danych
            cursor = db.query("TOWARACCESSORIES", new String[]{"_id", "NAME"}, null, null, null, null, null);
            // odwzorowanie zawartosci kolumny NAME wyswietlany w ListView
            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, new String[]{"NAME"}, new int[]{android.R.id.text1},0);
            listAcessories.setAdapter(listAdapter); // przypisanie do listy danych
        }
        catch (SQLException e){
            Toast toast = Toast.makeText(this, "Baza danych jest niedostępna", Toast.LENGTH_SHORT);
            toast.show();
        }

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

    public void onDestroy() {
        // zamykamy kursor i bazę danych
        super.onDestroy();
        cursor.close();
        //kursor pozostaje otwarty do momentu az adapter nie bedzie go potrzebowac
        db.close();
    }
}
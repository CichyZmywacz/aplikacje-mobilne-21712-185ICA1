package com.example.widoklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.TimingLogger;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


public class TopLevelActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor favoritesCursor;

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

    private void setupOptionsListView(){

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


    private void setupFavoritesListView(){
        //wypełnienie ListView danymi z kursora
        ListView listViewFav = findViewById(R.id.list_favorites);

        try{
            SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
            db = databaseHelper.getReadableDatabase();
            favoritesCursor = db.query("TOWARAPPLE", new String[] {"_id","NAME"},"FAVORITE = 1",null,null,null,null);

            CursorAdapter favoriteAdapter = new SimpleCursorAdapter(TopLevelActivity.this, android.R.layout.simple_list_item_1,favoritesCursor, new String[] {"NAME"}, new int[]{android.R.id.text1},0);
            listViewFav.setAdapter(favoriteAdapter);

        }
        catch(SQLiteException e){
            Toast toast = Toast.makeText(this, "Baza danych jest niedostępna", Toast.LENGTH_SHORT);
            toast.show();
        }

        listViewFav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TopLevelActivity.this,AppleActivity.class);
                intent.putExtra(AppleActivity.EXTRA_PHONE, (int)id);
                startActivity(intent);
            }
        });
    }

    public void onRestart() {
        super.onRestart();
        Cursor newCursor = db.query("TOWARAPPLE", new String[] {"_id","NAME"},"FAVORITE = 1",null,null,null,null);
        ListView listViewFav = findViewById(R.id.list_favorites);
        CursorAdapter adapter = (CursorAdapter) listViewFav.getAdapter();
        adapter.changeCursor(newCursor);
        favoritesCursor = newCursor;
    }


    public void onDestroy(){
        super.onDestroy();
        favoritesCursor.close();
        db.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupOptionsListView();
        long startTime = System.nanoTime(); //rozpoczęcie pomiaru czasu
        setupFavoritesListView();
        long endTime = System.nanoTime();  //zakończenie pomiaru czasu
        long duration = (endTime - startTime) ;
        System.out.println("Czas: " + duration); // wyświetlenie w konsoli czasu
    }
}
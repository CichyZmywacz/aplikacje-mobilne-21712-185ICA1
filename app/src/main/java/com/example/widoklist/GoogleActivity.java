package com.example.widoklist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        try{
            SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
            SQLiteDatabase db = databaseHelper.getReadableDatabase();
            // kursor pobiera dane z tabeli TOWARAPPLE w ktorym
            // wartosc kolumny _id jest rowna z iPhoneID
            Cursor cursor = db.query("TOWARGOOGLE",
                    new String[]{"NAME","DESCRIPTION","PRICE","IMAGE_RESOURCE_ID"},"_id = ?",
                    new String[] {Integer.toString(googleID)},null,null,null);

            if(cursor.moveToFirst()){ // pierwszy rekord w kursorze
                String nameText = cursor.getString(0); //pobieranie danych cursorem
                String descriptionText = cursor.getString(1);
                String priceText = cursor.getString(2);
                int photoId = cursor.getInt(3);

                //Wyświetlanie nazwy telefonu i model
                TextView name = findViewById(R.id.nameGoogle);
                name.setText(nameText);

                //Wyświetlamy opis
                TextView descPhone = findViewById(R.id.descGoogle);
                descPhone.setText(descriptionText);

                //Wyświetlamy cenę
                TextView priceIphone = findViewById(R.id.priceGoogle);
                priceIphone.setText(priceText);

                //Wyświetlamy zdjęcie
                ImageView phoneImage = findViewById(R.id.imageGoogle);
                phoneImage.setImageResource(photoId);
                phoneImage.setContentDescription(nameText);

            }
        }
        catch (SQLException e){
            //komunikat o błędzie
            Toast toast = Toast.makeText(this, "Baza danych jest niedostępna", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
package com.example.widokigrupy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityTwo extends AppCompatActivity {
    ImageView imageView;

    public void useSwitch(View view){
        imageView = findViewById(R.id.imageView);// id imageView
        boolean on = ((Switch) view).isChecked(); // wartośc boolean dla switch on/off

        if(on){
            // gdy switch jest włączony wyświetla poniższy obrazek
            imageView.setImageResource(R.drawable.ship);
        }
        else {
            // w przeciwnym wypadku wyświetli ten
            imageView.setImageResource(R.drawable.air);
        }
    }

    public void backToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class); // intencja, do aktywności głównej
        startActivity(intent);
    }

    public void useToastMessage(View view){
        // wiadomośc TOAST, wyświetlana w aktywności nr2
        Toast.makeText(MainActivityTwo.this,"Witam w aplikacji Lab3", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);
    }
}
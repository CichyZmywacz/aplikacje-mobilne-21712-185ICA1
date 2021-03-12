package com.example.aktywnosciintencje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainThreeActivity extends AppCompatActivity {

    private static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_three);

        Intent intent = getIntent(); //pobranie intancji
        // Dwa poniższe wiersze, pierw pobierają intancję
        // następnie za pomocą metody getStringExtra odczytują przekazany łańcuch znaków
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageView = (TextView)findViewById(R.id.message);
        // Poniższy łańcuch znaków wyświetla pobrany łańcuch znaków w TextView
        messageView.setText(messageText);
    }

    public void backToMain(View view){
        Intent intent = new Intent(this, MainActivity.class); // nowa intencja,
        // za jej pomocą przycisk przeniesie nas do aktywności głównej
        startActivity(intent);
    }

    public void backToAct2(View view){
        Intent intent = new Intent(this, MainTwoActivity.class); // nowa intancja
        // za jej pomocą przycisk przeniesie nas do aktywności nr1
        startActivity(intent);
    }

    public void backToAct3(View view){
        Intent intent = new Intent(this, MainFourActivity.class); // nowa intancja
        // za jej pomocą przycisk przeniesie nas do aktywności nr3
        startActivity(intent);
    }
}
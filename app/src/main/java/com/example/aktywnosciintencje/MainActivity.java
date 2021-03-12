package com.example.aktywnosciintencje;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSendMassage(View view){ // Przycisk wywołujący aktywnośc nr1
        // dwa wiersze ponieżej pobierają tekst z pola TextView o id message
        EditText messageView = (EditText)findViewById(R.id.massage);
        String messageText = messageView.getText().toString(); // getText pobiera dane z komponentu a następnie są parsowane na String

        Intent intent = new Intent(this,MainTwoActivity.class); // tworzenie nowej intencji
        intent.putExtra("message", messageText); // zapisanie dodatkowych informacji za pomocą metody putExtra()
        startActivity(intent); // uruchamia aktywnośc jaka jest opisana w intencji

    }
    // to samo co powyżej
    public void onSendMessageToActivityTwo(View view){ // Przycisk wywołujący aktywnośc nr2
        EditText messageView = (EditText)findViewById(R.id.massage);
        String messageText = messageView.getText().toString();

        Intent intent = new Intent(this,MainThreeActivity.class);
        intent.putExtra("message", messageText);
        startActivity(intent);
    }

    public void onSendMessageToActivityThree(View view){// Przycisk wywołujący aktywnośc nr3
        EditText messageView = (EditText)findViewById(R.id.massage);
        String messageText = messageView.getText().toString();

        Intent intent = new Intent(this,MainFourActivity.class);
        intent.putExtra("message", messageText);
        startActivity(intent);
    }
}
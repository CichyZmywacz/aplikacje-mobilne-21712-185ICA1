package com.example.aktywnosciintencje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainFourActivity extends AppCompatActivity {

    private static final String EXTRA_MESSAGE = "message";
    // kod taki sam jak w MainThreeActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_four);

        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageView = (TextView)findViewById(R.id.message);
        messageView.setText(messageText);
    }

    public void backToMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void backToAct2(View view){
        Intent intent = new Intent(this, MainTwoActivity.class);
        startActivity(intent);
    }

    public void backToAct3(View view){
        Intent intent = new Intent(this, MainThreeActivity.class);
        startActivity(intent);
    }
}
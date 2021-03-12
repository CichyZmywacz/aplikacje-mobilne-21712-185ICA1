package com.example.aktywnosciintencje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainTwoActivity extends AppCompatActivity {
    //kod taki sam jak w MainThreeActivity
    protected static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageView = (TextView)findViewById(R.id.message);
        messageView.setText(messageText);
    }

    public void backClick(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void backToAct2(View view){
        Intent intent = new Intent(this, MainThreeActivity.class);
        startActivity(intent);
    }

    public void backToAct3(View view){
        Intent intent = new Intent(this, MainFourActivity.class);
        startActivity(intent);
    }
}
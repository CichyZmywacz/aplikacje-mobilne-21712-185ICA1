package com.example.fragmenty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class TempActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        if (savedInstanceState == null){
            StopwatchFragment stopwatchFragment = new StopwatchFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction(); // rozpoczęcie transakcji obiektu
            ft.add(R.id.container, stopwatchFragment);// dodanie stopera do układu
            ft.addToBackStack(null); //umieszczanie transakcji na stosie cofnięć
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);// efekt stopniowego przejścia
            ft.commit();// zatwierdzenie transakcji
        }
    }
}
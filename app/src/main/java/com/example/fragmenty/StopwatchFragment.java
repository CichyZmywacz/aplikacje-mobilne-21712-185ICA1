package com.example.fragmenty;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StopwatchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StopwatchFragment extends Fragment implements View.OnClickListener{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private int seconds = 0; //zmierzone sekundy
    private boolean running; //informuje czy stoper działa
    private boolean wasRunning; // informuje czy stoper działał przed wstrzymaniem aktywności


    public StopwatchFragment() {
        // Required empty public constructor
    }

    public static StopwatchFragment newInstance(String param1, String param2) {
        StopwatchFragment fragment = new StopwatchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null){
            // odtwarzanie wartości zmiennych
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        runTimer(layout); //przekazanie obiektu układu do metody runTimer
        //dołączenie obiektu nasłuchującego do przycisku
        Button startButton = layout.findViewById(R.id.start_button);
        startButton.setOnClickListener(this);
        Button stopButton = layout.findViewById(R.id.stop_button);
        startButton.setOnClickListener(this);
        return layout;
    }

    public void onPause() {
        super.onPause();
        wasRunning = running; // zapisujemy informacje czy stoper działał przed zatrzymaniem
        running = false; // zatrzymanie stopera
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        // zapisanie wartości zmiennych w obiekcie Bundle przed usunięciem aktywności
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.getBoolean("running",running);
        savedInstanceState.getBoolean("wasRunning",wasRunning);
    }

    private void onClickStart(){
        running = true; // włączenie stopera po kliknieciu start
    }

    private void onClickStop(){
        //zatrzymanie stoperu
        running = false;
        seconds = 0;
    }


    private void runTimer(View view) {
        final TextView timeView = (TextView) view.findViewById(R.id.timer_view);
        final Handler handler = new Handler(); // obiekt Handler, umozliwia działanie kodu w tle
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600; // godziny
                int minutes = (seconds % 3600) / 60; // minuty
                int secs = seconds % 60; // sekundy

                String time = String.format("%d:%02d:%02d", hours,minutes,secs);
                timeView.setText(time);
                if (running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }

    @Override
    public void onClick(View v) { //przesłanianie metody onClick interfejsu OnClickListener
        switch (v.getId()){
            case R.id.start_button:
                onClickStart();
                break;
            case  R.id.stop_button:
                onClickStop();
                break;
        }
    }
}
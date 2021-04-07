package com.example.fragmenty;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CarDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarDetailFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    // zmienne
    private long carId;

    public CarDetailFragment() {
        // Required empty public constructor
    }

    public void onStart() {
        super.onStart();
        View view = getView();  //pobiera główny widok fragmentu
        if (view != null){
            TextView title = (TextView) view.findViewById(R.id.fragmentTitle); //znajdywanie po ID tytułu i przypisywanie go do zmiennej title
            Cars cars = Cars.cars[(int) carId]; //id
            title.setText(cars.getName()); //ustawia odpowiedni tytuł
            TextView description = (TextView) view.findViewById(R.id.fragmentDescription);
            description.setText(cars.getDescription()); // ustawia odpowiedni opis.
        }
    }
    
    public void setCar(long id){ // metoda do ustalenia id auta
        this.carId = id;
    }

    // TODO: Rename and change types and number of parameters
    public static CarDetailFragment newInstance(String param1, String param2) {
        CarDetailFragment fragment = new CarDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null){
            StopwatchFragment stopwatchFragment = new StopwatchFragment();
            FragmentTransaction ft = getChildFragmentManager().beginTransaction(); // rozpoczęcie transakcji obiektu
            ft.add(R.id.container, stopwatchFragment);// dodanie stopera do układu
            ft.addToBackStack(null); //umieszczanie transakcji na stosie cofnięć
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);// efekt stopniowego przejścia
            ft.commit();// zatwierdzenie transakcji
        } else {
            carId = savedInstanceState.getLong("carId");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // ta metoda wywoływana jest za każdym razem gdy
        // gdy Android potrzebuje układu fragmentu
        return inflater.inflate(R.layout.fragment_car_detail, container, false); //wypełnia układ fragmentu
    }
}
package com.example.fragmenty;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class CarListFragment extends ListFragment {

    interface Listener {
        void itemClicked(long id);
    }
    // interfejs nasłuchujący oraz obiekt nasłuchujący
    private Listener listener;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public CarListFragment() {
        // Required empty public constructor
    }

    public static CarListFragment newInstance(String param1, String param2) {
        CarListFragment fragment = new CarListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] names = new String[Cars.cars.length];
        for (int i = 0; i < names.length; i++){
            names[i]= Cars.cars[i].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(), // kontekst
                android.R.layout.simple_list_item_1, // typ listy
                names); // tablica z tytułami
        setListAdapter(adapter); //przekazanie adaptera do widoku listy

        // Inflate the layout for this fragment
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    public void onAttach(Context context){
        super.onAttach(context);
        this.listener = (Listener)context;
    }

    public void onListItemClick(ListView ListView, View itemView, int position, long id){
        if(listener != null){
            //przekazywanie ob nasłuchującemu informacji o kliknięcu elementu z ListView
            listener.itemClicked(id);
        }
    }
}
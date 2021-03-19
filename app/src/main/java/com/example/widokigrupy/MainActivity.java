package com.example.widokigrupy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    protected CheckBox  cocaColaCheckBox, pepsiCheckBox;
    protected Button resultCheckBoxBTN;
    protected TextView textViewCheckBox, textViewRadioButton;
    protected ArrayList<String> arrayCheckBox;
    protected RadioGroup radioGroup;

    public void useCheckBox(){
        //Pobieranie id'ków komponentów
        cocaColaCheckBox = findViewById(R.id.checkBoxCola);
        pepsiCheckBox = findViewById(R.id.checkBoxPepsi);
        resultCheckBoxBTN = findViewById(R.id.wynik);
        textViewCheckBox = findViewById(R.id.wyswietlWynik);
        arrayCheckBox = new ArrayList<>(); // ArrayList
        textViewCheckBox.setEnabled(false); // wyłączony TextView
    // try catch - zabezpieczenie przed wysypaniem się aplikacji
        try {
            // po kliknięciu zostanie wywołana funkcja onClick
                cocaColaCheckBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cocaColaCheckBox.isChecked()) { // gdy zaznaczymy CocaCola to zostanie dodany napis do tablicy
                            arrayCheckBox.add("Coca-Cola");
                        } else { // w przeciwnym wypadku zostanie on usuniety
                            arrayCheckBox.remove("Coca-Cola");
                        }
                    }
                });

                pepsiCheckBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (pepsiCheckBox.isChecked()) {
                            arrayCheckBox.add("Pepsi"); // to samo co powyżej tylko zrobione dla itemu "Pepsi"
                        } else {
                            arrayCheckBox.remove("Pepsi");
                        }
                    }
                });
                // po kliknięcu w przycisk zostanie wywołana funkcja onClick
                resultCheckBoxBTN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        StringBuilder stringBuilder = new StringBuilder(); //powołanie obiektu stringBuilder
                        for (String s : arrayCheckBox) { // pętla foreach
                            stringBuilder.append(s).append("\n"); // łączymy ciągi znaków
                            // dodajemy napis CocaCola lub Pepsi do sekwencji znaków
                            // oraz przejście do nowej lini
                        }

                        textViewCheckBox.setText((stringBuilder.toString())); // wyświetlamy tekst w ViewText
                        textViewCheckBox.setEnabled(false); // wyłączony TextView
                    }
                });
            }
        catch(Exception e){
                textViewCheckBox.setText("Błąd");
            }

    }

    @SuppressLint("SetTextI18n")
    public  void udeRadioButtons()
    {
        // pobranie id'ków
        radioGroup = findViewById(R.id.radioGroup);
        textViewRadioButton = findViewById(R.id.textViewRadioButton);
        //zabezpieczenie programu przed błędami try i catch
        try {
            // setOnCheckedChangeListener to definicja interfejsu dla wywołania zwrotnego,
            // które ma zostać wywołane, gdy zmieni się stan zaznaczenia przycisku
            radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
                if(checkedId == R.id.radioButton1){ // gdy zostanie zaznaczony radioButton1 wyświetli nam poniższy napis
                    textViewRadioButton.setText("Witam Pana !");
                }
                else { // w przeciwnym wypadku wyświetli ten napis
                    textViewRadioButton.setText("Witam Panią !");
                }
            });
        }
        catch (Exception e) {
            textViewRadioButton.setText("Błąd !"); // w wypadku błędu wyświetli "Błąd"
            }
    }

    public void spinner(){
        Spinner spinner = findViewById(R.id.spinner);// id spinnera
        //poniższy kworzy nowy ArrayAdapter z zasobów zewnętrznych
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //stawia zasób układu do tworzenia widoków rozwijanych
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this); //zarejestruj wywołanie zwrotne, które ma być wywoływane, gdy zostanie wybrany element w tym AdapterView
    }

    public void toActivityTwo(View view){
        Intent intent = new Intent(this, MainActivityTwo.class); // intencja do nowej aktywności
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        useCheckBox();
        udeRadioButtons();
        spinner();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
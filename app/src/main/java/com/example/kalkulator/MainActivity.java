package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText displayText;
    Spinner spinnerOp = null;
    String[] names = {"+","-","*","/"}; // itemy do ListyRozwijanej
    String op; // zmienna pomocnicza, przechowuje wybrany znak operacji

    ArrayAdapter <String> adapter; // adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerOp = (Spinner)findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,names);
        //za pomocą tego adaptera można udostępniać widoki dla AdapterView
        // //Zwraca on widok dla każdego obiektu w kolekcji dostarczonych obiektów danych i może być używany z widgetami
        // // interfejsu użytkownika opartymi na liście, takimi jak ListViewlub Spinner.
        displayText = findViewById(R.id.textView);
        spinnerOp.setAdapter(adapter);

        spinnerOp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // wywołanie zwrotne, które ma zostać wywoływane, gdy zostanie wybrany element w AdapterView
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        op = "+"; // dodawanie
                        break;
                    case 1:
                        op = "-"; // odejmowanie
                        break;
                    case 2:
                        op = "*"; // mnożenie
                        break;
                    case 3:
                        op = "/"; // dzielenie
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        displayText.setShowSoftInputOnFocus(false); // po kliknieciu w textView usuwa wysuwającą się klawiaturę Androida

        displayText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(displayText.getText().toString())){
                    displayText.setText(""); // gdy klikniemy na teskt 'Wprowadź dane' zostanie on zastąpiony tym co mamy w nawiasach
                    // czyli zostanie wyczyszczony TextView
                }
            }
        });
    }

    private void updateText(String strToAdd){
        String oldStr = displayText.getText().toString();
        int cursorPos = displayText.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.display).equals(displayText.getText().toString())){
            //po naciśnięciu przycisku (jakiejś liczby)
            // to ona teraz staje się początkową wartością w TextView
            displayText.setText(strToAdd);
            displayText.setSelection(cursorPos + 1); // przesuwa kursor zawsze do prawej
        }
        else {
            displayText.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
            displayText.setSelection(cursorPos + 1); // przesuwa kursor zawsze do prawej
        }
    }

    public void zeroBTN(View view){
        updateText("0"); // po kliknięciu zawartość TextView zostaje zaktualizowana o liczbę 0
    }

    public void oneBTN(View view){
        updateText("1"); // tak samo jak wyżej tylko aktualizuję o liczbę 1
    }

    public void twoBTN(View view){
        updateText("2");

    }

    public void threeBTN(View view){
        updateText("3");

    }

    public void fourBTN(View view){
        updateText("4");

    }

    public void fiveBTN(View view){
        updateText("5");

    }

    public void sixBTN(View view){
        updateText("6");

    }

    public void sevenBTN(View view){
        updateText("7");

    }

    public void eightBTN(View view){
        updateText("8");

    }

    public void nineBTN(View view){
        updateText("9");

    }

    public void plusMinusBTN(View view){
        updateText("-");
    }

    public void pointBTN(View view){
        updateText(".");

    }

    public void equalsBTN(View view){
        String userExp = displayText.getText().toString();

        Expression exp = new Expression(userExp);
        String result = String.valueOf((exp.calculate())); // obliczenia za pomocą mXparser

        displayText.setText(result);
        displayText.setSelection(result.length());

        if(displayText.getText().toString().equals("NaN")){ // gdy zostanie wykryty błąd przykładowo dzielenie przez 0
            displayText.setText("Błąd !"); // to wyświetlany jest komunikat o błędzie
        }
    }

    public void cBTN(View view){
        displayText.setText(""); // czyszczenie

    }

    public void parenthesesBTN(View view){ // nawiasy
        int cursorPos = displayText.getSelectionStart(); // pozycja kursora
        int opecPar = 0;
        int closedPar = 0;
        int textLen = displayText.getText().length();

        for(int i = 0; i < cursorPos; i++){
            if(displayText.getText().toString().substring(i,i+1).equals("(")){
                opecPar += 1; // jest to informacja, że został wykorzystany nawias otwarty
            }
            if(displayText.getText().toString().substring(i,i+1).equals(")")){
                closedPar  += 1; // jest to informacja, że został wykorzystany nawias zamkniety
            }
        }

        if(opecPar == closedPar || displayText.getText().toString().substring(textLen - 1, textLen).equals("")){
            // jeżeli openPar i ClosedPar są równe lub pozycja ostatnia i przedostatnia są równe ""
            updateText("("); // to może zostać wpisany nawias otwarty
        }

        else if(closedPar < opecPar && !displayText.getText().toString().substring(textLen - 1, textLen).equals("")){
            // jeżeli closedPar jest na 0 a openPar jest na 1 oznacza to że nawias ( został już uzyty
            // i może zostać użyty nawias zamykający
            updateText(")"); // wpisywanie nawiasu zamkniętego
        }
        displayText.setSelection(cursorPos + 1); // pozycja kursora wraca na prawo
    }

    public void backspaceBTN(View view){
        int cursorPos = displayText.getSelectionStart(); // pozycja kursora
        int textLen = displayText.getText().length(); // długośc obecnego ciągu znaków

        if(cursorPos != 0 && textLen != 0){ // jeśli cursorPos i textLen są różne od zera
            SpannableStringBuilder selection = (SpannableStringBuilder) displayText.getText();
            // SpannableStringBuilder jest to klasa dla tekstu, którego zawartość i znaczniki można zmienić.
            selection.replace(cursorPos -1, cursorPos, "");
            // zastępujemy miejsce ostatnie, miejscem pustym
            displayText.setText(selection); // wyświetla zmieniny tekst
            displayText.setSelection(cursorPos - 1); // ustawia kursor po zmianach na pozycji o jeden w lewo
        }
    }

    public void selectBTN(View view){
        updateText(op); // wyświetla wybrany typ działania ( + - * /)
    }
}
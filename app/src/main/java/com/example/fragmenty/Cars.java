package com.example.fragmenty;

public class Cars {
    private String name;
    private  String description;

    public static final Cars[] cars = { // tablica przechowująca dane
            new Cars("Audi A8", "Samochód osobowy klasy luksusowej."),
            new Cars("Volvo V60", "Samochód osobowy klasy średniej.")
    };

    public Cars(String name, String description){  // konstruktor
        this.name = name;
        this.description = description;
    }
    // gety do pobierania wartości ze zmiennych prywatnych
    public String getName() { // metody get pobierają prywatne dane obiektów
        return name;
    }

    public String getDescription(){
        return description;
    }
    public String toString(){
        return  name;
    }
}

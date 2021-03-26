package com.example.widoklist;

public class Apple {

    private String name; // zmienne nazwa, opis, cena i id zdjęcia
    private String description;
    private String price;
    private int imageID;

    public static final Apple[] smartphoneApple = { //tablica zawierająca dane o produktach
        new Apple("iPhone 12 mini","Opis: Procesor A14 Bionic. ","Cena: 3200 zł", R.drawable.iphonemini),
        new Apple("iPhone 11", "Opis: Procesor A13 Bionic.", "Cena: 2899 zł", R.drawable.iphonejedenjeden),
        new Apple("iPhone 12", "Opis: Procesor A14 Bionic. ","Cena: 3800 zł", R.drawable.iphonejedendwa)
    };

    private Apple(String name, String description, String price, int imageID){ // konstruktor
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageID = imageID;
    }

    public String getName(){
        return name;
    } // get'y dzieki nim uzyskujemy 'dostęp' do zmiennych prywatnych

    public String getDescription(){
        return description;
    }

    public String getPrice(){return price;}

    public int getImageID() {
        return imageID;
    }

    public String toString(){
        return this.name;
    }

}

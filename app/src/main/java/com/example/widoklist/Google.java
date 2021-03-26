package com.example.widoklist;

public class Google {

    private String name; // zmienne
    private String description;
    private String price;
    private int imageID;

    public static final Google[] smartphoneGoogle = { //tablica
            new Google("Google Pixel 4","Opis: Procesor A14 Bionic. ","Cena: 3200 zł", R.drawable.googlepixelcztery),
            new Google("Google Pixel 4a", "Opis: Procesor A13 Bionic.", "Cena: 2899 zł", R.drawable.googlepixelczterya),
            new Google("Google Pixel 5", "Opis: Procesor A14 Bionic. ","Cena: 4800 zł", R.drawable.googlepixelpiec)
    };

    private Google(String name, String description, String price, int imageID){
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageID = imageID;
    }

    public String getName(){
        return name;
    }

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


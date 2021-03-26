package com.example.widoklist;

public class Accessories {

    private String name;
    private String description;
    private String price;
    private int imageID;

    public static final Accessories[] accessoriesItems = {
            new Accessories(" Ladowarka do iPhone 12"," Opis: Zwykła ładowarka, której Apple nie dało w zestawie.... "," Cena: 399 zł", R.drawable.appleladowarka),
            new Accessories(" Szkło HardGlass do Google Pixel 5", " Opis: To wyjątkowe hartowane szkło.", " Cena: 40 zł", R.drawable.szklopixel),
            new Accessories(" Pioneer SE-C4BT Białe", " Opis: Pioneer SE-C4BT to bezprzewodowe słuchawki dokanałowe."," Cena: 140 zł", R.drawable.pionner)
    };

    private Accessories(String name, String description, String price, int imageID){
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

package com.example.widoklist;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "magazyn"; //nazwa bazy danych
    private static final int DB_VERSION = 5; // wersja bazy danych

    public DatabaseHelper(Context context) { //konstruktor okresla szczegolowe informacje o bazie danych
        //wywołanie konstruktora klasy bazowej
        //przekazujemy do niego nazwe i numer wersji bazy danych
        super(context, DB_NAME,null, DB_VERSION);
    }

    private static void insertDataApple(SQLiteDatabase db, String name, String description, String price, int resourceId){ //przyjmowane parametry
        ContentValues appleValues = new ContentValues();
        appleValues.put("NAME", name); //nazwa
        appleValues.put("DESCRIPTION", description); // opis
        appleValues.put("PRICE", price); // cena
        appleValues.put("IMAGE_RESOURCE_ID", resourceId); // obraz
        db.insert("TOWARAPPLE",null, appleValues);
        //metoda ulatwiajaca zapis kilku produktow
    }

    private static void insertDataGoogle(SQLiteDatabase db, String name, String description, String price, int resourceId){
        ContentValues googleValues = new ContentValues();
        googleValues.put("NAME", name);
        googleValues.put("DESCRIPTION", description);
        googleValues.put("PRICE", price);
        googleValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("TOWARGOOGLE",null, googleValues);
        //metoda ulatwiajaca zapis kilku produktow
    }

    private static void insertDataAccessories(SQLiteDatabase db, String name, String description, String price, int resourceId){
        ContentValues accessoriesValues = new ContentValues();
        accessoriesValues.put("NAME", name);
        accessoriesValues.put("DESCRIPTION", description);
        accessoriesValues.put("PRICE", price);
        accessoriesValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("TOWARACCESSORIES",null, accessoriesValues);
        //metoda ulatwiajaca zapis kilku produktow
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateDatabase(db,0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //ta metoda jest wywoływana gdy pojawi się potrzeba aktualizacji bazy danych
        updateDatabase(db,oldVersion, newVersion);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //ta metoda jest wywoływana gdy pojawi się potrzeba przyrocenie poprzedniej wersji
    }

    private void updateDatabase(SQLiteDatabase db, int oldVersion, int newVersion){
        if(oldVersion < 1){

            //tworzenie tabeli TOWAR
            //zawiera ona
            // id zwiększający się o 1 automatycznie
            // pola tekstowe do nazwy i opisu produktu
            // oraz pole zawierające id zdjecia
            db.execSQL("CREATE TABLE TOWARAPPLE (_id INTEGER PRIMARY KEY AUTOINCREMENT, " //tabela dla Apple
                    + "NAME TEXT,"
                    + "DESCRIPTION TEXT, "
                    + "PRICE TEXT,"
                    + "IMAGE_RESOURCE_ID INTEGER);");
            db.execSQL("CREATE TABLE TOWARGOOGLE (_id INTEGER PRIMARY KEY AUTOINCREMENT, " //tabela dla Google
                    + "NAME TEXT,"
                    + "DESCRIPTION TEXT, "
                    + "PRICE TEXT,"
                    + "IMAGE_RESOURCE_ID INTEGER);");
            db.execSQL("CREATE TABLE TOWARACCESSORIES (_id INTEGER PRIMARY KEY AUTOINCREMENT, " //tabela dla Accessories
                    + "NAME TEXT,"
                    + "DESCRIPTION TEXT, "
                    + "PRICE TEXT,"
                    + "IMAGE_RESOURCE_ID INTEGER);");
            // zostaly stworzone trzy tabele dla poszczegolnych aktywnosci

            //Apple
            insertDataApple(db,"iPhone 12 mini", "Opis: Procesor A14 Bionic.", "Cena: 3200 zł", R.drawable.iphonemini);
            insertDataApple(db,"iPhone 11", "Opis: Procesor A13 Bionic.", "Cena: 2899 zł", R.drawable.iphonejedenjeden);
            insertDataApple(db,"iPhone 12", "Opis: Procesor A14 Bionic. ","Cena: 3800 zł", R.drawable.iphonejedendwa);
            //Akcesoria
            insertDataAccessories(db," Ladowarka do iPhone 12"," Opis: Zwykła ładowarka, której Apple nie dało w zestawie.... "," Cena: 399 zł", R.drawable.appleladowarka);
            insertDataAccessories(db," Szkło HardGlass do Google Pixel 5", " Opis: To wyjątkowe hartowane szkło.", " Cena: 40 zł", R.drawable.szklopixel);
            insertDataAccessories(db," Pioneer SE-C4BT Białe", " Opis: Pioneer SE-C4BT to bezprzewodowe słuchawki dokanałowe."," Cena: 140 zł", R.drawable.pionner);
            //Google
            insertDataGoogle(db,"Google Pixel 4","Opis: Procesor A14 Bionic. ","Cena: 3200 zł", R.drawable.googlepixelcztery);
            insertDataGoogle(db,"Google Pixel 4a", "Opis: Procesor A13 Bionic.", "Cena: 2899 zł", R.drawable.googlepixelczterya);
            insertDataGoogle(db,"Google Pixel 5", "Opis: Procesor A14 Bionic. ","Cena: 4800 zł", R.drawable.googlepixelpiec);
        }
        if(oldVersion < 2){
            insertDataApple(db," MacBook Pro","Opis: Procesor Apple M1", "Cena: 6799 zł", R.drawable.mcbookpro);
        }
        if(oldVersion < 3){
            insertDataApple(db," MacBook Pro","Opis: Procesor Apple M1", "Cena: 6099 zł", R.drawable.mcbookpro);
        }
        if(oldVersion < 4){
            db.execSQL("ALTER TABLE TOWARAPPLE ADD COLUMN FAVORITE NUMERIC;");
            db.execSQL("ALTER TABLE TOWARGOOGLE ADD COLUMN FAVORITE NUMERIC;");
            db.execSQL("ALTER TABLE TOWARACCESSORIES ADD COLUMN FAVORITE NUMERIC;");
        }
    }
}

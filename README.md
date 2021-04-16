<h1>Aplikacje Mobilne Sprawozdanie nr6</h1>
<hr>
<h2>Baza SQLite i kursory</h2>
<h2>Widok aplikacji</h2>
<h2>Przerobienie aplikazcji z zadanie nr4: Widoki List, wszystkie dane są pobierane z bazy danych SQLite.</h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Screenshot_1618490812.png?raw=true">
<br>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Screenshot_1618490817.png?raw=true">
<br>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Screenshot_1618490820.png?raw=true">
<br>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Screenshot_1618490826.png?raw=true">
<br>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Screenshot_1618490830.png?raw=true">
<br>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Screenshot_1618490834.png?raw=true">
<br>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Screenshot_1618490846.png?raw=true">
<br>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Screenshot_1618490849.png?raw=true">
<br>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Screenshot_1618490853.png?raw=true">
<br>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Screenshot_1618490858.png?raw=true">
<br>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Screenshot_1618490861.png?raw=true">
<br>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Screenshot_1618490864.png?raw=true">
<br>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Screenshot_1618490867.png?raw=true">
<hr>
<br>
<h2>
  Klasa DatabaseHelper. 
  Ta klasa dziedziczy z klasy SQLiteOpenHelper, jest to klasa pomocnicza do zarządzania tworzeniem bazy danych i zarządzania jej wersjami.
  <ul>
    <li>DB_NAME - jest to nazwa naszej bazy danych.</li>
    <li>DB_VERSION - aktualna wersja bazy danych, gdy wprowadzimy zmiany trzeba zwiększyć jej wartość. Musi to być liczba całkowita.</li>
    <li>Metody InsertDataApple i Google i Accessories - są to metody pomocnicze, za ich pomocą dodawane są dane do wierszy.</li>
    <li>Obiekt ContentValues - opisuje on zbiór danych.</li>
    <li>Metoda put() - dane dodaje się do obiektu ContentValues za pomoca metody put().</li>
    <li>SQLiteDatabasa db - jest to baza danych do której dodajemy dane.</li>
    <li>db.insert() - wywołanie wstawiające wiersz danych do tabeli, zawiera ona obiekt ContentValues, który ma dane które mają zostać dodane.</li>
    <li>Metoda onUpgrade() -  jest ona wywoływana gdy trzeba zaktualizować bazę danych.</li>
    <li>Metoda onCreate() - jest wywoływana gdy baza danych zostanie po raz pierwszy utworzona na urządzeniu. Musi ona zawierać cały kod niezbędny do utworzenia bazy danych</li>
  </ul>
</h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Zrzut%20ekranu%202021-04-15%20144836.jpg?raw=true">
<br>
<h2>Zostały utworzone trzy tabele.</h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Zrzut%20ekranu%202021-04-15%20144922.jpg?raw=true">
<br>
<h2>Aktualizacja zostanie przeprowadzona za chwilę.</h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Zrzut%20ekranu%202021-04-15%20144937.jpg?raw=true">
<br>
<hr>
<h2>
<ul>
    <li>Za pomocą kursora odczytujemy dane z bazy danych.</li>
    <li>Aby stworzyć kursor musimy użyć metody query()</li>
    <li>Metoda query() - nawiera parametry opisujące co i skąd ma pobrać. Pierw z jakiej tabeli "TOWARAPPLE", następnie nazwy kolumn.</li>
</ul>
Ten kursor pobiera nazwę, opis, cenę i id zdjęcia.
</h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Zrzut%20ekranu%202021-04-15%20145058.jpg?raw=true">
<br>
<h2>
  W przypadku blędów z połączeniem, zostanie wyświetlona informacja.
</h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Zrzut%20ekranu%202021-04-15%20145111.jpg?raw=true">
<br>
<h2>za pomoca kursora, pobieramy: id oraz nazwę. Dzięki temu można utworzyć listę. Obsługiwaną przez obiekt nasłuchujący.</h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Zrzut%20ekranu%202021-04-15%20145135.jpg?raw=true">
<br>
<h2>
  Metoda onDestroy
<h/2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Zrzut%20ekranu%202021-04-15%20145205.jpg?raw=true">
<br>
<h2> Analogicznie został przerobiony kod reszty klas, odpowiadający za wyświetlanie. 
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Zrzut%20ekranu%202021-04-15%20145320.jpg?raw=true">
<br>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/Zrzut%20ekranu%202021-04-15%20145332.jpg?raw=true">
<br>
  <hr>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/google.jpg?raw=true">
<br>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/google2.jpg?raw=true">
<br>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/googleActivity.jpg?raw=true">
<br>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/Screens/googleActivity2.jpg?raw=true">
<br>
<hr>
<h2>
  Aktualizacja bazy danych 
</h2>
<h2>Wersja tabeli zmieniona na wersję 4</h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/onUpgrade/Zrzut%20ekranu%202021-04-16%20015446.jpg?raw=true">
<br>
<h2>
  Metoda updateDatabase, jest wywoływana przez metodę onUpgrade().
  W pierwszym if'ie została zawarta orginalna baza danych.
  </h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/onUpgrade/Zrzut%20ekranu%202021-04-16%20015512.jpg?raw=true">
<br>
<h2>W kolejnym dodajemy do tabeli TOWARAPPLE nowy wiersz. Zawierający nazwę, opis, cenę oraz id zdjęcia. Ten kod zostanie wykonany jeśli uzywana jest baza danych o numerze wersji równy 1.</h2>
<h2>W ostatnim if'ie dodajemy do tabeli TOWARAPPLE nowy wiersz. Zawierający nazwę, opis, cenę oraz id zdjęcia. Ten kod zostanie wykonany jeśli uzywana jest baza danych o numerze wersji równy 1 lub 2.</h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/onUpgrade/Zrzut%20ekranu%202021-04-16%20015525.jpg?raw=true">
<br>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/onUpgrade/Screenshot_1618530834.png?raw=true">
<br>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/onUpgrade/Screenshot_1618530838.png?raw=true">
<br>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab6/onUpgrade/Screenshot_1618530842.png?raw=true">
<br>
<h2>Obecny numer wersji bazy danych to 4, więc zostaną wykonane dwie modyfikacje bazy danych, polegające na dodaniu nowego produktu.</h2>

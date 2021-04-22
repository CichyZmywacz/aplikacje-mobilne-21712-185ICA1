<h1>Zadania asynchroniczne</h1>
<hr>
<h2>Widok działającej aplikacji.</h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab7/Lab7%20-%20aplikacja/Screenshot_1619111131.png?raw=true">
<br>
<h2></h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab7/Lab7%20-%20aplikacja/Screenshot_1619111135.png?raw=true">
<br>
<h2></h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab7/Lab7%20-%20aplikacja/Screenshot_1619111139.png?raw=true">
<br>
<h2>Dodanie produktu do ulubionych.</h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab7/Lab7%20-%20aplikacja/Screenshot_1619111142.png?raw=true">
<br>
<h2></h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab7/Lab7%20-%20aplikacja/Screenshot_1619111145.png?raw=true">
<br>
<h2></h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab7/Lab7%20-%20aplikacja/Screenshot_1619111147.png?raw=true">
<br>
<h2>Wyświetlanie ulubionych w głównej aktywności.</h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab7/Lab7%20-%20aplikacja/Screenshot_1619111151.png?raw=true">
<br>
<h2>Po kliknięciu w ulubiony produkt, jesteśmy przekierowywani do niego.</h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab7/Lab7%20-%20aplikacja/Screenshot_1619111153.png?raw=true">
<br>
<h2></h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab7/Lab7%20-%20aplikacja/Screenshot_1619111156.png?raw=true">
<br>
<hr>
<h2>
Opis zmian w kodzie, jakie zostały wprowadzone.
Klasa TopLevelActivity:
</h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab7/Lab7%20-%20kod/Zrzut%20ekranu%202021-04-22%20190742.jpg?raw=true">
<br>
<h2></h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab7/Lab7%20-%20kod/Zrzut%20ekranu%202021-04-22%20190803.jpg?raw=true">
<br>
<h2>Został zmierzony czas jaki potrzebuje metoda setupFavoritesListView na zaktualizowanie bazy danych. Podsumowanie czasów będzie ostatnim punktem w sprawozdaniu.</h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab7/Lab7%20-%20kod/Zrzut%20ekranu%202021-04-22%20190818.jpg?raw=true">
<br>
<h2>

<ul>
  <li>onFavoriteClicked - ta metoda obsługuje kliknięcia Ulubiony, zapisywany jest ID produktu i przekazywany do klasy wewnętrznej UpdateAppleTask</li>
  <li>Klasa UpdateAppleTask - jest to klasa wewnętrzna, która dziedziczy po AsyncTask</li>
  <li>onPreExecute - jest to metoda, która wywoływana jest przedrozpoczęciem wykonywania zadania. Jest ona wykonywana w głównym wątku aplikacji. Ta metoda nie ma paramatrów, zwraca wynik void.</li>
  <li>doInBackground - ta metoda wykonywana jest w tle, bezpośrednio po metodzie onPreExecute. Wybieramy jakiego typu będzie ta metoda, i jaki typ będzie zwracać.</li>
  <li>onPostExecute - wywoływana w głównym wątku aplikacji, stosowana do obsługi zdarzeń. Programista ma możliwość wyboru typu parametrów tej metody.</li>
  <li>Params - jest to typ parametrów wysyłanych do zadania po jego wykonaniu.</li>
  <li>Progress - jest to rodzaj jednostek postępu opublikowanych podczas obliczeń w tle.</li>
  <li>Result - typ wyniku obliczeń w tle.</li>
  <li>W moim przypadku Params to Integer (metoda doInBackground), Result to Boolean (metoda onPostExecute), a Progress to Void</li> 
</ul>

</h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab7/Lab7%20-%20kod/Zrzut%20ekranu%202021-04-22%20190904.jpg?raw=true">
<br>
<h2></h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab7/Lab7%20-%20kod/Zrzut%20ekranu%202021-04-22%20190927.jpg?raw=true">
<br>
<h2></h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab7/Lab7%20-%20kod/Zrzut%20ekranu%202021-04-22%20190941.jpg?raw=true">
<br>
<hr>
<h2>Porównanie czasów dla aplikacji bez klasy AsyncTask i z użyciem tej klasy</h2>
<h2> 
Czas bez klasy AsyncTask 
Czas to 7 ms.
</h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab7/Lab7%20-%20kod/CzasA.jpg?raw=true">
<br>
<h2>
Czas z klasy AsyncTask
Wynik to 5058900, po podzieleniu przez 1000000 (aby otrzymac wynik w ms) to otrzymamy 5,0589.
</h2>
<img src="https://github.com/michalGryczewski1998/aplikacje-mobilne-21712-185ICA1/blob/Lab7/Lab7%20-%20kod/CzasB.jpg?raw=true">
<h2> Jak widac klasa AsyncTask przyspieszyła działanie aplikacji podczas operacji dodania produktu jako ulubionego.
Wynik tej operacji bez klasy AsyncTask to 7 ms, a wynik tej samej operacji z klasą Asynctask to już tylko 5ms </h2>

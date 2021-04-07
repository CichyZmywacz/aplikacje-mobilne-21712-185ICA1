<h1>Aplikacje Mobilne Sprawozdanie nr5</h1>
<hr>
<h2>Fragmenty</h2>
<h2>Widok aplikacji</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20171658.jpg?raw=true">
<br>
<h2>Po kliknięciu wyświetlają się informacje oraz stoper zawarty we fragmencie zagnieżdżony w innym fragmencie.</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20171713.jpg?raw=true">
<br>
<h2>Działanie stopera.</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20171726.jpg?raw=true">
<br>
<h2>Działanie wyłączenia stopera.</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20171737.jpg?raw=true">
<br>
<h2>Analogicznie wygląda aktywność druga.</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20171755.jpg?raw=true">
<br>
<hr>
<h2>Opisany kod MainActivity</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20171810.jpg?raw=true">
<br>
<h2>Kod XML aktywności activity_main</h2>
<h2>Jak widać zawiera ona tylko fragment.</h2>
<h2>Za pomocą android:name wskazujemy konkretny fragment jaki ma się wyświetlać w tej aktywności.</h2>
<h2>Jeżeli tego nie zrobimy, a mamy tylko jeden fragment. To Java domyślnie go użyje, w przypadku większej ilości fragmentów. Trzeba używać android:name i wskazywać jeden konkretny.</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20171822.jpg?raw=true">
<br>
<h2>Kod CarListFragment + opisy kodu w komentarzach.</h2>
<h2>Na tym screenie widać interfejs nasłuchujący oraz kod fragmenty wygenerowany automatycznie.</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20171956.jpg?raw=true">
<br>
<h2>Dopisany kod wraz z opisem w komentarzach.</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20172031.jpg?raw=true">
<br>
<h2>Kod XML fragmenty</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20172041.jpg?raw=true">
<br>
<h2>Kod CardetailFragment wraz z opisem w komentarzach.</h2>
<h2>Metoda onStart() jest wywoływana bezpośrednio przed wyświetleniem fragmentu.</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20172125.jpg?raw=true">
<br>
<h2>Kod CarDetailFragment + opis w komentarzach.</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20172138.jpg?raw=true">
<br>
<h2>Kod XML fragment_car_detail.</h2>
<h2>Użyłem TableLayout, aby wszystkie itemy poukładać. Użyłem min. android:gravity aby każdy item zajmował odpowiednie miejsce.</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20172155.jpg?raw=true">
<br>
<h2>Kod CarDetail + opis</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20172348.jpg?raw=true">
<br>
<h2>Kod XML activity_car_detail</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20172357.jpg?raw=true">
<br>
<h2>Kod klasy Cars, która przechowuje wszystkie dane o aucie. Klasa została zrobiona tak jak na poprzednich projektach. Dane są w tablicy, a uzysujemy dane za pomocą get'ów. Które służą do pozyskiwania danych ze zmiennych prywatnych.</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20172503.jpg?raw=true">
<br>
<h2>Kod TempActivity wraz z opisem w komentarzach.</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20172527.jpg?raw=true">
<br>
<h2>Kod XML activity_temp</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20172536.jpg?raw=true">
<br>
<h2>Kod StopwatchFragment wraz z opisem</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20172612.jpg?raw=true">
<br>
<h2></h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20172644.jpg?raw=true">
<br>
<h2>Kod XML fragment_stopwatch</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20172656.jpg?raw=true">
<br>
<h2></h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20172708.jpg?raw=true">
<br>
<hr>
<h2>W tym zadaniu wykorzystałem trzy fragmęty, z czego jeden to fragment zagnieżdżony w innym fragmencie</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab5/Photos/Zrzut%20ekranu%202021-04-07%20180139.jpg?raw=true">


<h1>Sprawozdanie: Widoki i grupy widoków w różnych układach (Lab3 Java + AndroidStudio)</h1>
<hr>
<h2>Widok aplikacji</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab3/Photos/Zrzut%20ekranu%202021-03-19%20125907.png?raw=true">
<br>
<h2>Działanie aplikacji.</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab3/Photos/Zrzut%20ekranu%202021-03-19%20130030.png?raw=true">
<br>
<h2>Widok aplikacji, aktywnośc nr2</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab3/Photos/Zrzut%20ekranu%202021-03-19%20130105.png?raw=true">
<br>
<h2>Switch zmieniający zdjęcie.</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab3/Photos/Zrzut%20ekranu%202021-03-19%20130407.png?raw=true">
<br>
<h2>Wyłączony wyświetli inne zdjęcie</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab3/Photos/Zrzut%20ekranu%202021-03-19%20130419.png?raw=true">
<br>
<h2>ImageButton, działa jako przycisk powrotny do aktywności głównej</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab3/Photos/Zrzut%20ekranu%202021-03-19%20130431.png?raw=true">
<br>
<hr>
<h2>Kod z apliku activity_main.xml</h2>
<h2>
<ul>
<li>Przycisk Dalej wyświetlany jest na górze strony, rozciągnięty od lewej do prawej aby zajmował całą szerokość aplikacji.</li>
<li>TextWiev przypisany do lewej strony, oraz wyświetlany pod przyciskiem Dalej. Za pomocą app:layout_constraintTop_toBottomOf="@+id/button3"</li>
<li>CheckBox'sy wyświetlane są jeden pod drugim za pomocą app:layout_constraintTop_toBottomOf="@+id/tekstOpis" (<- pod opisem), app:layout_constraintTop_toBottomOf="@+id/checkBoxCola" (<- CheckBox2 wyświetlany pod CheckBox1). </li>
<li>Przycisk Wynik wyświetlany pod drugim CheckBox'em za pomoca app:layout_constraintTop_toBottomOf="@id/checkBoxPepsi"</li>
<li>RadioGroup zawiera dwa przyciski typu radioButton. Wyświetlane są one jeden pod drugim za pomocą RadioGroup.</li>
<li>TextView dla RadioButton'ów, wyświetlany pod radioGroup za lewej. Za pomocą app:layout_constraintTop_toBottomOf="@+id/radioGroup"</li>
<li>Spinner, lista rozwijana. Wyśrodkowana za pomocą app:layout_constraintEnd_toEndOf="parent" oraz app:layout_constraintStart_toStartOf="parent". Wyświetla się pod textWiew dla radioButton'ów za pomoca app:layout_constraintTop_toBottomOf="@id/textViewRadioButton"</li>
</ul>
</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab3/Photos/Zrzut%20ekranu%202021-03-19%20130736.png?raw=true">
<br>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab3/Photos/Zrzut%20ekranu%202021-03-19%20130801.png?raw=true">
<br>
<h2></h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab3/Photos/Zrzut%20ekranu%202021-03-19%20130834.png?raw=true">
<br>
<h2>Plik MainActivity wraz z opisem w komentarzach.</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab3/Photos/Zrzut%20ekranu%202021-03-19%20142158.png?raw=true">
<br>
<h2></h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab3/Photos/Zrzut%20ekranu%202021-03-19%20142218.png?raw=true">
<br>
<h2></h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab3/Photos/Zrzut%20ekranu%202021-03-19%20142249.png?raw=true">
<br>
<h2>Plik main_activity_two.xml</h2>
<h2>
<ul>
<li>ImageButton, umieszczony na dole strony z lewj. Za pomoca android:layout_gravity="bottom"</li>
<li>ImageView umieszczony na górze aplikacja za pomocą android:layout_gravity="top"</li>
<li>Switch umieszczony w górnym prawym rogu za pomocą android:layout_gravity="top|end"</li>
<li>Przycisk TOAST umieszczony w prawym dolnym rogu, za pomocą android:layout_gravity="right|bottom"</li>
<li>ScrollView i TextView. ScrollView został wyśrodkowany za pomocą android:layout_gravity="center"></li>
</ul>
</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab3/Photos/Zrzut%20ekranu%202021-03-19%20142311.png?raw=true">
<br>
<h2></h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab3/Photos/Zrzut%20ekranu%202021-03-19%20142327.png?raw=true">
<br>
<h2>MainActivityTwo.java wraz z opisem kodu.</h2>
<img src="https://github.com/CichyZmywacz/aplikacje-mobilne-21712-185ICA1/blob/Lab3/Photos/Zrzut%20ekranu%202021-03-19%20143326.png?raw=true">
<br>
<hr>
<b2>Wnioski</h2>
<ul>
<li>android:layout_gravity - określa, w jaki sposób komponent powinien być umieszczony w grupie komórek. Tzn. określa położenie komponentu na ekranie</li>
<li>android:layout_width - Określa podstawową szerokość widoku. </li>
<li>android:layout_height - Określa podstawową wysokość widoku. </li>
<li>app:layout_constraintTop_toBottomOf - umieszcza komponent pod innym komponentem za pomocą id.</li>
</ul>

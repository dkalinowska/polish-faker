# Polski generator danych
## Wstęp
*Polski generator danych* to narzędzie stworzone z myślą o polskich testerach automatyzujących, służące do generowania fałszywych numerów identyfikacyjnych oraz innych losowych danych przydatnych do testowania formularzy.

## Koncepcja, idea
Główną ideą stojącą za zrealizowaniem konkretnie takiego tematu w ramach projektu indywidualnego była chęć zwiększenia jakości własnej pracy.
Jako tester automatyzujący każdego dnia używam generatorów fałszywych danych, które zwyczajnie nie spełniają w pełni moich oczekiwań.
Uważam, że formularz w języku polskim, na polskiej stronie, uzupełniony danymi w języku angielskim wygląda... dziwnie.
Implementowanie generatorów poprawnych identyfikatorów "na bieżąco", w zastępstwo realizacji zadań, przy każdym nowym projekcie, też mija się z celem.
Musiałam wziąć sprawy w swoje ręce i stworzyć generator zaspokajający moje potrzeby. Taki generator na miarę moich możliwości.

## Funkcjonalności
### Generowanie fałszywych, poprawnych numerów identyfikacyjnych
Generator udostępnia metody zwracające poprawne, zgodne z normami, przechodzące walidację numery identyfikacyjne.
Dostępne moduły:
1. KRS
2. Numer księgi wieczystej
3. NIP
4. Numer dowodu osobistego
5. PESEL
6. REGON
   
### Pobieranie losowych danych z plików YAML
Generator pozwala również na pozyskiwanie losowych danych adresowych bądź personalnych, a także dat i losowych słów dotyczących nieco przyjemniejszych rzeczy
Dostępne moduły:
1. Data
2. Ulica
3. Kod pocztowy
4. Miasto
5. Powiat
6. Województwo
7. Kraj
8. Imię i nazwisko
9. Numer telefonu
10. Adres email
11. Zwierzę
12. Jedzenie
13. Roślina

### Bardzo szybka reprezentacja przykładowych funkcjonalności i ogólnego sposobu dostępu do generatorów:

[![Prezentacja funkcjonalności](https://img.youtube.com/vi/Qkw9HB2dmjk/0.jpg)](https://www.youtube.com/watch?v=Qkw9HB2dmjk)

## Struktura kodu
Projekt tworzony był z dbałością o przestrzeganie paradygmatów programowania obiektowego. Klasy podzielone są na tematyczne pakiety, nawigowanie po projekcie jest proste i intuicyjne,
projekt bez problemu może być poszerzany o kolejne moduły. 

## Dostęp do metod generatora
Działanie generatora opiera się na odwoływaniu się do singletonu FAKER, który umożliwia dostęp do wszysktich klas generujących dane.
Wszystkie metody (poza generatorem dat z przedziału) są bezparametrowe i zwracają obiekty typu String.
Gwarantuje to proste i intuicyjne korzystanie z generatora nawet bez znajomości jakichkolwiek szczegółów, składnia oparta jest w głównej mierze na język naturalny,
a oprócz tego zarówno klasy jak i metody publiczne opisane są stosownymi elementami Javadoc.

## Plany na przyszłość
Projekt okazał się mieć ogromny potencjał jako rzeczywiste, użyteczne narzędzie, które chcę rozwijać w przyszłości.
Planuję rozszerzyć narzędzie o dodatkowe moduły generujące losowe i fałszywe dane, a także inne, nowe funkcjonalności.

1. Dodanie generatorów dla numerów IBAN i numerów paszportów
2. Udoskonalenie generatorów losowych adresów e-mail i dodanie modułu generującego loginy i hasła
3. Rozwój projektu jako narzędzie testerskie — implementacja metod generujących (celowo) niepoprawne identyfikatory
4. Stworzenie modułu zwracającego nazwiska polskich postaci historycznych
5. Implementacja modułów generujących losowe paragrafy typu <i>Lorem ipsum</i>
6. Dalsze wsparcie generatora i dużo miejsca na realizację przyszłych pomysłów dzięki wysokiej rozszerzalności projektu i łatwości poszerzania o nowe moduły

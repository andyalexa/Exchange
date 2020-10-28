# Exchange Rates 

Codul sursă pentru un program cu interfață grafică realizat în Java cu ajutorul căruia se poate vizualiza raportul de creștere sau de scădere dintre orice pereche de monede furnizată de API-ul [exchangerates](https://www.exchangeratesapi.io/).

## Utilizare
Pentru a utiliza acest program, descărcați cea mai nouă versiune de la [AnyPair - releases](https://github.com/andyalexa/Exchange/releases/tag/v2.0) și după dezarhivarea fișierului **release_v2.zip** rulați fișierul **start.bat** și urmăriți instrucțiunile prezentate în consolă, o alternativă ar fi rularea directă a fișierului **Exchange-1.0-SNAPSHOT-jar-with-dependencies.jar** pentru a sări peste opțiunea de a opri interfața grafică.

Dacă nu se dorește utilizarea interfeței grafice și pentru un anumit motiv nu se poate folosi fișierul **start.bat** atunci se poate adăuga argumentul "no_gui" la fișierul **.jar**.

### Afișarea informațiilor
Informațiile despre o rată de schimb la o anumită dată sunt afișate sub forma asta: 
(AN-LUNA-ZI) _VALOARE_ MONEDĂ_DE_BAZĂ -> MONEDĂ_DE_COMPARARE _VALOARE_ [**DIFERENȚĂ**]

Spre exemplu: 
(2018-12-11) 1,0000 EUR -> RON 4,6557 [-0,0032]

Diferența poate fi succesivă sau cu bază fixă pe prima rată a anului.
 

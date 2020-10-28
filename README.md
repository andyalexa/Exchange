# Exchange Rates 

Codul sursă pentru un program cu interfață grafică realizat în Java cu ajutorul căruia se poate vizualiza raportul de creștere sau de scădere dintre orice pereche de monede furnizată de API-ul [exchangerates](https://www.exchangeratesapi.io/).

## Utilizare
Pentru a utiliza acest program, descărcați cea mai nouă versiune de la [AnyPair - releases](https://github.com/andyalexa/Exchange/releases/tag/v2.0) și după dezarhivarea fișierului **release_v2_1.zip** rulați fișierul **start.bat** și urmăriți instrucțiunile prezentate în consolă, o alternativă ar fi rularea directă a fișierului **Exchange-2.1.jar** pentru a sări peste opțiunea de a opri interfața grafică.

Dacă nu se dorește utilizarea interfeței grafice și pentru un anumit motiv nu se poate folosi fișierul **start.bat** atunci se poate adăuga argumentul "no_gui" la fișierul **.jar**.

### Afișarea informațiilor
Structura output-ului este  următoarea:
In anul {_ANUL_} {_MONEDA DE BAZĂ_} în raport cu {_MONEDA DE COMPARAȚIE_} a crescut de {_X_} ori si a scazut de {_Y_} ori

Spre exemplu:
In anul _2017_ _EUR_ in raport cu _RON_ a crescut de _123_ ori si a scazut de _129_ ori

Dacă se dorește afișarea operațiunilor prin selectarea acestei opțiuni, acestea vor fi afișate sub forma asta:
(AN-LUNA-ZI) _VALOARE_ MONEDĂ_DE_BAZĂ -> MONEDĂ_DE_COMPARARE _VALOARE_ [**DIFERENȚĂ**]

Spre exemplu: 
(2018-12-11) 1,0000 EUR -> RON 4,6557 [-0,0032]
 

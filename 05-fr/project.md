
# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.([UC2](#uc2))

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC2](#uc1): Nadanie produktu kupującemu

[Kupujący](#ac2)
* [UC*] Przegląd dostępnych aukcji
* [BR1](#ac2): Zaproponowanie kwoty za przedmiot większej od poprzedniej kwoty, lub kwoty wywoławczej
* (#ac2): Przekazanie należności sprzedającemu

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Podbicie stawki poprzez użytkownika

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. System wyświetla dostępne produkty
2. [Kupujący](#ac2) znajduje interesujący go produkt
3. [Kupujący](#ac2) zgłasza chęć licytacji i podaje kwotę
4. System sprawdza poprawność danych i aktualizuję kwotę na licytacji
5. System informuje kupującego o pomyślnym przebiciu oferty 

**Scenariusze alternatywne:** 

1.A. Podano niższą/niepoprawną kwotę
* 4.A.1. System prosi o wpisanie poprawnej kwoty i kieruje do kroku 3


<a id="uc3"></a>
### UC3: Przekazanie pieniędzy przez wygrywającego licytację

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2) 

**Scenariusz główny:**
1. System wysyła wiadomosc do zwycięzkiego kupującego z informacją o wygranej i terminie płatności
2. [Kupujący](#ac2) Wygrany kupujący wykonuje płatność na rzecz sprzedającego
3. System sprawdza po upływie terminu czy dokonano płatności

**Scenariusze alternatywne:** 

2.A. Nieprzekazanie pieniędzy przez kupującego
* 1.A.1. System zgłasza się do osoby która zaraz po pierwszej wystawiła największą kwotę

<a id="uc4"></a>
### UC4: Nadanie paczki do wygrywającego

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. System zgłasza sprzedawcy dane kupującego oraz dane aukcji oraz opcje wysyłki
2. [Sprzedający](#ac1) wybiera usługodawcę kurierskiego

**Scenariusze alternatywne:** 

1.A. Paczka niedoręczona/zagubiona
* 4.A.1. Zwrot pieniędzy na konto kupującego

---

## Obiekty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                           | Aukcja | Produkt | 
| -----------------------------------------------------------| ------ | ------- |
| UC1: Wystawienia produktu na aukcję                        |    C   |    C    |
| UC2: Podbicie stawki poprzez użytkownika                   |    U   |    -    | 
| UC3: Przekazanie pieniędzy przez wygrywającego licytację   |   R,U  |    R    | 
| UC4: Nadanie paczki do wygrywającego                       |        |         | 
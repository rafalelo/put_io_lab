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
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

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
* [UC2](#uc1): Uzyskanie danych do wysyłki kupującego
* [UC3](#uc3): Usunięcie aukcji (przez pierwszą godzinę od wystawienia)

[Kupujący](#ac3)
* [UC4](#ac4) Złożenie oferty za produkt
* [UC5](#ac5) Uregulowanie płatności za produkt wygrany na aukcji
* [UC6](#ac6) Wyszukiwanie aktualnie trwających aukcji


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
### UC2: Uzyskanie danych do wysyłki kupującego

**Aktorzy:** [Sprzedający](#ac2), [Kupujący](#ac2), ...

**Scenariusz główny:**
1. [Sprzedający](#ac2) zgłasza do systemu chęć wyświetlenia informacji o aukcji.
2. System wyświetla informacje o aukcji (w których znajdują się dane kupującego)


**Scenariusze alternatywne:** 

2.A. Aukcja nie jest jeszcze zakończona
* 2.A.1. System wyświetla informacje w których nie ma informacji o kupującym

---

<a id="uc3"></a>
### UC3: Usunięcie aukcji (przez pierwszą godzinę od wystawienia)

**Aktorzy:** [Sprzedający](#ac3)

**Scenariusz główny:**
1. [Sprzedający](#ac3) zgłasza do systemu chęć usunięcia aukcji.
2. System sprawdza czy aukcja nie trwa dłużej niż godzina.
3. System prosi o potwierdzenie usunięcia.
4. [Sprzedający](#ac3) potwierdza chęć usunięcia.
5. System wyświetla informację o pomyślnym usunięciu.


**Scenariusze alternatywne:** 

2.A. Aukcja trwa dłużej niż godzina
* 2.A.1. System wyświetla informacje, że usunięcie nie jest już możliwe

---

<a id="uc4"></a>
### UC4: Złożenie oferty za produkt

**Aktorzy:** [Kupujący](#ac4)

**Scenariusz główny:**
1. [Kupujący](#ac4) zgłasza chęć złożenia oferty.
2. System prosi o podanie kwoty.
3. [Kupujący](#ac4) podaję kwotę za produkt na aukcji.
4. System sprawdza czy aukcja jest jeszcze aktywna.
5. System sprawdza czy podana przez kupującego kwota jest wyższa od poprzedniej oferty.
6. System podaje informację o pomyślnym złożeniu oferty
7. System zmienia aktualną cenę na ofertę złożoną przez kupującego



**Scenariusze alternatywne:** 

3.A. Aukcja nie jest już aktywna
* 3.A.1. System wyświetla informacje, że złożenie oferty nie jest możliwe, ponieważ aukcja nie jest już aktywna.

4.A. Podana przez kupującego kwota nie jest wyższa do najwyższej oferty
* 4.A.1 System wyświetla informację, że podana kwota jest za niska
* 4.A.1 Przejdź do kroku 2.

---


<a id="uc5"></a>
### UC5: Uregulowanie płatności za produkt wygrany na aukcji

**Aktorzy:** [Kupujący](#ac5)

**Scenariusz główny:**
1. [Kupujący](#ac5) zgłasza chęć uregulowania płatności.
2. System przekierowuje użytkownika na zewnętrzną stronę przelewy24.
3. Po uregulowaniu płatności użytkownik zostaje przekierowany z powrotem na stronę sklepu.
4. System sprawdza czy płatność powiodła się.
5. System wyświetla informacją o pomyślnej płatności.


**Scenariusze alternatywne:** 

3.A. Płatność nie powiodła się
* 3.A.1. System wyświetla informacje, że płatność się nie udała

---

<a id="uc6"></a>
### UC5: Wyszukiwanie aktualnie trwających aukcji

**Aktorzy:** [Kupujący](#ac56)

**Scenariusz główny:**
1. [Kupujący](#ac5) zgłasza chęć wyszukania aukcji.
2. System prosi o podanie frazy do wyszukania.
3. [Kupujący](#ac5) podaje frazę.
4. System sprawdza czy istnieją aukcje zawierające wyszukaną frazę.
5. System wyświetla wyszukane aukcje.


**Scenariusze alternatywne:** 

4.A. Nie istnieje aukcja zawierającą w nazwię podaną frazę
* 4.A.1. System wyświetla informacje, że nie udało się znaleźć żadnej aukcji
* 4.A.2. Przejdź do kroku 2.
---

## Obiekty biznesowe (inaczej obiekty dziedzinowe lub informacyjne)

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


| Przypadek użycia                                  | Aukcja | Produkt | ... |
| ------------------------------------------------- | ------ | ------- | --- |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    | ... |
| ???                                               |  ...   |  ...    | ... |



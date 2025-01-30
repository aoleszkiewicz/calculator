## Cel Projektu
Celem projektu było stworzenie funkcjonalnego kalkulatora z interfejsem graficznym, implementującego podstawowe oraz zaawansowane operacje matematyczne. Projekt został zrealizowany w języku Java z wykorzystaniem JavaFX do stworzenia interfejsu użytkownika.

## Struktura Projektu
Projekt został zorganizowany w następujący sposób:

```
src/
└── main/
    ├── java/
    │   └── lab/
    │       └── calc/
    │           └── calculator/
    │               ├── Main.java             # Klasa główna inicjalizująca aplikację
    │               ├── Calculator.java       # Interfejs definiujący podstawowe operacje
    │               ├── CalculatorImpl.java   # Implementacja interfejsu Calculator
    │               ├── MainController.java   # Kontroler obsługujący logikę UI
    │               └── Operation.java        # Enum definiujący dostępne operacje
    └── resources/
        └── lab/
            └── calc/
                └── calculator/
                    └── Main.fxml            # Definicja interfejsu użytkownika
```

## Funkcjonalności

### Podstawowe Operacje
- Dodawanie (+)
- Odejmowanie (-)
- Mnożenie (*)
- Dzielenie (/)

### Operacje Zaawansowane
- Pierwiastek kwadratowy (√)
- Procent (%)
- Potęgowanie do kwadratu (x²)
- Potęgowanie do sześcianu (x³)
- Silnia (x!)
- Logarytm naturalny (log)
- Odwrotność liczby (1/x)

## Szczegóły Implementacji

### Interfejs kalkulatora
```java
public interface Calculator {
    void setOperation(Operation operation);
    void setNumber(Double number);
    void setNextNumber(Double number);
    Double calculate();
    void clear();
}
```

### Implementacja interfejsu kalkulatora
Klasa `CalculatorImpl` implementuje interfejs `Calculator` i zawiera główną logikę kalkulatora. Oto jej najważniejsze elementy:

#### Pola klasy:
```java
private Operation operation;  // Aktualnie wybrana operacja
public double num1;          // Pierwsza liczba do obliczeń
public double num2;          // Druga liczba do obliczeń
public double total;         // Wynik operacji
```

#### Główne metody:
1. **Konstruktor** - inicjalizuje kalkulator z wartościami domyślnymi
2. **calculate()** - implementuje logikę wszystkich operacji matematycznych:
   - Operacje dwuargumentowe (ADD, SUBTRACT, MULTIPLY, DIVIDE)
   - Operacje jednoargumentowe (SQRT, PERCENT, LOG, REVERSE)
   - Operacje potęgowania (SQUARED, CUBED)
   - Operacja silni (FACTORIAL)

#### Obsługa błędów:
- Sprawdzanie dzielenia przez zero
- Walidacja argumentów dla silni (liczby nieujemne i całkowite)
- Obsługa przepełnienia przy obliczaniu silni
- Zwracanie NaN dla nieprawidłowych operacji

### Enum Operation
Typ wyliczeniowy `Operation` definiuje wszystkie dostępne operacje kalkulatora:

```java
public enum Operation {
    NULL,       // Stan początkowy/pusty
    ADD,        // Dodawanie
    SUBTRACT,   // Odejmowanie
    MULTIPLY,   // Mnożenie
    DIVIDE,     // Dzielenie
    SQRT,       // Pierwiastek kwadratowy
    REVERSE,    // Odwrotność liczby (1/x)
    LOG,        // Logarytm naturalny
    PERCENT,    // Procent
    SQUARED,    // Kwadrat liczby
    CUBED,      // Sześcian liczby
    FACTORIAL   // Silnia
}
```

## Uruchamianie
```bash
mvn clean javafx:run
```

### Obsługa Błędów
- Zabezpieczenie przed dzieleniem przez zero
- Walidacja danych wejściowych
- Obsługa nieprawidłowych operacji
- Formatowanie wyników z użyciem odpowiedniej precyzji
  
## Wnioski
Projekt kalkulatora demonstruje praktyczne zastosowanie:
- Programowania obiektowego
- Wzorców projektowych
- Interfejsu graficznego
- Obsługi wyjątków
- Formatowania danych

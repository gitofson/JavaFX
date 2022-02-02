package cz.spsmb.w21.properties;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
// Vlastnosti dávají možnost zaregistrovat třídu ChangeListener k přijímání událostí změn. Změna vlastnosti je spuštěna
// vždy, když se hodnota vlastnosti změní. Metoda changed() dostává 3 hodnoty: referenci na vlastnost objektu,
// starou hodnotu a novou hodnotu.
public class AChangeTest {
    public static void main(String[] args) {
        IntegerProperty counter = new SimpleIntegerProperty(100);

        // Add a change listener to the counter property
        counter.addListener(AChangeTest::changed);

        System.out.println("\nBefore changing the counter value-1");
        counter.set(101);
        System.out.println("After changing the counter value-1");

        System.out.println("\nBefore changing the counter value-2");
        counter.set(102);
        System.out.println("After changing the counter value-2");

        // Try to set the same value
        System.out.println("\nBefore changing the counter value-3");
        counter.set(102); // No change event is fired.
        System.out.println("After changing the counter value-3");

        // Try to set a different value
        System.out.println("\nBefore changing the counter value-4");
        counter.set(103);
        System.out.println("After changing the counter value-4");
    }

    public static void changed(ObservableValue<? extends Number> prop,
                               Number oldValue,
                               Number newValue) {
        System.out.print("Counter changed: ");
        System.out.println("Old = " + oldValue + ", new = " + newValue);
    }
}

package cz.spsmb.w21.bindings;

import javafx.beans.binding.StringBinding;
import javafx.beans.binding.When;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

// ternární operátor (podmínka?hodnota1:hodonta2) je reprezentován v JavFX třídou When.
// syntaxe: new When(podmínka).then(hodnota1).otherwise(hodnota2)
// podmínka musí být typu ObservableBooleanValue. Hodnoty můžou být buď konstanty, nebo instance třídy implementující rozhraní  ObservableValue.
// Typy hodnot musí být stejné.
public class HTernaryTest {
    public static void main(String[] args) {
        IntegerProperty num = new SimpleIntegerProperty(10);
        StringBinding desc = new When(num.divide(2).multiply(2).isEqualTo(num))
                .then("even (sudá)")
                .otherwise("odd (lichá)");
        System.out.println(num.get() + " is " + desc.get());
        num.set(19);
        System.out.println(num.get() + " is " + desc.get());
    }
}

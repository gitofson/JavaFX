package cz.spsmb.w21.bindings;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

//Bindování (binding) - automatické přepočítávání výsledné hodnoty v závislosti na změnách
// vstupů
// jsou dvě možnosti:
// eager binding - přepočítám okamžitě, jakmile se jedna ze vstupnách hodnot změní
// lazy (líné) binding - přepočítám v okamžiku, kdy výslednou hodnotu požaduji. Do té doby
// se po změně vstupu vygeneruje událost zneplatnění
public class ABindingTest {
    public static void main(String[] args) {
        IntegerProperty x = new SimpleIntegerProperty(100);
        IntegerProperty y = new SimpleIntegerProperty(200);

        //Create binding: sum = x + y;
        NumberBinding sum = x.add(y);

        System.out.println("Po vytvoření sumy");
        System.out.println("sum.isValid(): " + sum.isValid());
        int value = sum.intValue();
        System.out.println("\n po vydání hodnoty");
        System.out.println("sum.isValid(): " + sum.isValid());
        System.out.println("sum = " + value);
        
        //změna vstupu x
        x.set(250);
        System.out.println("Po změně x");
        System.out.println("sum.isValid(): " + sum.isValid());
        //znovu obdržéme hodnotu (a tím přepočítáme sum)
        value = sum.intValue();
        System.out.println("\n po vydání hodnoty");
        System.out.println("sum.isValid(): " + sum.isValid());
        System.out.println("sum = " + value);
    }
}

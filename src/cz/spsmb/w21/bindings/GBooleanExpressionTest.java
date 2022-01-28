package cz.spsmb.w21.bindings;

import javafx.beans.binding.BooleanExpression;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class GBooleanExpressionTest {
    public static void main(String[] args) {
        IntegerProperty x = new SimpleIntegerProperty(1);
        IntegerProperty y = new SimpleIntegerProperty(2);
        IntegerProperty z = new SimpleIntegerProperty(3);
        //vytvoření boolean výrazu x > y && y != z
        BooleanExpression condition = x.greaterThan(y).and(y.isNotEqualTo(z));
        System.out.println(condition.get());
        //validace podmínky (nastavením x na 3)
        x.set(3);
        System.out.println(condition.get());
    }

}
